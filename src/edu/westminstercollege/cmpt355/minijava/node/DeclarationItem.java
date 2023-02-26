package edu.westminstercollege.cmpt355.minijava.node;

public sealed interface DeclarationItem extends Node
    permits VarDeclaration, VarDeclarationInit {
}
