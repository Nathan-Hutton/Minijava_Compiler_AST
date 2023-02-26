package edu.westminstercollege.cmpt355.minijava.node;

import java.util.List;

public record BinaryOp(Expression expr1, String operator, Expression expr2) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expr1, expr2);
    }

    @Override
    public String getNodeDescription() {
        return String.format("BinaryOp: %s", operator);
    }
}
