package Main;

import Analizers.Lexer;
import Archives.Read;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author aguare
 */
public class Main {
    
    int a = 5;

    public static void main(String[] args) {
        try {
            Read read = new Read();
            //String g = read.getPath();
            File file = new File("/home/aguare/Downloads/archivoPrueba.java");
            //File file = new File(g);
            //File file = new File("/home/aguare/Documents/Github/Project1C1/ServerAnalizer/src/main/java/Analizers/sym.java");
            Reader reader = new FileReader(file);
            Lexer lexer = new Lexer(reader);
            //lexer.yylex();
            //lexer.showTokens();
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo");
        }
    }

    public int hola() {
        String a = "asdf'j' " + 'd';
        a += "aas" + (2 + 5) + true;
        int b = 5;
        boolean c = false;
        char ac = 'a';
        if (c) {

        }
        do {
            
        } while (c);
        switch ("ASDF") {
            default:
                break;
            case "ASDF":
                
                break;
        }
        return 0;
    }
}
