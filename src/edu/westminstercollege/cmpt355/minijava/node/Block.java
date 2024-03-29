package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record Block(ParserRuleContext ctx, List<Statement> statements, SymbolTable symbolTable) implements Statement {
    public Block(ParserRuleContext ctx, List<Statement> statements) {
        this(ctx, statements, new SymbolTable(SymbolTable.Level.Block));
    }
    @Override
    public List<? extends Node> children() {
        return statements;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        for (Statement child : statements) {
            child.generateCode(out, symbolTable);
        }
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (Statement stmt : statements)
            stmt.typecheck(symbolTable);
    }
}
