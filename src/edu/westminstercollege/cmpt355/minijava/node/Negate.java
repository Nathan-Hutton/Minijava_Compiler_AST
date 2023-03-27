package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record Negate(ParserRuleContext ctx, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expression);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expression.typecheck(symbols);

        if (expression.getType(symbols) !=  PrimitiveType.Int && expression.getType(symbols) != PrimitiveType.Double)
            throw new SyntaxException(this, String.format("%s is not a number", expression));
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expression.generateCode(out, symbols);

        var type = expression.getType(symbols);

        if (type == PrimitiveType.Int)
            out.println("ineg");
        else if (type == PrimitiveType.Double)
            out.println("dneg");
        else
            throw new RuntimeException(String.format("Internal compiler error: type of negate it %s", type));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return expression.getType(symbols);
    }
}
