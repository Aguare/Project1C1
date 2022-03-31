package Back.Analizers;

import Back.Analizers.Obj.MethodInfo;
import Back.Analizers.Obj.VarInfo;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class RecordJSON {

    //Errors
    ArrayList<ErrorLP> error = new ArrayList<>();

    //count for declarations
    private int c_class = 0;
    private int c_var = 0;
    private int c_method = 0;
    private int c_comm = 0;
    private int c_score = 0;

    //For save info
    private ArrayList<String> classes = new ArrayList<>();
    private ArrayList<VarInfo> variables = new ArrayList<>();
    private ArrayList<MethodInfo> method = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private double score = 0.0;

    public void verifySaveInfo() {
        verifyAmount(c_class, "Clases");
        verifyAmount(c_var, "Variables");
        verifyAmount(c_method, "Metodos");
        verifyAmount(c_comm, "Comentarios");
        verifyAmount(c_score, "Score");
    }

    private void verifyAmount(int amount, String type) {
        switch (amount) {
            case 0:
                error.add(new ErrorLP(0, 0, "", 0, "Se esperaba una declaración de " + type));
                break;
            case 1:
                break;
            default:
                error.add(new ErrorLP(0, 0, "", 0, amount + " declaraciones de " + type + ", solo se tomará en cuenta la primera"));
                break;
        }
    }

    public void addClass(String name) {
        if (c_class <= 1) {
            classes.add(name);
        }
    }

    public void addVar(String name, String type, String function) {
        if (c_var <= 1) {
            variables.add(new VarInfo(name, type, function));
        }
    }

    public void addMethod(String name, String type, int parameter) {
        if (c_method <= 1) {
            method.add(new MethodInfo(name, type, parameter));
        }
    }

    public void addComment(String comment) {
        if (c_comm <= 1) {
            comments.add(comment);
        }
    }

    public void addScore(double score) {
        this.c_score++;
        if (c_score <= 1) {
            this.score = score;
        }
    }

    public void countCClass() {
        this.c_class++;
    }

    public void countCVar() {
        this.c_var++;
    }

    public void countCMethod() {
        this.c_method++;
    }

    public void countCComm() {
        this.c_comm++;
    }

    public ArrayList<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    public ArrayList<VarInfo> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VarInfo> variables) {
        this.variables = variables;
    }

    public ArrayList<MethodInfo> getMethod() {
        return method;
    }

    public void setMethod(ArrayList<MethodInfo> method) {
        this.method = method;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<ErrorLP> getError() {
        return error;
    }

    public void setError(ArrayList<ErrorLP> error) {
        this.error = error;
    }
}
