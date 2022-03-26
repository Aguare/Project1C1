package Conecction;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aguare
 */
public class ServerInput implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket in = new ServerSocket(9999);
            while (true) {
                Socket socket = in.accept();
                DataInputStream entry = new DataInputStream(socket.getInputStream());
                String mensaje = entry.readUTF();
                System.out.println("-------------");
                System.out.println(mensaje);
                System.out.println("-------------");
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
