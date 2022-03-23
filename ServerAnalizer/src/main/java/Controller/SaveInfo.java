package Controller;

import Objects.ClassInfo;
import Objects.FunctionInfo;
import Objects.TypeVar;
import Objects.VariableInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author aguare
 */
public class SaveInfo {

    private String name_class = "UNDEFINED";

    //Variable for build objects
    private String name_function;
    private ArrayList<FunctionInfo> functions = new ArrayList<>();
    private ArrayList<VariableInfo> variables = new ArrayList<>();
    private ArrayList<VariableInfo> variablesf = new ArrayList<>();
    private ArrayList<VariableInfo> parameters = new ArrayList<>();

    public ClassInfo getResult(ArrayList<String> comentarios) {
        return new ClassInfo(name_class, comentarios, variables, functions);
    }

    public void closeDeclarationFun(int line, int column) {
        functions.add(new FunctionInfo(line, column, name_function, variablesf, parameters));
        clearLists();
    }

    public void clearLists() {
        variables.clear();
        variablesf.clear();
        parameters.clear();
        name_function = "UNDEFINED";
    }

    public void setname_class(String name_class) {
        this.name_class = name_class;
    }

    public void setName_function(String name_function) {
        this.name_function = name_function;
    }

    public void addVarToClass(int line, int column, ArrayList<String> id, String type) {
        Collections.reverse(id);
        for (String name_var : id) {
            if (!name_var.equalsIgnoreCase("null")) {
                insertVar(line, column, name_var, type);
            }
        }
    }

    public void addVarToFunc(int line, int column, String id, String type) {
        TypeVar t = getType(type);
        if (!verifyExistsVar(id, t, line)) {
            variablesf.add(new VariableInfo(line, column, id, name_class, t));
        }
    }

    public void addParameter(int line, int column, String id, TypeVar type) {
        parameters.add(new VariableInfo(line, column, id, name_function, type));
    }

    private void insertVar(int line, int column, String id, String type) {
        TypeVar t = getType(type);
        if (!verifyExistsVar(id, t, line)) {
            System.out.println("ID -> " + id);
            variables.add(new VariableInfo(line, column, id, name_class, t));
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
                return TypeVar.UNDEFINED;
        }
    }

    private boolean verifyExistsVar(String id, TypeVar type, int op) {
        if (op == 1) {
            return readList(variables, type, id);
        } else {
            return readList(variablesf, type, id);
        }
    }

    private boolean readList(ArrayList<VariableInfo> list, TypeVar type, String name_var) {
        for (VariableInfo v : list) {
            if (v.getName().equalsIgnoreCase(name_var)) {
                if (v.getType() == TypeVar.UNDEFINED && type != TypeVar.UNDEFINED) {
                    v.setType(type);
                }
                return true;
            }
        }
        return false;
    }
}
