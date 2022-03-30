package Back.Objects;

/**
 *
 * @author aguare
 */
public class VariableInfo {

    private int line, column;
    private String name, name_father;
    private TypeVar type;

    public VariableInfo(int line, int column, String name, String name_father, TypeVar type) {
        this.line = line;
        this.column = column;
        this.name = name;
        this.name_father = name_father;
        this.type = type;
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

    public String getName_father() {
        return name_father;
    }

    public void setName_father(String name_father) {
        this.name_father = name_father;
    }

    public TypeVar getType() {
        return type;
    }

    public void setType(TypeVar type) {
        this.type = type;
    }
}
