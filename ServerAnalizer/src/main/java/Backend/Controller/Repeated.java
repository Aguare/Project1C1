package Backend.Controller;

import Backend.Objects.VariableInfo;

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
    private String class1;

    //if repeated is method or function
    private String function1, type1;
    private int param1;

    //if repeated is a comment
    private String text;

    //if for score
    private double score;

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
     * Create for classes and Comments
     *
     * @param type TypeEs.CLASS
     * @param class1
     */
    public Repeated(TypeEs type, String class1) {
        this.type = type;
        this.class1 = class1;
    }

    /**
     * Create for methods or functions
     *
     * @param type
     * @param function1
     * @param type1
     * @param param1
     */
    public Repeated(TypeEs type, String function1, String type1, int param1) {
        this.type = type;
        this.function1 = function1;
        this.type1 = type1;
        this.param1 = param1;
    }

    public Repeated(TypeEs type, double score) {
        this.type = type;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        switch (type) {
            case CLASS:
                return "{Nombre: \"" + class1 + "\"}";
            case VAR:
                return "{Nombre: \"" + var1.getName() + "\", Tipo:\"" + var1.getType()
                        + "\", Funcion: \"" + var1.getName_father() + ", " + var2.getName_father()
                        + "\"}";
            case METHOD:
                return "{Nombre: \"" + function1 + "\", Tipo: \"" + type1 + "\", Parametros: " + param1 + "}";
            case COMMENT:
                return "{Texto: " + text + "}";
            case SCORE:
                return "Score: \"" + score + "\"";
            default:
                return "UNDEFINED";
        }
    }
}
