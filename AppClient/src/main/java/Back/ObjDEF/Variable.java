package Back.ObjDEF;

/**
 *
 * @author aguare
 */
public class Variable {

    private TypeVar type;
    private String value;
    private String id;

    public Variable(TypeVar type, String value, String id) {
        this.type = type;
        this.value = value;
        this.id = id;
    }

    public TypeVar getType() {
        return type;
    }

    public void setType(TypeVar type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID:" + id + "\t| Valor:" + value + "\t| Tipo:" + type;
    }
}
