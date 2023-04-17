package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import jas.Var;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record Parameter(ParserRuleContext ctx, TypeNode type, String name) implements Node {
    @Override
    public String getNodeDescription() {
        return "[Parameter] " + name;
    }

    @Override
    public List<? extends Node> children() {
        return List.of(type);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        Optional<Variable> param = symbols.findVariable(name);

        if (param.isEmpty())
            throw new SyntaxException(String.format("%s in unintialized", name));

        if (type.type() == PrimitiveType.Double)
            param.orElseThrow().setIndex(symbols.allocateLocalVariable(2));
        else
            param.orElseThrow().setIndex(symbols.allocateLocalVariable(1));
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
