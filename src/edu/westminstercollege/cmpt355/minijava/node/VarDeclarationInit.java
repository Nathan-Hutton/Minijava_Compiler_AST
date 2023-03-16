package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record VarDeclarationInit(ParserRuleContext ctx, String name, Expression expression) implements DeclarationItem {
    @Override
    public List<? extends Node> children() {
        return List.of(expression);
    }
    @Override
    public String getNodeDescription() {
        return String.format("VarDeclarationInit [name: %s]", name);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expression.typecheck(symbols);
    }
}
