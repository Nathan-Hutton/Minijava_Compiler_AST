package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import edu.westminstercollege.cmpt355.minijava.*;

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

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        if (symbols.findVariable(name).isEmpty())
            throw new SyntaxException(this, String.format("%s doesn't exist", name));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return symbols.findVariable(name).orElseThrow().getType();
    }
}
