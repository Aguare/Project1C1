package Main;

import Archives.Read;
import java.io.File;

/**
 *
 * @author aguare
 */
public class Main {

    public static void main(String[] args) {
        try {
            Read read = new Read();
            File file = new File("/home/aguare/Downloads");
            read.analizeArchives(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }
    }
}
