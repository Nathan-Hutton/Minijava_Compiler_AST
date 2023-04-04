package edu.westminstercollege.cmpt355.minijava;

import java.util.*;

public class SymbolTable {

    private Map<String, Variable> variables = new HashMap<>();
    private int variableIndex = 0;

    public Variable registerVariable(String name) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name);
            variables.put(name, v);
        }

        return v;
    }

    public Optional<Variable> findVariable(String name) {
        return Optional.ofNullable(variables.get(name));
    }

    public int getVariableCount() {
        return variableIndex;
    }
    public int allocateLocalVariable(int size) {
        int temp = variableIndex;
        variableIndex += size;
        return temp;
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
