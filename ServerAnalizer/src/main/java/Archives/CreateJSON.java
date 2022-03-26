package Archives;

import Controller.Repeated;
import static Controller.TypeEs.CLASS;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class CreateJSON {

    public File generateJSON(ArrayList<Repeated> repeated) {
        StringBuilder write = new StringBuilder();
        StringBuilder[] s = getContent(repeated);
        write.append("}");
        write.append("Clases:[");
        write.append(s[0]);
        write.append("],");
        write.append("}");
        return null;
    }

    private StringBuilder[] getContent(ArrayList<Repeated> repeated) {
        StringBuilder[] s = new StringBuilder[4];
        for (Repeated r : repeated) {
            switch (r.getType()) {
                case CLASS:
                    s[0].append(r.toString());
                    break;
                case VAR:
                    s[1].append(r.toString());
                    break;
                case METHOD:
                    s[2].append(r.toString());
                    break;
                case COMMENT:
                    s[3].append(r.toString());
                    break;
                case SCORE:
                    s[4].append(r.toString());
                    break;
                default:
                    break;
            }
        }
        return s;
    }
}
