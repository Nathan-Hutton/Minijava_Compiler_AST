package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record DoubleLiteral(ParserRuleContext ctx, double number) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public String getNodeDescription() {
        return String.format("DoubleLiteral: %f", number);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        // None
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return PrimitiveType.Double;
    }
}
