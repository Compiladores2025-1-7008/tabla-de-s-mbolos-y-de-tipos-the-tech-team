// Implementación de la Interfaz Type
// Con esta clase se representa un tipo de dato con propiedades 
class TypeImpl implements Type {
    private String name;
    private short items;
    private short tam;
    private int parentId;
    private SymbolTable parentStruct;

    //Constructor para inicializar los atributos del tipo
    public TypeImpl(String name, short items, short tam, int parentId, SymbolTable parentStruct) {
        this.name = name;
        this.items = items;
        this.tam = tam;
        this.parentId = parentId;
        this.parentStruct = parentStruct;
    }

    //Metodo que devuelve el nombre del tipo
    @Override
    public String getName() {
        return name;
    }

    //Metodo para devolver el numero de elementos del tipo
    @Override
    public short getItems() {
        return items;
    }

    //Metodo que devuelve el tamaño del tipo
    @Override
    public short getTam() {
        return tam;
    }

    //Metodo que devuelve el identificador del tipo padre
    @Override
    public int getParenId() {
        return parentId;
    }

    //Metodo que devuelve la tabla de símbolos de la estructura del tipo padre
    @Override
    public SymbolTable getParentStruct() {
        return parentStruct;
    }
}
