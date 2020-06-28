package system.cpu;
import system.memory.*;

public class TestAssembly {
    public static void main(String[] args){
       // Inicializando
        Memory memory = new Memory();
        ControlUnit cu = new ControlUnit();
        Assembly functions = new Assembly(memory,cu);
      
       // Testando Funcoes
       System.out.println("Memória antes: ");
        memory.getMemory();
        functions.LDI("R1", 11);
        functions.LDI("R2", -1);
        functions.JMPIL("R2", "R1");
        functions.STD(3, "R1");
        functions.LDD("R3", 3);
        functions.SUBI("R3",1);
        functions.MULT("R1", "R3");
        functions.LDI("R4",5);
        // functions.JMPIG("R4","R3");
        // functions.STD(52,"R1");

        // Testando as funcoes
        System.out.println("Memória Depois: ");
        memory.getMemory();



        
    }
}