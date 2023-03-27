package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import edu.westminstercollege.cmpt355.minijava.*;

import java.io.PrintWriter;
import java.util.List;

public record VariableAccess(ParserRuleContext ctx, String name) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public String getNodeDescription() {
        return String.format("VariableAccess [variableName: %s]", name);
    }

    public String name(){
        return name;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        if (symbols.findVariable(name).isEmpty())
            throw new SyntaxException(this, String.format("%s doesn't exist", name));
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        Type type = symbols.findVariable(name).orElseThrow().getType();
        int index = symbols.findVariable(name).orElseThrow().getIndex();

        if (type == PrimitiveType.Int || type == PrimitiveType.Boolean)
            out.printf("iload %d\n", index);
        else if (type == PrimitiveType.Double)
            out.printf("dload %d\n", index);
        else
            out.printf("aload %d\n", index);
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return symbols.findVariable(name).orElseThrow().getType();
    }
}
