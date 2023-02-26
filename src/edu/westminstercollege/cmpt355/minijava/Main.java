package edu.westminstercollege.cmpt355.minijava;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String... args) throws IOException, SyntaxException {
        final String TEST_FILE = "test_programs/test1.txt";
        final String CLASS_NAME = getClassNameFromPath(TEST_FILE);

        var lexer = new MiniJavaLexer(CharStreams.fromFileName(TEST_FILE));
        var parser = new MiniJavaParser(new CommonTokenStream(lexer));

        var methodBody = parser.methodBody().n;
        AST.print(methodBody);
    }
    private static String getClassNameFromPath(String path) {
        Path p = Path.of(path);
        String filename = p.getFileName().toString();
        int index = filename.indexOf('.');
        return filename.substring(0, index);
    }
}
