package Back.Archives;

import Back.Controller.Repeated;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class CreateJSON {

    /**
     * Generate JSON estructure with String
     *
     * @param class_r
     * @param var_r
     * @param func_r
     * @param comments_r
     * @param score
     * @return
     */
    public String generateJSON(ArrayList<Repeated> class_r,
            ArrayList<Repeated> var_r, ArrayList<Repeated> func_r,
            ArrayList<Repeated> comments_r, Repeated score) {
        StringBuilder write = new StringBuilder();
        write.append("{");
        write.append("\n").append(score.toString()).append(",");
        write.append("\nClases:[");
        writeList(class_r, write);
        write.append("\n],");
        write.append("\nVariables:[");
        writeList(var_r, write);
        write.append("\n],");
        write.append("\nMetodos:[");
        writeList(func_r, write);
        write.append("\n],");
        write.append("\nComentarios:[");
        writeList(comments_r, write);
        write.append("\n]");
        write.append("\n}");
        return write.toString();
    }

    private void writeList(ArrayList<Repeated> r, StringBuilder write) {
        for (int i = 0; i < r.size(); i++) {
            if (i < r.size() - 1) {
                write.append("\n").append(r.get(i).toString()).append(",");
            } else {
                write.append("\n").append(r.get(i).toString());
            }
        }
    }
}
