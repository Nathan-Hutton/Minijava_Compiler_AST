package edu.westminstercollege.cmpt355.minijava.node;

import java.util.List;

public record PostIncrement(VariableAccess variable, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable);
    }

    @Override
    public String getNodeDescription() {
        return String.format("PostIncrement: %s", op);
    }
}
