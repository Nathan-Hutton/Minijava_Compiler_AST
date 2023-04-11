package edu.westminstercollege.cmpt355.minijava;

import java.util.*;

public class SymbolTable {

    enum Level {
        Class, Method, Block
    }

    private Level level;
    private SymbolTable parent;
    private Map<String, Variable> variables = new HashMap<>();
    private int variableIndex = 0;

    public SymbolTable(Level level) {
        this.level = level;
    }
    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }
    public Variable registerVariable(String name) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name);
            variables.put(name, v);
        }

        return v;
    }

    public Optional<Variable> findVariable(String name) {
        // If we look up a variable in a symbol table and don't find it, then we go
        // up to the parent and chack there.

        var maybeVar = Optional.ofNullable(variables.get(name));
        var ancestor = parent;

        while (maybeVar.isEmpty()) {
            if (ancestor != null) {
                maybeVar = parent.findVariable(name);
            }
            else
                break;
        }

        return maybeVar;
    }

    public int getVariableCount() {
        return variableIndex;
    }
    public int allocateLocalVariable(int size) {

        // Only a Method-level ST can allocate a variable
        if (level == Level.Method) {
            int temp = variableIndex;
            variableIndex += size;
            return temp;
        }
		else if (level == Level.Block)
            // bump it up a level
            return parent.allocateLocalVariable(size);
        else
            throw new RuntimeException("Internal compiler error: symbol table weirdness!");
    }
    public Optional<Class<?>> findJavaClass(String className) {
        Optional<Class<?>> first = Reflect.classForName(className);
        if (first.isPresent())
            return first;

        Optional<Class<?>> second = Reflect.classForName("java.lang." + className);
        if (second.isPresent())
            return second;

        return Reflect.classForName("java.util." + className);
    }
    public Optional<Class<?>> classFromType(Type type) {
        if (type.equals(PrimitiveType.Int))
            return Optional.of(int.class);
        else if (type.equals(PrimitiveType.Double))
            return Optional.of(double.class);
        else if (type.equals(PrimitiveType.Boolean))
            return Optional.of(boolean.class);
        else if (type.equals(VoidType.Instance))
            return Optional.of(void.class);
        return findJavaClass(type.toString());
    }
    public Optional<Field> findField(ClassType classType, String fieldName) {
        Optional<Class<?>> clazz = classFromType(classType);
        if (clazz.isPresent())
            return Reflect.findField(classFromType(classType).orElseThrow(), fieldName);
        return Optional.empty();
    }
    public Optional<Method> findMethod(ClassType classType, String methodName, List<Type> parameterTypes) {
        List<Class<?>> javaParameterTypes = new ArrayList<>();
        for (Type parameterType : parameterTypes) {
            Optional<Class<?>> javaParameterType = classFromType(parameterType);
            if (javaParameterType.isPresent()) {
                javaParameterTypes.add(javaParameterType.get());
            } else {
                return Optional.empty();
            }
        }
        Optional<Class<?>> javaClass = findJavaClass(classType.getClassName());
        if (javaClass.isPresent()) {
            return Reflect.findMethod(javaClass.get(), methodName, javaParameterTypes);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Method> findConstructor(ClassType classType, List<Type> parameterTypes) {
        List<Class<?>> javaParameterTypes = new ArrayList<>();
        for (Type parameterType : parameterTypes) {
            Optional<Class<?>> javaParameterType = classFromType(parameterType);
            if (javaParameterType.isPresent()) {
                javaParameterTypes.add(javaParameterType.get());
            } else {
                return Optional.empty();
            }
        }
        Optional<Class<?>> javaClass = findJavaClass(classType.getClassName());
        if (javaClass.isPresent()) {
            return Reflect.findConstructor(javaClass.get(), javaParameterTypes);
        } else {
            return Optional.empty();
        }
    }
}
