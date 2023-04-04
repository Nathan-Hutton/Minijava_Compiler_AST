package edu.westminstercollege.cmpt355.minijava;

public sealed class ClassType implements Type
permits StaticType {
    private final String className;
    public ClassType(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }
    @Override
    public String toString() {
        return className;
    }
    public boolean equals(Object obj) {
        if (obj instanceof ClassType) {
            return className.equals(((ClassType) obj).className);
        }
        return false;
    }
    public int hashCode() {
        return 0;
    }
}
