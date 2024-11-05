import java.util.*;

// Implementación de la Interfaz SymbolTableStack
// Con esta clase gestionamos una pila de tablas de símbolos, permitiendo operaciones varias
class SymbolTableStackImpl implements SymbolTableStack {
    private Stack<SymbolTable> stack;

    // Constructor de la pila de tablas de smibolos
    public SymbolTableStackImpl() {
        stack = new Stack<>();
    }

    // Metodo para agregar una tabla de símbolos en la cima de la pila
    @Override
    public void push(SymbolTable table) {
        stack.push(table);
    }

    // Metodo para quitar y devolver la tabla de simbolos en la cima de la pila
    @Override
    public SymbolTable pop() {
        return stack.pop();
    }

    // Metodo para obtener la tabla de simbolos en la cima de la pila sin quitarla
    @Override
    public Optional<SymbolTable> peek() {
        return stack.isEmpty() ? Optional.empty() : Optional.of(stack.peek());
    }

    // Metodo para obtener la tabla de simbolos en la base de la pila
    @Override
    public Optional<SymbolTable> base() {
        return stack.isEmpty() ? Optional.empty() : Optional.of(stack.firstElement());
    }

    // Metodo para buscar un simbolo basado en su identificador en todas las tablas de la pila
    @Override
    public Optional<SymbolTable> lookup(String id) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            SymbolTable table = stack.get(i);
            Optional<Symbol> symbol = table.getSymbol(id);
            if (symbol.isPresent()) {
                return Optional.of(table);
            }
        }
        return Optional.empty();
    }
}
