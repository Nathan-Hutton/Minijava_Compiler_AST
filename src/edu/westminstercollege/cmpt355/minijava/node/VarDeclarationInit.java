package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
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
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expression.generateCode(out, symbols);

        Type type = symbols.findVariable(name).orElseThrow().getType();
        if (type == PrimitiveType.Double && expression instanceof IntLiteral)
            out.println("i2d");

        Variable v = symbols.findVariable(name).orElseThrow();

        if (type == PrimitiveType.Double)
            out.printf("dstore %d\n", v.getIndex());
        else if (type == PrimitiveType.Int || type == PrimitiveType.Boolean)
            out.printf("istore %d\n", v.getIndex());
        else
            out.printf("astore %d\n", v.getIndex());
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expression.typecheck(symbols);
    }
}
