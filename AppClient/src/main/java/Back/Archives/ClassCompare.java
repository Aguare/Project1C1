package Back.Archives;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ClassCompare implements Serializable {

    private ArrayList<File> c1;
    private ArrayList<File> c2;

    public ClassCompare(ArrayList<File> c1, ArrayList<File> c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public ArrayList<File> getC1() {
        return c1;
    }

    public void setC1(ArrayList<File> c1) {
        this.c1 = c1;
    }

    public ArrayList<File> getC2() {
        return c2;
    }

    public void setC2(ArrayList<File> c2) {
        this.c2 = c2;
    }
}
