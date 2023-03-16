package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record Block(ParserRuleContext ctx, List<Statement> statements) implements Statement {
    @Override
    public List<? extends Node> children() {
        return statements;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (Statement stmt : statements)
            stmt.typecheck(symbols);
    }

}
