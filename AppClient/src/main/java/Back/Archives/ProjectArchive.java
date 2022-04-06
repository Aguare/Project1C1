package Back.Archives;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aguare
 */
public class ProjectArchive {

    public void saveProject(String def, String json, String html, String path, String name) {
        File file = new File(path + "/" + name);
        boolean create = file.mkdirs();
        if (create) {
            StringBuilder w = new StringBuilder();
            w.append(createArchive(file, ".json", json, "json")).append(",");
            w.append(createArchive(file, ".def", def, "def")).append(",");
            w.append(createArchive(file, ".html", html, "report")).append(",");
            w.append(name);
            createArchive(file, ".copy", w.toString(), name);
        }
    }

    public String[] openProject(String path) {
        String[] files = new String[4];
        try {
            String[] paths = getPaths(getFile(path, ".copy").toString());
            if (paths != null) {
                files[0] = getFile(paths[0], ".json").toString();
                files[1] = getFile(paths[1], ".def").toString();
                files[2] = getFile(paths[2], ".html").toString();
                files[3] = paths[3];
            }
        } catch (Exception e) {
        }

        return files;
    }

    private StringBuilder getFile(String path, String extension) {
        StringBuilder write = new StringBuilder();
        try {
            File file = new File(path);
            if (file.exists() && file.getName().endsWith(extension)) {
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    write.append(scan.nextLine()).append("\n");
                }
                return write;
            }
        } catch (FileNotFoundException e) {
        }
        return null;
    }

    private String[] getPaths(String line) {
        String[] paths = line.split(",");
        if (paths.length == 4) {
            return paths;
        } else {
            return null;
        }
    }

    private String createArchive(File file, String extension, String content, String name) {
        try {
            FileWriter writer = new FileWriter(file + "/" + name + extension);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(content);
            buffer.close();
            return file + "/" + name + extension;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
