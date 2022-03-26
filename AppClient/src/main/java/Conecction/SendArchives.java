package Conecction;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author aguare
 */
public class SendArchives {

    public void createSocket(String response) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(response);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
