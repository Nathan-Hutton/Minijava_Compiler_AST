package edu.westminstercollege.cmpt355.minijava;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) throws IOException, SyntaxException {
        final String TEST_FILE = "test_programs/test1.txt";
        final String CLASS_NAME = getClassNameFromPath(TEST_FILE);

        var lexer = new MiniJavaLexer(CharStreams.fromFileName(TEST_FILE));
        var parser = new MiniJavaParser(new CommonTokenStream(lexer));

        var goal = parser.goal().n;
        AST.print(goal);

        try {
            var compiler = new Compiler(goal, CLASS_NAME);
            compiler.compile(Path.of("test_output"));
            jasmin.Main.main(new String[] {
                    "-d", "out/test_compiled",
                    String.format("test_output/%s.j", CLASS_NAME)
            });
        }
        catch (SyntaxException e){
            if (e.getNode() != null) {
                int line_num = e.getNode().ctx().start.getLine();
                System.out.println("Error at line " + line_num + "\n" + e.getMessage());
            }
        }
        // new stuff for testing
        try {
            // Use reflection to find the class that was just compiled
            var compiledClass = Class.forName(CLASS_NAME);
            // Find its main() method
            var compiledMainMethod = compiledClass.getMethod("main", String[].class);

            System.out.printf("——— Running compiled class %s ———\n", CLASS_NAME);
            // Run the compiled main()
            compiledMainMethod.invoke(null, new Object[] { new String[0] });
            System.out.println("——— End of output ———");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException ex) {
            System.err.println("Unable to execute newly-compiled program: class or method not found!");
        } catch (InvocationTargetException ex) {
            // An exception was thrown by the compiled program (not a compiler problem 🙂)
            ex.getTargetException().printStackTrace();
        }
    }
    private static String getClassNameFromPath(String path) {
        Path p = Path.of(path);
        String filename = p.getFileName().toString();
        int index = filename.indexOf('.');
        return filename.substring(0, index);
    }
}
