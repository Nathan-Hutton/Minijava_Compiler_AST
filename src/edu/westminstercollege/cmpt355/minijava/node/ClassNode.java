package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
public record ClassNode(ParserRuleContext ctx, List<MethodDefinition> methods) implements Node {
    @Override
    public String getNodeDescription() {
        return Node.super.getNodeDescription();
    }

    @Override
    public List<? extends Node> children() {
        return methods;
    }

    @Override
    public ParserRuleContext ctx() {
        return ctx;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
