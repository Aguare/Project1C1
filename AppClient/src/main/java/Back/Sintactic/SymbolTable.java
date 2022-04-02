package Back.Sintactic;

import java.util.HashMap;

/**
 *
 * @author aguare
 */
public class SymbolTable {

    private HashMap<String, Object> table = new HashMap<String, Object>();

    public SymbolTable() {
    }

    public boolean addSymbol(String key, Object obj) {
        Object response = this.table.put(key, obj);
        Object r = this.table.put(key, "Otro Objeto");
        Object r2 = this.table.put(key, "3");
        Object r3 = table.get("nueva");
        System.out.println(r.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        return false;
    }

    public boolean existsSymbol(String key) {
        Object o = table.get(key);
        return o != null;
    }
}
