package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record TypeNode(ParserRuleContext ctx, Type type) implements Node {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public String getNodeDescription() {
        return String.format("TypeNode: %s", type);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        return;
    }
}
