package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import java_cup.runtime.symbol;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record ClassImport(ParserRuleContext ctx, String path) implements Import {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public String getNodeDescription() {
        return "[ClassImport] " + path;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        Optional<Class<?>> import_class = symbols.findJavaClass(path);
        if (import_class.isEmpty())
            throw new SyntaxException(this, String.format("The class %s doesn't exist", path));

        symbols.importClass(symbols.findJavaClass(path).orElseThrow());
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {

    }
}
