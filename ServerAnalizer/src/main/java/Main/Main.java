package Main;

import Analizers.ErrorLP;
import Analizers.Lexer;
import Analizers.Sintactic;
import Archives.Read;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Main {

    public static void main(String[] args) {
        try {
            Read read = new Read();
            //String g = read.getPath();
            File file = new File("/home/aguare/Downloads/archivoPrueba.java");
            //File file = new File(g);
            //File file = new File("/home/aguare/Documents/Github/Project1C1/ServerAnalizer/src/main/java/Analizers/sym.java");
            Reader reader = new FileReader(file);
            Lexer lexer = new Lexer(reader);
            Sintactic sintac = new Sintactic(lexer);
            sintac.parse();
            ArrayList<ErrorLP> errors = sintac.getErrors();
            for (ErrorLP error : errors) {
                System.out.println("L: " + error.getLine() + " C:" + error.getColumn() + " Contenido: " + error.getContent() + " Mensaje: " + error.getMessage());
            }
            //lexer.yylex();
            //lexer.showTokens();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }
    }

    public int hola() {
        String a = "asdf'j' " + 'd';
        a += "aas" + (2 + 5) + true;
        int b = 5;
        boolean c = false;
        char ac = 'a';
        if (true) {

        }
        ++b;
        do {

        } while (c);
        switch ("ASDF") {
            
        }
        float h = 145.465f;
        return 0;
    }
    
}
