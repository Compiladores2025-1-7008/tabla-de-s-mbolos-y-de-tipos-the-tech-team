import java.util.*;

// Implementación de la Interfaz TypeTable
// Esta clase gestiona una tabla de tipos, permitiendo agregar y obtener tipos por su identificador.
class TypeTableImpl implements TypeTable {
    private Map<Integer, Type> types;
    private int typeCounter;

    // Constructor que inicializa la tabla de tipos y el contador
    public TypeTableImpl() {
        types = new HashMap<>();
        typeCounter = 0;
    }

    // Metodo para obtener el tamaño de un tipo dado su identificador. Si no existe devuelve cero
    @Override
    public int getTam(int id) {
        return types.containsKey(id) ? types.get(id).getTam() : 0;
    }

    // Metodo para obtener el numero de elementos de un tipo dado su identificador. Si no existe devuelve cero
    @Override
    public int getItems(int id) {
        return types.containsKey(id) ? types.get(id).getItems() : 0;
    }

    // Metodo para obtener el nombre de un tipo dado su identificador. Si no existe devuelve nulo
    @Override
    public String getName(int id) {
        return types.containsKey(id) ? types.get(id).getName() : null;
    }

    // Metodo para obtener el identificador del tipo padre de un tipo dado su identificador. Si no existe devuelve -1
    @Override
    public int getParenId(int id) {
        return types.containsKey(id) ? types.get(id).getParenId() : -1;
    }

    // Metodo para obtener la tabla de simbolos del tipo padre de un tipo por su identificador. Si no existe devuelve nulo
    @Override
    public SymbolTable getParentStruct(int id) {
        return types.containsKey(id) ? types.get(id).getParentStruct() : null;
    }

    // Metodo para obtener un tipo completo dado su identificador.
    @Override
    public Optional<Type> getType(int id) {
        return Optional.ofNullable(types.get(id));
    }

    // Metodo para agregar un nuevo tipo a la tabla con nombre, numero de elementos y tipo padre. Devuelve el identificador del nuevo tipo.
    @Override
    public int addType(String name, int items, int parent) {
        Type type = new TypeImpl(name, (short) items, (short) 0, parent, null);
        types.put(typeCounter, type);
        return typeCounter++;
    }

    // Metodo para agregar un nuevo tipo a la tabla con nombre y tabla de símbolos del tipo padre. Devuelve el identificador del nuevo tipo.
    @Override
    public int addType(String name, SymbolTable parent) {
        Type type = new TypeImpl(name, (short) 0, (short) 0, -1, parent);
        types.put(typeCounter, type);
        return typeCounter++;
    }
}
