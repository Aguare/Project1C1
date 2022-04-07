package Back.Archives;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Read {

    /**
     *
     * @param directory
     * @return file type java for analyzer
     */
    public ArrayList<File> inputDirectory(File directory) {
        ArrayList<File> archives = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (!file.isDirectory()) {
                if (file.getName().endsWith(".java")) {
                    archives.add(file);
                }
            } else {
                archives.addAll(inputDirectory(file));
            }
        }
        return archives;
    }
}
