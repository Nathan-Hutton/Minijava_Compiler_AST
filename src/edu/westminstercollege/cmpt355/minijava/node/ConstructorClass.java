package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record ConstructorClass(ParserRuleContext ctx, String className, List<Expression> arguments) implements Expression {
    @Override
    public Type getType(SymbolTable symbols) {
        return null;
    }

    @Override
    public String getNodeDescription() {
        return String.format("Constructor call: %s", className);
    }

    @Override
    public List<? extends Node> children() {
        return arguments;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
