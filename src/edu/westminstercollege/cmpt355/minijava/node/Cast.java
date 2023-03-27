package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record Cast(ParserRuleContext ctx, TypeNode type, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(type, expression);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expression.generateCode(out, symbols);
        Type expr_type = expression.getType(symbols);

        if (type.type() == PrimitiveType.Double && expr_type == PrimitiveType.Int)
            out.println("i2d");
        else if (type.type() == PrimitiveType.Int && expr_type == PrimitiveType.Double)
            out.println("d2i");
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expression.typecheck(symbols);
        type.typecheck(symbols);

        Type expression_type = expression.getType(symbols);
        Type cast_type = type.type();

        if (expression_type.equals(cast_type))
            return;

        if (expression_type == PrimitiveType.Boolean && cast_type.equals(new ClassType("String")))
            return;

        if (expression_type == PrimitiveType.Int || expression_type == PrimitiveType.Double)
            if (cast_type == PrimitiveType.Int || cast_type == PrimitiveType.Double || cast_type.equals(new ClassType("String")))
                return;

        if (expression_type.equals(new ClassType("String")))
            if (cast_type.equals(new ClassType("array")))
                return;
            else if (cast_type.equals(new ClassType("char")) && (((StringLiteral)expression).getString().length() == 1))
                return;

        if (expression_type.equals(new ClassType("array")))
            if (cast_type.equals(new ClassType("String")))
                return;

        if (expression_type.equals(new ClassType("char")))
            if (cast_type.equals(new ClassType("String")))
                return;

        throw new SyntaxException(this, String.format("Can't convert %s to %s", expression_type, cast_type));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return type.type();
    }
}
