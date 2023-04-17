package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record MethodCall(ParserRuleContext ctx, Expression expr, String methodName, List<Expression> arguments) implements Expression {
    @Override
    public String getNodeDescription() {
        return String.format("[Method Call] %s", methodName);
    }

    @Override
    public List<? extends Node> children() {
        List<Expression> list = new ArrayList<>();
        list.add(expr);
        list.addAll(arguments);
        return list;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expr.generateCode(out, symbols);


        List<Type> mini_param_types = new ArrayList<>();
        for (Expression arg : arguments) {
            arg.generateCode(out, symbols);
            mini_param_types.add(arg.getType(symbols));
        }

        String class_name;
        if (expr.getType(symbols).equals(new ClassType(symbols.getCompilingClassName())))
            class_name = expr.getType(symbols).toString();
        else
            class_name = symbols.findJavaClass(expr.getType(symbols).toString()).orElseThrow().getName();

        Optional<Method> method = symbols.findMethod(((ClassType) expr.getType(symbols)) , methodName, mini_param_types);
        if (method.orElseThrow().containingType() instanceof StaticType || expr instanceof This) {
            generateCodeStatic(out, symbols, class_name, method.orElseThrow().returnType(), mini_param_types);
            return;
        }


        generateCodeNonstatic(out, symbols, class_name, method.orElseThrow().returnType(), mini_param_types);
    }
    public void generateCodeStatic(PrintWriter out, SymbolTable symbols, String source_class_name, Type returnType, List<Type> mini_param_types)
    {
        StringBuilder type_string = new StringBuilder();
        for (Type t : mini_param_types) {
            if (t == PrimitiveType.Int)
                type_string.append("I");
            else if (t == PrimitiveType.Double)
                type_string.append("D");
            else if (t == PrimitiveType.Boolean)
                type_string.append("Z");
            else if (t instanceof ClassType)
                type_string.append("L").append(symbols.classFromType(t).orElseThrow().getName().replace('.', '/')).append(";");
        }

        if (returnType instanceof VoidType)
            out.printf("invokevirtual %s/%s(%s)V\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Int)
            out.printf("invokevirtual %s/%s(%s)I\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Double)
            out.printf("invokevirtual %s/%s(%s)D\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Boolean)
            out.printf("invokevirtual %s/%s(%s)Z\n", source_class_name, methodName, type_string);
        else if (returnType instanceof ClassType) {
            String class_name = symbols.classFromType(new ClassType(returnType.toString())).orElseThrow().getName().replace('.', '/');
            out.printf("invokevirtual %s/%s(%s)L%s;\n", source_class_name, methodName, type_string, class_name);
        }
    }
    public void generateCodeNonstatic(PrintWriter out, SymbolTable symbols, String source_class_name, Type returnType, List<Type> mini_param_types)
    {
        StringBuilder type_string = new StringBuilder();
        for (Type t : mini_param_types) {
            if (t == PrimitiveType.Int)
                type_string.append("I");
            else if (t == PrimitiveType.Double)
                type_string.append("D");
            else if (t == PrimitiveType.Boolean)
                type_string.append("Z");
            else if (t instanceof ClassType)
                type_string.append("L").append(symbols.classFromType(t).orElseThrow().getName().replace('.', '/')).append(";");
        }

        if (returnType instanceof VoidType)
            out.printf("invokevirtual %s/%s(%s)V\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Int)
            out.printf("invokevirtual %s/%s(%s)I\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Double)
            out.printf("invokevirtual %s/%s(%s)D\n", source_class_name, methodName, type_string);
        else if (returnType == PrimitiveType.Boolean)
            out.printf("invokevirtual %s/%s(%s)Z\n", source_class_name, methodName, type_string);
        else if (returnType instanceof ClassType) {
            out.printf("invokevirtual %s/%s(%s)L%s;\n", source_class_name, methodName, type_string, returnType.toString().replace('.', '/'));
        }
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);

        List<Type> mini_param_types = new ArrayList<>();
        for (Expression arg : arguments) {
            arg.typecheck(symbols);
            mini_param_types.add(arg.getType(symbols));
        }

        if (!(expr.getType(symbols) instanceof ClassType)) {
            throw new SyntaxException(this, String.format("%s is not a classtype", expr.getType(symbols)));
        }

        if (expr.getType(symbols) instanceof ClassType classType) {
            Optional<Method> method = symbols.findMethod(classType, methodName, mini_param_types);

            if (method.isEmpty())
                throw new SyntaxException(this, String.format("%s has no method: %s with parameters: %s", expr.getType(symbols), methodName, mini_param_types));
        }
    }
    @Override
    public Type getType(SymbolTable symbols) {
        List<Type> param_types = new ArrayList<>();
        for (Expression expr : arguments)
            param_types.add(expr.getType(symbols));

        Optional<Method> method = symbols.findMethod(((ClassType) expr.getType(symbols)) , methodName, param_types);
        return method.map(Method::returnType).orElse(null);
    }
}
