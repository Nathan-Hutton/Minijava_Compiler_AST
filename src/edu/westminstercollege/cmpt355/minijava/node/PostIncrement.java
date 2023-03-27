package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record PostIncrement(ParserRuleContext ctx, VariableAccess variable, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable);
    }

    @Override
    public String getNodeDescription() {
        return String.format("PostIncrement: %s", op);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        variable.typecheck(symbols);

        Type variable_type = variable.getType(symbols);

        if (variable_type != PrimitiveType.Int && variable_type != PrimitiveType.Double)
            throw new SyntaxException(this, String.format("%s is not a numeric value", variable));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return variable.getType(symbols);
    }
}
