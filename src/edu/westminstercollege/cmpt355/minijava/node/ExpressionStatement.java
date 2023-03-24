package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record ExpressionStatement(ParserRuleContext ctx, Expression expr) implements Statement {
    @Override
    public List<? extends Node> children() {
        return List.of(expr);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        System.out.println(expr.getType(symbols));
        expr.typecheck(symbols);
    }
}
