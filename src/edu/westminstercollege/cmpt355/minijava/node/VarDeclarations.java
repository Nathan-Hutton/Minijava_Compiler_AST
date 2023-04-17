package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.plaf.nimbus.State;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record VarDeclarations(ParserRuleContext ctx, TypeNode type, List<DeclarationItem> declarations) implements Statement {
    @Override
    public List<? extends Node> children() {
        List<Node> children = new ArrayList<>();
        children.add(type);
        children.addAll(declarations);
        return children;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        for (DeclarationItem declaration : declarations)
            declaration.generateCode(out, symbols);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

        if (type.type() instanceof ClassType && !(type.type().toString().equals(symbols.getCompilingClassName()))) {
            if (symbols.classFromType(type.type()).isEmpty())
                throw new SyntaxException(this, String.format("There is no class of type %s", type.type()));
        }

        for (DeclarationItem item : declarations) {
            item.typecheck(symbols);

            // Item has no assignment
            if (item instanceof VarDeclaration) {
                Variable v = symbols.findVariable(item.name()).orElseThrow();
                v.setType(type.type());

                if (type.type() == PrimitiveType.Double)
                    v.setIndex(symbols.allocateLocalVariable(2));
                else
                    v.setIndex(symbols.allocateLocalVariable(1));

                continue;
            }

            Expression expression = ((VarDeclarationInit) item).expression();

            if (type.type() == PrimitiveType.Double) {
                if (expression.getType(symbols) == PrimitiveType.Int || expression.getType(symbols) == PrimitiveType.Double) {
                    Variable v = symbols.findVariable(item.name()).orElseThrow();
                    v.setType(type.type());
                    v.setIndex(symbols.allocateLocalVariable(2));
                    continue;
                }
            }

//            if (symbols.classFromType(type.type()).equals(symbols.classFromType(expression.getType(symbols))))
//                return;

            if (!type.type().equals(expression.getType(symbols))) {
                Optional<Class<?>> clazz = symbols.classFromType(type.type());
                if (clazz.isPresent()) {
                    if (clazz.orElseThrow().getName().equals(expression.getType(symbols).toString())) {
                        Variable v = symbols.findVariable(item.name()).orElseThrow();
                        v.setType(type.type());
                        v.setIndex(symbols.allocateLocalVariable(1));
                        continue;
                    }
                }
                throw new SyntaxException(this, String.format("%s is not of type %s", expression, type.type()));
            }

            Variable v = symbols.findVariable(item.name()).orElseThrow();
            v.setType(type.type());
            v.setIndex(symbols.allocateLocalVariable(1));
        }
    }
}
