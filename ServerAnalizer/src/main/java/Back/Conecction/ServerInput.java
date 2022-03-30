package Back.Conecction;

import Back.Analizers.ErrorLP;
import Back.Archives.ClassCompare;
import Back.Archives.Compare;
import Back.Archives.CreateJSON;
import Back.Archives.Read;
import Back.Objects.ClassInfo;
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
                Socket socket = in.accept();
                ObjectInputStream entry = new ObjectInputStream(socket.getInputStream());
                console.append("SE RECIBIERON DATOS");
                ClassCompare classes = (ClassCompare) entry.readObject();
                if (classes != null) {
                    read = new Read();
                    ArrayList<ClassInfo> c1 = read.analizeArchives(classes.getC1());
                    writeConsole(read.getErrors());
                    read = new Read();
                    ArrayList<ClassInfo> c2 = read.analizeArchives(classes.getC2());
                    writeConsole(read.getErrors());
                    c = new Compare(c1, c2);
                    c.runAnalysis();
                    //Reponse
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeUTF(create.generateJSON(c.getClass_r(), c.getVar_r(), c.getFunction_r(), c.getComments_r(), c.getScore()));
                    writeConsole("Se han analizado los proyectos");
                    out.close();
                }
                entry.close();
                socket.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            writeConsole(ex.getMessage());
        }
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
