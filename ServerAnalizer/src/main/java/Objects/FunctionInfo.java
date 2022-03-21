package Objects;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class FunctionInfo {
    
    private int line, column;
    private String name;
    private ArrayList<VariableInfo> variables;
    private ArrayList<VariableInfo> parameters;

    public FunctionInfo(int line, int column, String name, ArrayList<VariableInfo> variables, ArrayList<VariableInfo> parameters) {
        this.line = line;
        this.column = column;
        this.name = name;
        this.variables = variables;
        this.parameters = parameters;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<VariableInfo> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VariableInfo> variables) {
        this.variables = variables;
    }

    public ArrayList<VariableInfo> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<VariableInfo> parameters) {
        this.parameters = parameters;
    }
    
    
}
