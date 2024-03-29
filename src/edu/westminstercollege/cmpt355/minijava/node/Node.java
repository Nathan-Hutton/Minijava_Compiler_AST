package edu.westminstercollege.cmpt355.minijava.node;

import org.antlr.v4.runtime.ParserRuleContext;
import edu.westminstercollege.cmpt355.minijava.*;

import java.io.PrintWriter;
import java.util.List;

public sealed interface Node
    permits Statement, Expression, TypeNode, DeclarationItem, MethodDefinition, MainMethod, Parameter, ClassNode,
    Import {

    default String getNodeDescription() {
        String fullName = getClass().getSimpleName();
        int index = fullName.lastIndexOf('.');
        if (index >= 0)
            return fullName.substring(index + 1);
        return fullName;
    }

    List<? extends Node> children();

    ParserRuleContext ctx();

    void typecheck(SymbolTable symbols) throws SyntaxException;
    void generateCode(PrintWriter out, SymbolTable symbols);
}
