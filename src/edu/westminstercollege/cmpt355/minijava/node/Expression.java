package edu.westminstercollege.cmpt355.minijava.node;
import edu.westminstercollege.cmpt355.minijava.*;

public sealed interface Expression extends Node
    permits IntLiteral, DoubleLiteral, BooleanLiteral, StringLiteral, VariableAccess,
    Assignment, BinaryOp, Negate, PreIncrement, PostIncrement, Cast, Print {
    Type getType(SymbolTable symbols);
}
