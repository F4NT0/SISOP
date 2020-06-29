package system.cpu;
import system.memory.*;

public class TestControlUnit {
    public static void main(String[] args){
        Memory memory = new Memory();
        ControlUnit cu = new ControlUnit(memory);

        System.out.println("\n🔰 TESTE DAS FUNÇÕES DA UNIDADE DE CONTROLE\n");

        // Verificando se o programa é adicionado na memória
        cu.loadProgram("prog.txt");
        memory.getMemory();

        // Lendo o OPCODE de cada Função da Memória
        // for(int i = 0 ; i < cu.getProgramSize()+1 ; i++){
        //     System.out.println("OPCODE " + i + " : " + memory.getProgram(i).getOpcode());
        // }

        System.out.println("PROGRAMA DEPOIS: ");
        cu.runningProgram(cu.getProgramSize());
        memory.getMemory();

        System.out.println("TESTE DE INFORMAÇÃO DOS REGISTRADORES");
        System.out.println("R1: " + memory.getValue(cu.getRegisterLocation("R1")).getValue());
        System.out.println("R2: " + memory.getValue(cu.getRegisterLocation("R2")).getValue());
        System.out.println("R3: " + memory.getValue(cu.getRegisterLocation("R3")).getValue());
        System.out.println("R4: " + memory.getValue(cu.getRegisterLocation("R4")).getValue());
        System.out.println("R5: " + memory.getValue(cu.getRegisterLocation("R5")).getValue());

        


    }
}