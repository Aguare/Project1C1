package Back.Sintactic;

import Back.Analizers.ErrorLP;
import Back.ObjDEF.ForInfo;
import Back.ObjDEF.Instruction;
import Back.ObjDEF.Tag;
import Back.ObjDEF.TypeVar;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aguare
 */
public class RecordHTML {

    private Tag principal;
    private ArrayList<Object> elements = new ArrayList<>();
    private ArrayList<Object> internal = new ArrayList<>();
    private SymbolTable table;
    private int init = 0, max = 0;
    private String iterator;
    private int amount_internal = 0;
    private int amount_table = 0;
    private int amount_for = 0;

    public RecordHTML(SymbolTable table) {
        this.table = table;
    }

    public void closeHTML() {
        principal = new Tag("<html>", "</html>", elements);
    }

    public void setCountFor(String init, String max, int line, int column) {
        Object a = table.getIndex(init, 100);
        Object b = table.getIndex(max, 100);
        if (a != null && b != null) {
            this.init = (int) a;
            this.max = (int) b;
            iterator = init;
        } else {
            table.addError(new ErrorLP(line, column, "iterador:" + init + " hasta:" + max, 3, "Valores inválidos"));
        }

    }

    public void closeFor() {
        ArrayList<Object> ob = getInternalTag("for");
        internal.clear();
        elements.add(new ForInfo(init, iterator, max, ob));
        init = 0;
        max = 0;
        iterator = "";
    }

    public void closeTag(String o_tag, String c_tag) {
        ArrayList<Object> ob = getInternalTag(o_tag);
        elements.add(new Tag(o_tag, c_tag, ob));
        internal.clear();
    }

    private ArrayList<Object> getInternalTag(String tag) {
        int op = 0;
        ArrayList<Object> inter = (ArrayList<Object>) internal.clone();
        if (tag.equalsIgnoreCase("<table border=\"1\">")) {
            op = amount_table;
            amount_table = 0;
        } else if (tag.equalsIgnoreCase("for")) {
            op = amount_for;
            amount_for = 0;
        } else {
            op = amount_internal;
            amount_internal = 0;
        }
        if (!elements.isEmpty() && op > 0) {
            int min = elements.size() - op;
            int maximium = elements.size();
            inter.addAll(elements.subList(min, maximium));
            elements.removeAll(inter);
        }
        return inter;
    }

    public void addInternal(Object ob) {
        if (ob instanceof String s) {
            s = s.replaceAll("\"", "");
            internal.add(s);
        } else {
            internal.add(ob);
        }

    }

    public void addIns(TypeVar type, String n, int line, int column, String op) {
        if (op.equals("")) {
            addInternal(new Instruction(type, n, line, column));
        } else {
            addInternal(new Instruction(type, n, line, column, op));
        }
    }

    public String getUltimate() {
        if (!internal.isEmpty()) {
            Object o = internal.get(internal.size() - 1);
            if (o instanceof Instruction instruction) {
                removeUltimate();
                return getInstruction(instruction);
            } else if (o instanceof String string) {
                removeUltimate();
                return string;
            }
        }
        return "";
    }

    public void amountInternal() {
        this.amount_internal++;
    }

    public void amountTable() {
        this.amount_table++;
    }

    public void amountFor() {
        this.amount_for++;
    }

    private void removeUltimate() {
        internal.remove(internal.size() - 1);
    }

    private String getInstruction(Instruction ins) {
        switch (ins.getType()) {
            case VARIABLE:
                return table.getValueVar(ins.getN(), ins.getLine(), ins.getColumn());
            case COMMENT:
                return table.getComment(ins.getN(), ins.getLine(), ins.getColumn());
            case GETVAR:
                return table.getVar(ins.getN(), ins.getLine(), ins.getColumn()).getAttibute(ins.getOp());
            case GETMETHOD:
                return table.getMethod(ins.getN(), ins.getLine(), ins.getColumn()).getAttibute(ins.getOp());
            default:
                return "ERROR RECORD HTML";
        }
    }

    public String getHTML() {
        try {
            StringBuilder write = new StringBuilder();
            write.append(principal.getO_tag()).append("\n");
            write.append(writeInternal(principal.getInternal()));
            write.append("\n").append(principal.getC_tag()).append("\n");
            return write.toString();
        } catch (Exception e) {
        }
        return "";
    }

    public String writeInternal(ArrayList<Object> internal) {
        StringBuilder write = new StringBuilder();
        for (Object o : internal) {
            if (o instanceof String string) {
                write.append(string);
            } else if (o instanceof Tag tag) {
                write.append(tag.getO_tag()).append("\n");
                write.append(writeInternal(tag.getInternal()));
                write.append("\n").append(tag.getC_tag()).append("\n");
            } else if (o instanceof Instruction ins) {
                write.append(getInstruction(ins));
            } else if (o instanceof ForInfo fo) {
                for (int i = fo.getInit(); i < fo.getMax(); i++) {
                    table.asignValue(fo.getIterator(), "" + i, 0, 0);
                    fo.changeIterator(i);
                    write.append(writeInternal(fo.getInternal()));
                }
            }
        }
        return write.toString();
    }
}
