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

    public static void main(String[] args) {
        try {
            Read read = new Read();
            //String g = read.getPath();
            File file = new File("/home/aguare/Downloads/archivoPrueba.java");
            //File file = new File(g);
            //File file = new File("/home/aguare/Documents/Github/Project1C1/ServerAnalizer/src/main/java/Analizers/sym.java");
            Reader reader = new FileReader(file);
            Lexer lexer = new Lexer(reader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo");
        }

    }
}
