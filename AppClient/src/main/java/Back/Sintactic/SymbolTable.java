package Back.Sintactic;

import Back.Analizers.ErrorLP;
import Back.Analizers.Obj.MethodInfo;
import Back.Analizers.Obj.VarInfo;
import Back.Analizers.RecordJSON;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aguare
 */
public class SymbolTable {

    //Variables of JSON
    private RecordJSON json;

    private ArrayList<ErrorLP> errors = new ArrayList<>();
    private HashMap<String, Object> table = new HashMap<String, Object>();

    public SymbolTable(RecordJSON json) {
        this.json = json;
    }

    public void declaratedVar(String id, String value, String type, int line, int column) {
        value = value.replaceAll("\"", "");
        if (existsVar(id)) {
            errors.add(new ErrorLP(line, column, id, 3, "La variable ya está definida"));
        } else {
            if (getType(type) == TypeVar.INTEGER) {
                declaratedInt(id, value, TypeVar.INTEGER, line, column);
            } else {
                table.put(id, new Variable(getType(type), value, id));
                System.out.println("ID:" + id + " Tipo:" + getType(type) + "\tV:" + value);
            }
        }
    }

    private void declaratedInt(String id, String value, TypeVar type, int line, int column) {
        if (value.equals("")) {
            table.put(id, new Variable(type, "" + 0, id));
            System.out.println("ID:" + id + " Tipo:" + type + "\tV:" + 0);
        } else {
            Object o = castStringToInt(value);
            if (o != null) {
                table.put(id, new Variable(type, "" + (int) o, id));
                System.out.println("ID:" + id + " Tipo:" + type + "\tV:" + value);
            } else {
                errors.add(new ErrorLP(line, column, id, 3, "Imposible asignar letras a un Entero"));
            }
        }
    }

    public void asignValue(String id, String value, int line, int column) {
        if (existsVar(id)) {
            value = value.replaceAll("\"", "");
            Variable var = (Variable) table.get(id);
            if (var.getType() == TypeVar.INTEGER) {
                asignInt(var, value, line, column);
            } else {
                var.setValue(value);
                table.put(id, var);
                System.out.println("ID:" + id + " Tipo:" + var.getType() + "\tV:" + value);
            }

        } else {
            errors.add(new ErrorLP(line, column, id, 3, "La variable aún no está definida"));
        }
    }

    private void asignInt(Variable var, String value, int line, int column) {
        Object o = castStringToInt(value);
        if (o != null) {
            var.setValue("" + (int) o);
            table.put(var.getId(), var);
            System.out.println("ID:" + var.getId() + " Tipo:" + var.getType() + "\tV:" + value);
        } else {
            errors.add(new ErrorLP(line, column, var.getId(), 3, "Imposible asignar letras a un Entero"));
        }
    }

    public String getValueVar(String id, int line, int column) {
        if (existsVar(id)) {
            Variable var = (Variable) table.get(id);
            return var.getValue();
        } else {
            errors.add(new ErrorLP(line, column, id, 3, "La variable aún no está definida"));
            return "";
        }
    }

    public String getScore() {
        return "" + json.getScore();
    }

    public String getClass(String n, int line, int column) {
        Object o = getIndex(n, json.getClasses().size() - 1);
        if (o != null) {
            return json.getClasses().get((int) o);
        } else {
            errors.add(new ErrorLP(line, column, "Clases[" + n + "]", 3, "El valor no existe"));
            return "";
        }
    }
    
    public String getComment(String n, int line, int column) {
        Object o = getIndex(n, json.getComments().size() - 1);
        if (o != null) {
            return json.getComments().get((int) o);
        } else {
            errors.add(new ErrorLP(line, column, "Comentarios[" + n + "]", 3, "El valor no existe"));
            return "";
        }
    }

    public VarInfo getVar(String n, int line, int column) {
        Object o = getIndex(n, json.getVariables().size() - 1);
        if (o != null) {
            return json.getVariables().get((int) o);
        } else {
            errors.add(new ErrorLP(line, column, "Variables[" + n + "]", 3, "El valor no existe"));
            return new VarInfo("", "", "");
        }
    }

    public MethodInfo getMethod(String n, int line, int column) {
        Object o = getIndex(n, json.getMethod().size() - 1);
        if (o != null) {
            return json.getMethod().get((int) o);
        }else{
            errors.add(new ErrorLP(line, column, "Metodos[" + n + "]", 3, "El valor no existe"));
            return new MethodInfo("", "", 0);
        }
    }

    private Object getIndex(String n, int max) {
        Object o = castStringToInt(n);
        if (o != null) {
            if ((int) o <= max) {
                return o;
            }
        } else {
            String value = getValueVar(n, 0, 0);
            Object a = castStringToInt(value);
            if (a != null) {
                if ((int) a <= max) {
                    return a;
                }
            }
        }
        return null;
    }

    private Object castStringToInt(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private boolean existsVar(String id) {
        Object o = table.get(id);
        return o != null;
    }

    private TypeVar getType(String type) {
        switch (type) {
            case "String":
                return TypeVar.STRING;
            case "Integer":
                return TypeVar.INTEGER;
            case "List":
                return TypeVar.LIST;
            default:
                return TypeVar.UNDEFINED;
        }
    }

    public ArrayList<ErrorLP> getErrors() {
        return errors;
    }
}
