package edu.westminstercollege.cmpt355.minijava;

public class Variable {

    private String name;
    private int index;
    private Type type;

    public Variable(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return String.format("Variable %s of type %s", this.name, this.type.toString());
    }
    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }
}
