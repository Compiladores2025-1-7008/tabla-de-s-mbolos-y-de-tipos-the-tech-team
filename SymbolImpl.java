import java.util.*;

// Implementación de la Interfaz Symbol
// En esta clase se define un símbolo con información como dirección, tipo, categoría y argumentos.
class SymbolImpl implements Symbol {
    private int dir;
    private int type;
    private String cat;
    private ArrayList<Integer> args;

    // Constructor para inicializar los atributos del símbolo
    public SymbolImpl(int dir, int type, String cat, ArrayList<Integer> args) {
        this.dir = dir;
        this.type = type;
        this.cat = cat;
        this.args = args;
    }

    // Devuelve la dirección del símbolo
    @Override
    public int getDir() {
        return dir;
    }

    // Devuelve el tipo del símbolo
    @Override
    public int getType() {
        return type;
    }

    // Devuelve la categoría del símbolo
    @Override
    public String getCat() {
        return cat;
    }

    // Devuelve la lista de argumentos asociados al símbolo
    @Override
    public ArrayList<Integer> getArgs() {
        return args;
    }
}
