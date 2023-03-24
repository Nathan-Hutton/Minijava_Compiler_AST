package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record BinaryOp(ParserRuleContext ctx, Expression expr1, String operator, Expression expr2) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expr1, expr2);
    }

    @Override
    public String getNodeDescription() {
        return String.format("BinaryOp: %s", operator);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr1.typecheck(symbols);
        expr2.typecheck(symbols);

        Type leftType = expr1.getType(symbols);
        Type rightType = expr2.getType(symbols);

        // Doing stuff with numbers
        if ((leftType == PrimitiveType.Int || leftType == PrimitiveType.Double ) && (rightType == PrimitiveType.Int ||
                rightType == PrimitiveType.Double))
            return;

        if (!operator.equals("+"))
            throw new SyntaxException(this, String.format("Can't use %s with %s and %s", operator, leftType, rightType));

        // Adding numbers with numbers, strings with strings, and numbers with strings
        if (leftType.equals(new ClassType("String")) || rightType.equals(new ClassType("String")))
            return;

        throw new SyntaxException(this, String.format("Can't use %s with %s and %s", operator, leftType, rightType));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        Type leftType = expr1.getType(symbols);
        Type rightType = expr2.getType(symbols);

        if (leftType.equals(new ClassType("String")) || rightType.equals(new ClassType("String")))
            return new ClassType("String");

        if (leftType.equals(PrimitiveType.Double) || rightType.equals(PrimitiveType.Double))
            return PrimitiveType.Double;

        if (operator.equals("*") || operator.equals("/"))
            if (leftType.equals(PrimitiveType.Int) && rightType.equals(PrimitiveType.Int))
                return PrimitiveType.Int;
            else
                return PrimitiveType.Double;

        if (operator.equals("+"))
            if (leftType.equals(new ClassType("String")) && (rightType == PrimitiveType.Int ||
                    rightType.equals(new ClassType("String")) || rightType.equals(PrimitiveType.Double)))
                return new ClassType("String");

            else if (rightType.equals(new ClassType("String")) && (leftType == PrimitiveType.Int ||
                    leftType.equals(new ClassType("String")) || leftType.equals(PrimitiveType.Double)))
                return new ClassType("String");

        return PrimitiveType.Int;
    }
}
