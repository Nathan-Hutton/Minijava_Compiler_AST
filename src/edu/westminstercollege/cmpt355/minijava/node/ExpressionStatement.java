package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record ExpressionStatement(ParserRuleContext ctx, Expression expr) implements Statement {
    @Override
    public List<? extends Node> children() {
        return List.of(expr);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expr.generateCode(out, symbols);

        Type type = expr.getType(symbols);

        if (type == PrimitiveType.Double)
            out.println("pop2");
        else if (type != VoidType.Instance)
            out.println("pop");
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);
    }
}
