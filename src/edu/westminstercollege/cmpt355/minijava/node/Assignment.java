package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.List;

public record Assignment(ParserRuleContext ctx, Expression variable, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable, expression);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expression.generateCode(out, symbols);

        Type type = variable.getType(symbols);
        if (type == PrimitiveType.Double && expression instanceof IntLiteral)
            out.println("i2d");

        // This if statement is just some bullshit so I can call name() which is only accessible by VariabelAccess
        Variable v = null;
        if (variable instanceof VariableAccess) {
            v = (symbols.findVariable((((VariableAccess) variable).name()))).orElseThrow();
        }

        // The asserts are just to accommodate the "possibility" of v being uninitialized (Intellij being silly)
        if (type == PrimitiveType.Int || type == PrimitiveType.Boolean) {
            assert v != null;
            out.println("dup");
            out.printf("istore %d\n", v.getIndex());
        }
        else if (type == PrimitiveType.Double) {
            assert v != null;
            out.println("dup2");
            out.printf("dstore %d\n", v.getIndex());
        }
        else {
            assert v != null;
            out.println("dup");
            out.printf("astore %d\n", v.getIndex());
        }
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
        return variable.getType(symbols);
    }
}
