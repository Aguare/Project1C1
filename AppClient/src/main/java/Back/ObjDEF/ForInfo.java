package Back.ObjDEF;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ForInfo {

    private int init;
    private String iterator;
    private int max;
    private ArrayList<Object> internal;

    public ForInfo(int init, String iterator, int max, ArrayList<Object> internal) {
        this.init = init;
        this.iterator = iterator;
        this.max = max;
        this.internal = internal;
    }

    public String getIterator() {
        return iterator;
    }

    public void setIterator(String iterator) {
        this.iterator = iterator;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ArrayList<Object> getInternal() {
        return internal;
    }

    public void setInternal(ArrayList<Object> internal) {
        this.internal = internal;
    }

    public void changeIterator(int n) {
        changeIt(n, internal);
    }

    private void changeIt(int n, ArrayList<Object> entry) {
        for (Object o : entry) {
            if (o instanceof Tag tag) {
                changeIt(n, tag.getInternal());
            } else if (o instanceof Instruction ins) {
                if (ins.getType() != TypeVar.VARIABLE) {
                    ins.setN("" + n);
                }
            }
        }
    }

}
