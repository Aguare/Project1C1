package Back.ObjDEF;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Tag {

    private String o_tag;
    private String c_tag;
    private ArrayList<Object> internal;

    public Tag(String o_tag, String c_tag, ArrayList<Object> internal) {
        this.o_tag = o_tag;
        this.c_tag = c_tag;
        this.internal = internal;
    }

    public String getO_tag() {
        return o_tag;
    }

    public void setO_tag(String o_tag) {
        this.o_tag = o_tag;
    }

    public String getC_tag() {
        return c_tag;
    }

    public void setC_tag(String c_tag) {
        this.c_tag = c_tag;
    }

    public ArrayList<Object> getInternal() {
        return internal;
    }

    public void setInternal(ArrayList<Object> internal) {
        this.internal = internal;
    }

}
