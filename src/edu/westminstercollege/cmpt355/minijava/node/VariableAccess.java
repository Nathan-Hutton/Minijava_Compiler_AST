package edu.westminstercollege.cmpt355.minijava.node;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record VariableAccess(ParserRuleContext ctx, String name) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public String getNodeDescription() {
        return String.format("VariableAccess [variableName: %s]", name);
    }

    public String name(){
        return name;
    }
}
