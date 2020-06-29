package system.cpu;
import system.memory.*;

public class TestControlUnit {
    public static void main(String[] args){
        Memory memory = new Memory();
        ControlUnit cu = new ControlUnit(memory);

        System.out.println("\n🔰 TESTE DAS FUNÇÕES DA UNIDADE DE CONTROLE\n");

        // Verificando se o programa é adicionado na memória
        cu.loadProgram("prog.txt");
        //memory.getMemory();

        // Lendo o OPCODE de cada Função da Memória
        // for(int i = 0 ; i < cu.getProgramSize()+1 ; i++){
        //     System.out.println("OPCODE " + i + " : " + memory.getProgram(i).getOpcode());
        // }

        cu.runningProgram(cu.getProgramSize());
        memory.getMemory();
        System.out.println(cu.finalValues());


    }
}