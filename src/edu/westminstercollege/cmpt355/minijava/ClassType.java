package edu.westminstercollege.cmpt355.minijava;

public record ClassType(String className) implements Type {
    @Override
    public String toString() {
        return className;
    }
}
