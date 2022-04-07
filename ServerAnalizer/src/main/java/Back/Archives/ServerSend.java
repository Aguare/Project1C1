package Back.Archives;

import Back.Analizers.ErrorLP;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ServerSend {

    DataInputStream inputStream;
    DataOutputStream outputStream;
    ArrayList<ErrorLP> errors = new ArrayList<>();

    public ServerSend(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void sendFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int bytes = 0;
            this.outputStream.writeLong(file.length());
            byte[] buffer = new byte[4 * 1024];
            while ((bytes = fileInputStream.read(buffer)) != -1) {
                this.outputStream.write(buffer, 0, bytes);
                this.outputStream.flush();
            }
        } catch (Exception ex) {
            errors.add(new ErrorLP(0, 0, "", 1, "Error en el envío del archivo -> " + file.getName() + "\n" + ex.getMessage(), null));
        }
    }

    public void receiveFile(String filename, String subdir) {
        ControlServer fActioner = new ControlServer();
        File dir = new File(String.format("%1$s/%2$s", fActioner.getJAVA_DIRS(), subdir));
        File file = new File(dir, filename);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            int bytes = 0;
            long size = this.inputStream.readLong();
            byte[] buffer = new byte[4 * 1024];
            while (size > 0 && (bytes = this.inputStream.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                fileOutputStream.write(buffer, 0, bytes);
                size -= bytes;
            }
        } catch (Exception e) {
            errors.add(new ErrorLP(0, 0, "", 1, "Error al recibir el archivo -> " + file.getName() + "\n" + e.getMessage(), null));
        }
    }

    public ArrayList<ErrorLP> getErrors() {
        return errors;
    }
}
