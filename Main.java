import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test para correr con pruebas más robustas
        SymbolTableStack symbolTableStack = new SymbolTableStackImpl();
        SymbolTable globalTable = new SymbolTable();
        symbolTableStack.push(globalTable);

        IntermediateCodeGenerator codeGenerator = new IntermediateCodeGenerator();

         // Se agregan los símbolos a la tabla global
        Symbol symbolX = new SymbolImpl(100, 1, "variable", new ArrayList<>());
        globalTable.addSymbol("x", symbolX);
        Symbol symbolY = new SymbolImpl(200, 1, "variable", new ArrayList<>(Arrays.asList(1, 2)));
        globalTable.addSymbol("y", symbolY);

        // Se agrega un nuevo ambito y un simbolo
        SymbolTable localTable = new SymbolTable();
        symbolTableStack.push(localTable);
        Symbol symbolZ = new SymbolImpl(300, 2, "variable", new ArrayList<>(Arrays.asList(3, 4)));
        localTable.addSymbol("z", symbolZ);

        // Pruebas de busqueda
        Optional<SymbolTable> foundTableX = symbolTableStack.lookup("x");
        System.out.println(foundTableX.isPresent() ? "Symbol 'x' found in the table." : "Symbol 'x' not found.");

        Optional<SymbolTable> foundTableY = symbolTableStack.lookup("y");
        System.out.println(foundTableY.isPresent() ? "Symbol 'y' found in the table." : "Symbol 'y' not found.");

        Optional<SymbolTable> foundTableZ = symbolTableStack.lookup("z");
        System.out.println(foundTableZ.isPresent() ? "Symbol 'z' found in the table." : "Symbol 'z' not found.");

        // Se elimina el ambito local y verificamos la disponibilidad del símbolo nuevamente
        symbolTableStack.pop();
        foundTableZ = symbolTableStack.lookup("z");
        System.out.println(foundTableZ.isPresent() ? "Symbol 'z' found in the table." : "Symbol 'z' not found.");

        // Test de la implementación de la tabla de tipos
        TypeTableImpl typeTable = new TypeTableImpl();
        int typeId1 = typeTable.addType("int", 1, -1);
        int typeId2 = typeTable.addType("struct", localTable);

        System.out.println("Type ID 1: " + typeTable.getName(typeId1));
        System.out.println("Type ID 2: " + typeTable.getName(typeId2));

        // Agregamos más tipos y probamos las relaciones de padres
        int typeId3 = typeTable.addType("array", 10, typeId1);
        System.out.println("Type ID 3: " + typeTable.getName(typeId3) + ", Parent ID: " + typeTable.getParenId(typeId3));

        // Se realiza la generación del código intermedio
        codeGenerator.genCode("x = 5;");
        codeGenerator.genCode("y = x + 10;");
        codeGenerator.genCode("if (y > 10) goto L1;");
        codeGenerator.genCode("L1: z = y;");
        codeGenerator.printCode();
    }
}
