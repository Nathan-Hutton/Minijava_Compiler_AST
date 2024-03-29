package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record EmptyStatement(ParserRuleContext ctx) implements Statement {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        return;
    }
}
