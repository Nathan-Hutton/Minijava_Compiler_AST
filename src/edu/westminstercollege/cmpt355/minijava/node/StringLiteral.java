package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.ClassType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record StringLiteral(ParserRuleContext ctx, String text) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }
    public String getString() {
        return text;
    }

    @Override
    public String getNodeDescription() {
        return String.format("StringLiteral: %s", text);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        out.printf("ldc %s\n", text);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        // None
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return new ClassType("String");
    }
}
