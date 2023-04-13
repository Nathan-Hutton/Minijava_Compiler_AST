package edu.westminstercollege.cmpt355.minijava;

public class Variable {

    private String name;
    private int index = -99;
    private Type type;
    private Boolean isField;

    public Variable(Type type, String name) {
        this.type = type;
        this.name = name;
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
    public void setIndex(int index) {
        this.index = index;
    }
    public void setField(boolean isField) {
        this.isField = isField;
    }
    public boolean isField() {
        return isField;
    }
}
