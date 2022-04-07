package Back.Archives;

import Back.Analizers.ErrorLP;
import Back.Analizers.Lexer;
import Back.Analizers.Sintactic;
import Back.Objects.ClassInfo;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Read {

    private ArrayList<ErrorLP> errors = new ArrayList<>();

    /**
     * Analyze the archives for create json response
     *
     * @param archives
     * @return
     */
    public ArrayList<ClassInfo> analizeArchives(ArrayList<File> archives) {
        ArrayList<ClassInfo> result = new ArrayList<>();
        for (File file : archives) {
            try {
                Reader reader = new FileReader(file);
                Lexer lexer = new Lexer(reader, file.getName());
                Sintactic sintac = new Sintactic(lexer, file.getName());
                sintac.parse();
                errors.addAll(lexer.getErrors());
                errors.addAll(sintac.getErrors());
                result.add(sintac.getResult(lexer.getComments()));
            } catch (Exception e) {
                errors.add(new ErrorLP(0, 0, "", 1, "ERROR EN EL ANÁLISIS DEL ARCHIVO -> " + file.getName(), null));
            }
        }
        return result;
    }

    public ArrayList<ErrorLP> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<ErrorLP> errors) {
        this.errors = errors;
    }
}
