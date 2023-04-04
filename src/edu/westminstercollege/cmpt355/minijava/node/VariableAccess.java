package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import jas.Var;
import org.antlr.v4.runtime.ParserRuleContext;
import edu.westminstercollege.cmpt355.minijava.*;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

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
    public void typecheck(SymbolTable symbols) throws SyntaxException {}

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        Type type = getType(symbols);

        Optional<Variable> variable = symbols.findVariable(name);
        if (variable.isEmpty())
            return;

        int index = variable.orElseThrow().getIndex();

        if (type == PrimitiveType.Int || type == PrimitiveType.Boolean)
            out.printf("iload %d\n", index);
        else if (type == PrimitiveType.Double)
            out.printf("dload %d\n", index);
        else
            out.printf("aload %d\n", index);
    }

    @Override
    public Type getType(SymbolTable symbols) {
        if (symbols.findVariable(name).isPresent())
            return symbols.findVariable(name).orElseThrow().getType();
        if (symbols.findJavaClass(name).isPresent())
            return new StaticType(name);
        return null;
    }
}
