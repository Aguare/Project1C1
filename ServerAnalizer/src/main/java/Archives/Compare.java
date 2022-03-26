package Archives;

import Controller.Repeated;
import Controller.TypeEs;
import Objects.ClassInfo;
import Objects.FunctionInfo;
import Objects.VariableInfo;
import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class Compare {

    private ArrayList<Repeated> class_r = new ArrayList<>();
    private ArrayList<Repeated> var_r = new ArrayList<>();
    private ArrayList<Repeated> function_r = new ArrayList<>();
    private ArrayList<Repeated> comments_r = new ArrayList<>();

    private ArrayList<ClassInfo> c1;
    private ArrayList<ClassInfo> c2;

    //for calculated score
    private double score = 0;
    private int total_comments = 0;
    private int total_variables = 0;
    private int total_functions = 0;

    public Compare(ArrayList<ClassInfo> c1, ArrayList<ClassInfo> c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * Start
     *
     */
    public void runAnalysis() {
        verifyClasses();
        verifyVarR();
        verifyFunctions();
        verifyComments();
        calculateScore();
    }

    private void calculateScore() {
        calculateTotals();
        //Comments
        this.score += (this.comments_r.size() / total_comments) * 0.25;
        //variables
        this.score += (this.var_r.size() / total_variables) * 0.25;
        //Functions
        this.score += (this.function_r.size() / total_functions) * 0.25;
        //classes
        this.score += (this.class_r.size() / (c1.size() + c2.size())) * 0.25;
    }

    private void calculateTotals() {
        for (ClassInfo c : c1) {
            this.total_comments += c.getTotalComments();
            this.total_variables += c.getTotalVariables();
            this.total_functions += c.getFunctions().size();
        }
        for (ClassInfo c : c2) {
            this.total_comments += c.getTotalComments();
            this.total_variables += c.getTotalVariables();
            this.total_functions += c.getFunctions().size();
        }
    }

    private void verifyComments() {
        for (ClassInfo c : c1) {
            for (ClassInfo cc : c2) {
                compareComments(c.getComentarios(), cc.getComentarios());
            }
        }
    }

    private void verifyClasses() {
        for (ClassInfo ce : c1) {
            compareNameClass(ce);
        }
    }

    private void verifyFunctions() {
        for (ClassInfo ce : c1) {
            ArrayList<FunctionInfo> functions = ce.getFunctions();
            for (FunctionInfo f : functions) {
                compareFunctions(f);
            }
        }
    }

    private void verifyVarR() {
        for (ClassInfo ce : c1) {
            //Compare global variables
            ArrayList<VariableInfo> var = ce.getVariables();
            for (VariableInfo v : var) {
                compareVarClass(v);
            }
            ArrayList<FunctionInfo> functions = ce.getFunctions();
            for (FunctionInfo f : functions) {
                //Compare parameters of functions
                ArrayList<VariableInfo> var1 = f.getParameters();
                for (VariableInfo varP : var1) {
                    compareVarClass(varP);
                }
                var1 = f.getVariables();
                //Compare variables within functions 
                for (VariableInfo varI : var1) {
                    compareVarClass(varI);
                }
            }
        }
    }

    private void compareComments(ArrayList<String> c1, ArrayList<String> c2) {
        for (String com1 : c1) {
            for (String com2 : c2) {
                if (com1.equals(com2)) {
                    comments_r.add(new Repeated(TypeEs.COMMENT, com1));
                }
            }
        }
    }

    private void compareFunctions(FunctionInfo f) {
        for (ClassInfo ce : c2) {
            ArrayList<FunctionInfo> functions = ce.getFunctions();
            for (FunctionInfo ff : functions) {
                if (ff.getName().equals(f.getName())
                        && ff.getParameters().size() == f.getParameters().size()
                        && ff.getType_return().equals(f.getType_return())) {
                    if (compareParameters(f.getParameters(), ff.getParameters())) {
                        function_r.add(new Repeated(TypeEs.METHOD, f.getName(),
                                f.getType_return(), f.getParameters().size()));
                    }
                }
            }
        }
    }

    private boolean compareParameters(ArrayList<VariableInfo> param1, ArrayList<VariableInfo> param2) {
        int mount = 0;
        for (VariableInfo v1 : param1) {
            for (VariableInfo v2 : param2) {
                if (v1.getName().equals(v2.getName()) && v1.getType() == v2.getType()) {
                    mount++;
                }
            }
        }
        return mount == param1.size();
    }

    private void compareNameClass(ClassInfo c) {
        for (ClassInfo ce : c2) {
            if (c.equals(ce.getName()) && c.getFunctions().size() == ce.getFunctions().size()) {
                if (compareFunctionClass(c.getFunctions(), ce.getFunctions())) {
                    class_r.add(new Repeated(TypeEs.CLASS, c.getName()));
                }
            }
        }
    }

    private boolean compareFunctionClass(ArrayList<FunctionInfo> f1, ArrayList<FunctionInfo> f2) {
        int mount = 0;
        for (FunctionInfo f : f1) {
            for (FunctionInfo ff : f2) {
                if (f.getName().equals(ff.getName())) {
                    mount++;
                }
            }
        }
        return mount == f1.size();
    }

    private void compareVarClass(VariableInfo var) {
        for (ClassInfo ce : c2) {
            compareVarList(ce.getVariables(), var);
            ArrayList<FunctionInfo> functions = ce.getFunctions();
            for (FunctionInfo f : functions) {
                compareVarList(f.getParameters(), var);
                compareVarList(f.getVariables(), var);
            }
        }
    }

    private void compareVarList(ArrayList<VariableInfo> var2, VariableInfo var) {
        for (VariableInfo vG : var2) {
            if (vG.getName().equals(var.getName()) && vG.getType() == var.getType()) {
                var_r.add(new Repeated(TypeEs.VAR, var, vG));
            }
        }
    }

    public Repeated getScore() {
        return new Repeated(TypeEs.SCORE, score);
    }

    public ArrayList<Repeated> getClass_r() {
        return class_r;
    }

    public ArrayList<Repeated> getVar_r() {
        return var_r;
    }

    public ArrayList<Repeated> getFunction_r() {
        return function_r;
    }

    public ArrayList<Repeated> getComments_r() {
        return comments_r;
    }
}
