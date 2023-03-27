package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record BooleanLiteral(ParserRuleContext ctx, Boolean bool) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        if (bool)
            out.printf("ldc %d\n", 1);
        else
            out.printf("ldc %d\n", 0);
    }

    @Override
    public String getNodeDescription() {
        return String.format("BooleanLiteral: %b", bool);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        // None
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return PrimitiveType.Boolean;
    }
}
