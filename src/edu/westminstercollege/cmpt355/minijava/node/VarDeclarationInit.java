package edu.westminstercollege.cmpt355.minijava.node;

import java.util.List;

public record VarDeclarationInit(String name, Expression expression) implements DeclarationItem {
    @Override
    public List<? extends Node> children() {
        return List.of(expression);
    }
    @Override
    public String getNodeDescription() {
        return String.format("VarDeclarationInit [name: %s]", name);
    }
}
