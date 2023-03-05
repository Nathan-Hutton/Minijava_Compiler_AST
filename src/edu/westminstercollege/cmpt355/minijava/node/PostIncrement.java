package edu.westminstercollege.cmpt355.minijava.node;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record PostIncrement(ParserRuleContext ctx, VariableAccess variable, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable);
    }

    @Override
    public String getNodeDescription() {
        return String.format("PostIncrement: %s", op);
    }
}
