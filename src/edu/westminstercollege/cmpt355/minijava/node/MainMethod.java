package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record MainMethod(ParserRuleContext ctx, Block block, SymbolTable symbolTable) implements Node {
    public MainMethod(ParserRuleContext ctx, Block block) {
        this(ctx, block, new SymbolTable(SymbolTable.Level.Method));
    }
    @Override
    public String getNodeDescription() {
        return "main";
    }

    @Override
    public List<? extends Node> children() {
        return List.of(block);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
