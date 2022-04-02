package Back.Analizers.Obj;

/**
 *
 * @author aguare
 */
public class MethodInfo {

    private String name;
    private String type;
    private int parameters;

    public MethodInfo(String name, String type, int parameters) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
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

    public int getParameters() {
        return parameters;
    }

    public void setParameters(int parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Metodo -> Nombre: " + name + " Tipo: " + type + " Parametros: " + parameters;
    }
}
