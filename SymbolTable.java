import java.util.*;

// Implementación de SymbolTable
// Esta clase gestiona un conjunto de símbolos, permitiendo añadirlos y obtenerlos por su identificador.
class SymbolTable {
    // Mapa para almacenar los símbolos
    private Map<String, Symbol> symbols;

    // Constructor de la tabla de simbolos
    public SymbolTable() {
        symbols = new HashMap<>();
    }

    // Metodo para añadir un nuevo simbolo a la tabla.
    public void addSymbol(String id, Symbol symbol) {
        if (symbols.containsKey(id)) {
            throw new IllegalStateException("Error: El símbolo '" + id + "' ya ha sido declarado.");
        }
        symbols.put(id, symbol);
    }

    // Metodo para obtener un símbolo de la tabla dado por su identificador
    public Optional<Symbol> getSymbol(String id) {
        return Optional.ofNullable(symbols.get(id));
    }
}