package edu.westminstercollege.cmpt355.minijava;

import edu.westminstercollege.cmpt355.minijava.node.*;

public class SyntaxException extends Exception {

    private Node node;
    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyntaxException(Throwable cause) {
        super(cause);
    }

    public SyntaxException(Node n){
        this.node = n;
    }

    public SyntaxException(Node n, String s){
        super(s);
        this.node = n;
    }

    public Node getNode(){
        return this.node;
    }

    protected SyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
