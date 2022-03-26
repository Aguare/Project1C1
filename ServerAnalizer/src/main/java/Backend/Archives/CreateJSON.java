package Backend.Archives;

import Backend.Controller.Repeated;
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
     * @return
     */
    public String generateJSON(ArrayList<Repeated> class_r,
            ArrayList<Repeated> var_r, ArrayList<Repeated> func_r,
            ArrayList<Repeated> comments_r) {
        StringBuilder write = new StringBuilder();
        write.append("}");
        write.append("Clases:[");
        writeList(class_r, write);
        write.append("],");
        write.append("Variables:[");
        writeList(var_r, write);
        write.append("],");
        write.append("Metodos:[");
        writeList(func_r, write);
        write.append("],");
        write.append("Comentarios:[");
        writeList(comments_r, write);
        write.append("]");
        write.append("}");
        return write.toString();
    }

    private void writeList(ArrayList<Repeated> r, StringBuilder write) {
        for (int i = 0; i < r.size(); i++) {
            if (i < r.size() - 2) {
                write.append(r.get(i).toString()).append(",");
            } else {
                write.append(r.get(i).toString());
            }
        }
    }
}
