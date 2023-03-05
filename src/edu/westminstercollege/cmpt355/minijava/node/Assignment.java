package edu.westminstercollege.cmpt355.minijava.node;

import org.antlr.v4.runtime.ParserRuleContext;

import java.lang.reflect.Parameter;
import java.util.List;

public record Assignment(ParserRuleContext ctx, Expression variable, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable, expression);
    }

}
