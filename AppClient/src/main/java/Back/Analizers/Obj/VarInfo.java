package Back.Analizers.Obj;

/**
 *
 * @author aguare
 */
public class VarInfo {

    private String name;
    private String type;
    private String function;

    public VarInfo(String name, String type, String function) {
        this.name = name;
        this.type = type;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Variable -> Nombre: " + name + " Tipo: " + type + " Funcion: " + function;
    }
}
