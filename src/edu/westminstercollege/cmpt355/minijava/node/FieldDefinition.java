package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record FieldDefinition(ParserRuleContext ctx, TypeNode type, String name, Optional<Expression> expr) implements Statement {

    @Override
    public List<? extends Node> children() {
        if (expr.isPresent())
            return List.of(type, expr.orElseThrow());
        return List.of(type);
    }

    @Override
    public String getNodeDescription() {
        return "[FieldDefinition] " + name;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
