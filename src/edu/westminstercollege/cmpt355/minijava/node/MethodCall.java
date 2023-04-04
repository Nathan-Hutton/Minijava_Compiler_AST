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
        return String.format("Method Call: %s", methodName);
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

    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        if (!(expr.getType(symbols) instanceof ClassType))
            throw new SyntaxException(this, String.format("%s is not a classtype", expr));

        List<Type> mini_param_types = new ArrayList<>();
        for (Expression arg : arguments) {
            arg.typecheck(symbols);
            mini_param_types.add(arg.getType(symbols));
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
