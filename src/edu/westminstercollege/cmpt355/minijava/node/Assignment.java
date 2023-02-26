package edu.westminstercollege.cmpt355.minijava.node;

import java.util.List;

public record Assignment(VariableAccess variable, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable, expression);
    }

}
