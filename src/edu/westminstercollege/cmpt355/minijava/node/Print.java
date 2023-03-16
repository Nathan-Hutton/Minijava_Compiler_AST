package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import edu.westminstercollege.cmpt355.minijava.VoidType;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record Print(ParserRuleContext ctx, List<Expression> expressions) implements Expression {
    @Override
    public List<? extends Node> children() {
        return expressions;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (Expression expr: expressions)
            expr.typecheck(symbols);
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return VoidType.Instance;
    }
}
