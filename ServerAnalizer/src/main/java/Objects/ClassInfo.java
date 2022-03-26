package Objects;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ClassInfo {

    private String name;
    private ArrayList<String> comments;
    private ArrayList<VariableInfo> variables;
    private ArrayList<FunctionInfo> functions;

    public ClassInfo(String name, ArrayList<String> comments, ArrayList<VariableInfo> variables, ArrayList<FunctionInfo> functions) {
        this.name = name;
        this.comments = comments;
        this.variables = variables;
        this.functions = functions;
    }

    public int getTotalVariables() {
        int total = 0;
        for (FunctionInfo f : functions) {
            total += f.getParameters().size() + f.getVariables().size();
        }
        return total + variables.size();
    }

    public int getTotalComments() {
        return comments.size();
    }

    public String getName() {
        this.variables.get(1).setColumn(0);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getComentarios() {
        return comments;
    }

    public void setComentarios(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<VariableInfo> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VariableInfo> variables) {
        this.variables = variables;
    }

    public ArrayList<FunctionInfo> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<FunctionInfo> functions) {
        this.functions = functions;
    }

}
