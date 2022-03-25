package Controller;

import Objects.VariableInfo;

/**
 *
 * @author aguare
 */
public class Repeated {

    //type repeated
    private TypeEs type;

    //if repeated is a variable
    private VariableInfo var1, var2;

    //if reapeted is a class
    private String class1, class2;

    //if repeated is method or function
    private String function1, type1;
    private String function2, type2;
    private int param1, param2;

    //if repeated is a comment
    private String text;

    /**
     * Create for variables
     *
     * @param type TypeEs.VAR
     * @param var1
     * @param var2
     */
    public Repeated(TypeEs type, VariableInfo var1, VariableInfo var2) {
        this.type = type;
        this.var1 = var1;
        this.var2 = var2;
    }

    /**
     * Create for classes
     *
     * @param type TypeEs.CLASS
     * @param class1
     * @param class2
     */
    public Repeated(TypeEs type, String class1, String class2) {
        this.type = type;
        this.class1 = class1;
        this.class2 = class2;
    }

    /**
     * Create for methods or functions
     *
     * @param type
     * @param function1
     * @param type1
     * @param function2
     * @param type2
     * @param param1
     * @param param2
     */
    public Repeated(TypeEs type, String function1, String type1, String function2, String type2, int param1, int param2) {
        this.type = type;
        this.function1 = function1;
        this.type1 = type1;
        this.function2 = function2;
        this.type2 = type2;
        this.param1 = param1;
        this.param2 = param2;
    }

    /**
     * Create for comments
     *
     * @param type
     * @param text
     */
    public Repeated(TypeEs type, String text) {
        this.type = type;
        this.text = text;
    }

    public TypeEs getType() {
        return type;
    }

    public void setType(TypeEs type) {
        this.type = type;
    }

    public VariableInfo getVar1() {
        return var1;
    }

    public void setVar1(VariableInfo var1) {
        this.var1 = var1;
    }

    public VariableInfo getVar2() {
        return var2;
    }

    public void setVar2(VariableInfo var2) {
        this.var2 = var2;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getFunction1() {
        return function1;
    }

    public void setFunction1(String function1) {
        this.function1 = function1;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getFunction2() {
        return function2;
    }

    public void setFunction2(String function2) {
        this.function2 = function2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
