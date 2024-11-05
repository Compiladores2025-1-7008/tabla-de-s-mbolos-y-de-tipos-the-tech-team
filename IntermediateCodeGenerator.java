import java.util.*;

class IntermediateCodeGenerator {
    private List<String> instructions;

    public IntermediateCodeGenerator() {
        instructions = new ArrayList<>();
    }

    public void genCode(String code) {
        instructions.add(code);
    }

    public void printCode() {
        for (String instr : instructions) {
            System.out.println(instr);
        }
    }
}