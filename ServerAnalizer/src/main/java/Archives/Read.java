package Archives;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author aguare
 */
public class Read {

    public File readFile(String path) {
        return new File(path);
    }
    
    public String getPath() {
        JFileChooser fChooser = new JFileChooser();
        fChooser.setDialogTitle("Selecciona el archivo dentro de la carpeta");
        fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int tmp = fChooser.showOpenDialog(null);
        return tmp == JFileChooser.APPROVE_OPTION ? String.format("%1$s/%2$s", fChooser.getCurrentDirectory().getAbsolutePath(), fChooser.getSelectedFile()) : null;
    }
}
