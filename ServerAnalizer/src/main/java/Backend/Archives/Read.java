package Backend.Archives;

import Backend.Analizers.Lexer;
import Backend.Analizers.Sintactic;
import Backend.Objects.ClassInfo;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Read {

    private ArrayList<File> archives = new ArrayList<>();

    public ArrayList<ClassInfo> analizeArchives(File directory) {
        inputDirectory(directory);
        ArrayList<ClassInfo> result = new ArrayList<>();
        for (File file : archives) {
            try {
                Reader reader = new FileReader(file);
                Lexer lexer = new Lexer(reader);
                Sintactic sintac = new Sintactic(lexer);
                sintac.parse();
                result.add(sintac.getResult(lexer.getComments()));
            } catch (Exception e) {
                System.out.println("ERROR EN EL ANÁLISIS DEL ARCHIVO -> " + file.getName());
            }
        }

        return result;
    }

    private void inputDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (!file.isDirectory()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println("ARCHIVO -> " + file.getName());
                    archives.add(file);
                }
            } else {
                inputDirectory(file);
            }
        }
    }

}
