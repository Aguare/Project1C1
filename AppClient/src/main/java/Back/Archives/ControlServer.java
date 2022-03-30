package Back.Archives;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author aguare
 */
public class ControlServer {

    private final String JAVA_DIRS = "tmp/JAVA";

    public ControlServer() {
    }

    public boolean setup() {
        try {
            File dir = new File("tmp/");
            if (dir.exists()) {
                clearFolder(dir.toPath());
            }
            dir = new File(String.format("%1$s/%2$s", JAVA_DIRS, "P1"));
            dir.mkdirs();
            dir = new File(JAVA_DIRS, "P2");
            dir.mkdirs();
            return true;
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
            return false;
        }
    }

    public String readFile(File file) {
        String text = "";
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                text += reader.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Error while read file: " + e);
        }
        return text;
    }

    public boolean writeFile(String subDir, String filename, ArrayList<String> lines) {
        try {
            File dir = new File(String.format("%1$s/%2$s", JAVA_DIRS, subDir));
            File file = new File(dir, filename);
            file.createNewFile();
            try (PrintWriter pw = new PrintWriter(file, "UTF-8")) {
                lines.forEach(_line -> {
                    pw.println(_line);
                });
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (IOException ex) {
            return false;
        }
    }

    private void clearFolder(Path path) throws IOException {
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    public ArrayList<File> getFiles(String path) {
        ArrayList<File> filesOK = new ArrayList<>();
        if (path != null && new File(path).isDirectory()) {
            File[] files = new File(path).listFiles();
            addFiles(files, filesOK);
            Collections.sort(filesOK);
        }
        return filesOK;
    }

    public void addFiles(File[] files, ArrayList<File> filesOK) {
        for (File file : files) {
            if (!file.isDirectory()) {
                if (file.isFile() && endsWith(".java", file.getName())) {
                    filesOK.add(file);
                }
            } else {
                File[] filesTmp = new File(file.getAbsolutePath()).listFiles();
                addFiles(filesTmp, filesOK);
            }
        }
    }

    public boolean endsWith(String extension, String string) {
        return string.endsWith(extension);
    }

    public File getWrittenFile(String path) {
        try {
            return new File(path);
        } catch (Exception e) {
            return null;
        }
    }

    public String getJAVA_DIRS() {
        return JAVA_DIRS;
    }
}
