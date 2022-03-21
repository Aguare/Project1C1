package Objects;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ClassInfo {

    private String name;
    private ArrayList<String> comentarios;
    private ArrayList<VariableInfo> variables;
    private ArrayList<FunctionInfo> functions;

    public ClassInfo(String name, ArrayList<String> comentarios, ArrayList<VariableInfo> variables, ArrayList<FunctionInfo> functions) {
        this.name = name;
        this.comentarios = comentarios;
        this.variables = variables;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
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
