package Back.Analizers.JSON;

import Back.Analizers.ErrorLP;
import java.io.Reader;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author aguare
 */
public class ChargeJSON {
    
    private JTextArea console;
    private Reader reader;
    private ArrayList<ErrorLP> errors = new ArrayList<>();
    
    public ChargeJSON(JTextArea console, Reader reader) {
        this.console = console;
        this.reader = reader;
    }
    
    public void chargeJSON() {
        try {
            LexerJSON lexer = new LexerJSON(reader);
            SintacticJSON sintac = new SintacticJSON(lexer);
            sintac.parse();
            errors.addAll(lexer.getErrors());
            errors.addAll(sintac.getErrors());
        } catch (Exception e) {
            errors.add(new ErrorLP(0, 0, "No se analizó", 3, "No se pudo leer el JSON"));
            e.printStackTrace();
        }
        writeConsole();
    }
    
    private void writeConsole() {
        for (ErrorLP error : errors) {
            console.append(error.toString() + "\n");
        }
    }
}
