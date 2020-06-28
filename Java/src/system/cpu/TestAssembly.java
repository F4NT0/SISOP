package system.cpu;
import system.memory.*;

public class TestAssembly {
    public static void main(String[] args){
       // Inicializando
        Memory memory = new Memory();
        ControlUnit cu = new ControlUnit();
        Assembly functions = new Assembly(memory,cu);
      
        // Para testar a saida de um valor de reg:
        // memory.getValue(cu.getRegisterLocation("R4")).getValue()

       // Testando Funcoes
       System.out.println("Memória antes: ");
        memory.getMemory();
        // functions.LDI("R1", 11);
        // functions.LDI("R2", -1);
        // functions.JMPIL("R2", "R1");
        // functions.STD(3, "R1");
        // functions.LDD("R3", 3);
        // functions.SUBI("R3",1);
        // functions.MULT("R1", "R3");
        // functions.LDI("R4",5);
        // functions.JMPIG("R4","R3");
        // functions.STD(5,"R1");

        functions.LDI("R1", 3);
        functions.LDI("R3", 10);
        functions.LDI("R2", 1);
        functions.LDI("R7", 4);
        functions.STX("R1", "R2");


        // Testando as funcoes
        System.out.println("Memória Depois: ");
        memory.getMemory();



        
    }
}