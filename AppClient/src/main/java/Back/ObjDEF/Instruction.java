package Back.ObjDEF;

/**
 *
 * @author aguare
 */
public class Instruction {

    private TypeVar type;
    private String n;
    private int line;
    private int column;
    private String op;

    /**
     * Constructor for GetVar, getClass, GetComment
     *
     * @param type
     * @param n
     * @param line
     * @param column
     */
    public Instruction(TypeVar type, String n, int line, int column) {
        this.type = type;
        this.n = n;
        this.line = line;
        this.column = column;
    }

    /**
     * Constructor for GetVariablesAttributes, GetMethodAttributes
     *
     * @param type
     * @param n
     * @param line
     * @param column
     * @param op
     */
    public Instruction(TypeVar type, String n, int line, int column, String op) {
        this.type = type;
        this.n = n;
        this.line = line;
        this.column = column;
        this.op = op;
    }

    public TypeVar getType() {
        return type;
    }

    public void setType(TypeVar type) {
        this.type = type;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
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

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "Tipo:" + type + " N:" + n + " L:" + line + " C:" + column + " Op:" + op;
    }
}
