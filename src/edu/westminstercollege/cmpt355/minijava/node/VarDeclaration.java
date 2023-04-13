package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record VarDeclaration(ParserRuleContext ctx, String name) implements DeclarationItem {
    @Override
    public List<? extends DeclarationItem> children() {
        return List.of();
    }
    @Override
    public String getNodeDescription() {
        return String.format("[VarDeclaration]: %s", name);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {}
}
