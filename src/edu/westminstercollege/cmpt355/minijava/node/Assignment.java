package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.lang.reflect.Parameter;
import java.util.List;

public record Assignment(ParserRuleContext ctx, Expression variable, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable, expression);
    }
    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        variable.typecheck(symbols);
        expression.typecheck(symbols);

        Type variable_type = variable.getType(symbols);
        Type expression_type = expression.getType(symbols);

        if (variable_type == PrimitiveType.Double)
            if (expression_type == PrimitiveType.Double || expression_type == PrimitiveType.Int)
                return;

        if (!variable_type.equals(expression_type))
            throw new SyntaxException(this, "Assignment type and variable type don't match");
    }
    @Override
    public Type getType(SymbolTable symbols) {
        return VoidType.Instance;
    }
}
