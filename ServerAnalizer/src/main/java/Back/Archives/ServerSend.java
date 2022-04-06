package Back.Archives;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author aguare
 */
public class ServerSend {

    DataInputStream inputStream;
    DataOutputStream outputStream;

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
            System.out.println("ERROR SENDING FILE " + ex.getMessage());
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
                size -= bytes;// read up to file size
            }
        } catch (Exception e) {
            System.out.println("ERROR RECEIVING FILE: " + e.getMessage());
        }
    }
}
