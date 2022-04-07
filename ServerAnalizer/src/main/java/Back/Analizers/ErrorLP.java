package Back.Analizers;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ErrorLP {

    private int line;
    private int column;
    private String content;
    // 0 Lexer, 1 Sintactic 
    private int typeError;
    private String message;
    private ArrayList<String> expected;

    public ErrorLP(int line, int column, String content, int typeError, String message, ArrayList<String> expected) {
        this.line = line;
        this.column = column;
        this.content = content;
        this.typeError = typeError;
        this.message = message;
        this.expected = expected;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTypeError() {
        return typeError;
    }

    public void setTypeError(int typeError) {
        this.typeError = typeError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeError(int type) {
        switch (type) {
            case 0:
                return "Error Léxico";
            case 1:
                return "Error Sintáctico";
            default:
                return "Error ";
        }
    }

    private String getExpected() {
        String num = "";
        for (int i = 0; i < expected.size(); i++) {
            if (i != expected.size() - 1) {
                num = num + expected.get(i) + ",";
            } else {
                num = num + expected.get(i);
            }
        }
        return num;
    }

    @Override
    public String toString() {
        if (line == 0 && column == 0) {
            return message;
        }
        if (expected != null & !expected.isEmpty()) {
            return getTypeError(typeError) + " -> L:" + line + "\tC:" + column + "\t ' " + content + " ' " + message + " Se esperaba -> " + getExpected();
        } else {
            return getTypeError(typeError) + " -> L:" + line + "\tC:" + column + "\t ' " + content + " ' " + message;
        }
    }

}
