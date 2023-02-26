package edu.westminstercollege.cmpt355.minijava.node;

import java.util.List;

public record VarDeclaration(String name) implements DeclarationItem {
    @Override
    public List<? extends DeclarationItem> children() {
        return List.of();
    }
    @Override
    public String getNodeDescription() {
        return String.format("name: %s", name);
    }
}
