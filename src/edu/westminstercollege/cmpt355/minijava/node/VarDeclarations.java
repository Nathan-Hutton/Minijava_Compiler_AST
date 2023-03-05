package edu.westminstercollege.cmpt355.minijava.node;

import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public record VarDeclarations(ParserRuleContext ctx, TypeNode type, List<DeclarationItem> declarations) implements Statement {
    @Override
    public List<? extends Node> children() {
        List<Node> children = new ArrayList<>();
        children.add(type);
        children.addAll(declarations);
        return children;
    }
}
