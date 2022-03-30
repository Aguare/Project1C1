package Back.Controller;

import Back.Objects.ClassInfo;
import Back.Objects.FunctionInfo;
import Back.Objects.TypeVar;
import Back.Objects.VariableInfo;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aguare
 */
public class SaveInfo {

    private String name_class = "UNDEFINED";

    //Variable for build objects
    private String name_function = "UNDEFINED";
    private String type_return = "UNDEFINED";
    private ArrayList<FunctionInfo> functions = new ArrayList<>();
    private ArrayList<VariableInfo> variables = new ArrayList<>();
    private ArrayList<VariableInfo> variablesf = new ArrayList<>();
    private ArrayList<VariableInfo> parameters = new ArrayList<>();

    public ClassInfo getResult(ArrayList<String> comentarios, String name_project) {
        return new ClassInfo(name_project, name_class, comentarios, variables, functions);
    }

    public void closeDeclarationFun(int line, int column, String name) {
        Collections.reverse(parameters);
        FunctionInfo newF = new FunctionInfo(line, column, name, type_return,
                (ArrayList<VariableInfo>) variablesf.clone(),
                (ArrayList<VariableInfo>) parameters.clone());
        newF.changeParameters(name);
        functions.add(newF);
        clearLists();
    }

    private void clearLists() {
        variables.clear();
        variablesf.clear();
        parameters.clear();
    }

    public void setname_class(String name_class) {
        this.name_class = name_class;
    }

    public void setName_function(String name_function) {
        this.name_function = name_function;
    }

    public void setType_return(String type_return) {
        this.type_return = type_return;
    }

    public void addVarToClass(int line, int column, ArrayList<String> id, String type) {
        Collections.reverse(id);
        for (String name_var : id) {
            if (!name_var.equalsIgnoreCase("null")) {
                insertVar(line, column, name_var, type, 1, "Clase " + name_class);
            }
        }
    }

    public void addVarToFunc(int line, int column, ArrayList<String> id, String type) {
        Collections.reverse(id);
        for (String name_var : id) {
            if (!name_var.equalsIgnoreCase("null")) {
                insertVar(line, column, name_var, type, 2, name_function);
            }
        }
    }

    public void addParameter(int line, int column, String id, String type) {
        parameters.add(new VariableInfo(line, column, id, name_function, getType(type)));
    }

    private void insertVar(int line, int column, String id, String type, int op, String father) {
        TypeVar t = getType(type);
        if (op == 1) {
            variables.add(new VariableInfo(line, column, id, "" + father, t));
        } else {
            variablesf.add(new VariableInfo(line, column, id, "" + father, t));
        }
    }

    private TypeVar getType(String type_variable) {
        switch (type_variable) {
            case "int":
                return TypeVar.INTEGER;
            case "boolean":
                return TypeVar.BOOLEAN;
            case "String":
                return TypeVar.STRING;
            case "char":
                return TypeVar.CHAR;
            case "double":
                return TypeVar.DOUBLE;
            case "Object":
                return TypeVar.OBJECT;
            default:
                return TypeVar.ID;
        }
    }

}
