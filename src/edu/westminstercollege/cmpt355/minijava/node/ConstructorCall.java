package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.text.html.Option;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record ConstructorCall(ParserRuleContext ctx, String className, List<Expression> arguments) implements Expression {

    @Override
    public String getNodeDescription() {
        return String.format("Constructor call: %s", className);
    }

    @Override
    public List<? extends Node> children() {
        return arguments;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        out.printf("new %s", className);

        List<Type> mini_param_types = new ArrayList<>();
        for (Expression arg : arguments) {
            arg.generateCode(out, symbols);
            mini_param_types.add(arg.getType(symbols));
        }

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

        out.printf("invokespecial MyClass/<init>(%s)V;", type_string);
    }
    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        if (!(getType(symbols) instanceof ClassType))
            throw new SyntaxException(this, String.format("%s is not a class type", className));

        List<Type> mini_param_types = new ArrayList<>();
        for (Expression arg : arguments) {
            arg.typecheck(symbols);
            mini_param_types.add(arg.getType(symbols));
        }

        Optional<Method> constructor = symbols.findConstructor(new ClassType(className), mini_param_types);
        if (constructor.isEmpty())
            throw new SyntaxException(this, String.format("There is no constructor for %s with arguments %s", className, mini_param_types));
    }
    @Override
    public Type getType(SymbolTable symbols) {
        List<Type> param_types = new ArrayList<>();
        for (Expression expr : arguments)
            param_types.add(expr.getType(symbols));

        Optional<Method> constructor = symbols.findConstructor(new ClassType(className), param_types);
        return constructor.orElseThrow().containingType();
    }
}
