package Back.Conecction;

import Back.Archives.ClassCompare;
import Back.Archives.ServerSend;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author aguare
 */
public class SendArchives {

    private JTextArea console;

    public SendArchives(JTextArea console) {
        this.console = console;
    }

    public String createSocket(ClassCompare archives) {
        String response = "NO HAY RESPUESTA";
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            ServerSend send = new ServerSend(socket.getInputStream(), socket.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(archives);
            for (File file : archives.getC1()) {
                send.sendFile(file);
            }
            for (File file : archives.getC2()) {
                send.sendFile(file);
            }
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            response = in.readUTF();
            out.close();
        } catch (Exception e) {
            console.append("ERROR -> No hay respuesta del servidor\n");
        }
        return response;
    }

}
