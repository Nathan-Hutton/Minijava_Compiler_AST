package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record ClassNode(ParserRuleContext ctx, List<Import> imports, List<FieldDefinition> fieldDefinitions, List<MethodDefinition> methods, Optional<MainMethod> main) implements Node {
    @Override
    public String getNodeDescription() {
        return Node.super.getNodeDescription();
    }

    @Override
    public List<? extends Node> children() {
        List<Node> list = new ArrayList<>(imports);
        list.addAll(fieldDefinitions);
        list.addAll(methods);

        if (main.isPresent())
            list.add(main.orElseThrow());

        return list;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (var child : children())
            child.typecheck(symbols);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
