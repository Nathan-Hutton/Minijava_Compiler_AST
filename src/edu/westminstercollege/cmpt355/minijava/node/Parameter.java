package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

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
        if (type.type() == PrimitiveType.Double) {
            symbols.allocateLocalVariable(2);
            return;
        }

        symbols.allocateLocalVariable(1);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
