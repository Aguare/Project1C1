package Back.Conecction;

import Back.Analizers.ErrorLP;
import Back.Archives.ClassCompare;
import Back.Archives.Compare;
import Back.Archives.ControlServer;
import Back.Archives.CreateJSON;
import Back.Archives.Read;
import Back.Archives.ServerSend;
import Back.Objects.ClassInfo;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author aguare
 */
public class ServerInput extends Thread {

    private JTextArea console;
    private CreateJSON create = new CreateJSON();
    private Compare c;
    private Read read;

    public ServerInput(JTextArea console) {
        this.console = console;
    }

    @Override
    public void run() {
        //ESTO ES EL SERVIDOR
        try {
            ServerSocket in = new ServerSocket(9999);
            while (true) {
                try (Socket socket = in.accept()) {
                    ObjectInputStream entry = new ObjectInputStream(socket.getInputStream());
                    ClassCompare classes = (ClassCompare) entry.readObject();
                    ArrayList<File> files1 = receivedArchives(socket, 1, classes.getC1());
                    ArrayList<File> files2 = receivedArchives(socket, 1, classes.getC2());
                    if (classes != null) {
                        read = new Read();
                        ArrayList<ClassInfo> c1 = read.analizeArchives(files1);
                        writeConsole(read.getErrors());
                        read = new Read();
                        ArrayList<ClassInfo> c2 = read.analizeArchives(files2);
                        writeConsole(read.getErrors());
                        c = new Compare(c1, c2);
                        c.runAnalysis();
                        try ( //Reponse
                                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
                            out.writeUTF(create.generateJSON(c.getClass_r(), c.getVar_r(), c.getFunction_r(), c.getComments_r(), c.getScore()));
                            writeConsole("Se han analizado los proyectos");
                            new ControlServer().setup();
                        }
                    }
                    entry.close();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            writeConsole(ex.getMessage());
        }
    }

    private ArrayList<File> receivedArchives(Socket socket, int p, ArrayList<File> files) {
        ArrayList<File> c1 = new ArrayList<>();
        try {
            for (File file : files) {
                ServerSend send = new ServerSend(socket.getInputStream(), socket.getOutputStream());
                File reader = null;
                if (p == 1) {
                    send.receiveFile(file.getName(), "P1");
                } else {
                    send.receiveFile(file.getName(), "P2");
                }
                reader = new File("tmp/JAVA/P" + p + "/" + file.getName());
                c1.add(reader);
                writeConsole(send.getErrors());
            }
        } catch (IOException e) {
            writeConsole(e.getMessage());
        }
        return c1;
    }

    private void writeConsole(ArrayList<ErrorLP> errors) {
        for (ErrorLP error : errors) {
            console.append("\n" + error.toString());
        }
    }

    private void writeConsole(String message) {
        console.append("\n" + message);

    }

}
