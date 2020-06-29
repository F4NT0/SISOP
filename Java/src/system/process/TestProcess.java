package system.process;

import java.util.ArrayList;

import system.in_out.reader.*;

public class TestProcess {
    public static void main(String[] args){
        System.out.println("\n🔰 TESTE DAS FUNÇÕES DOS PROCESSOS\n");
        // Pega o programa Lido
        ProgramReader objects = new ProgramReader();
        objects.readAndCreateFunctions("prog.txt");

        // Cria o Processo - a lista de FunctionObjects e o id do PCB
        Process process1 = new Process(objects.getFuncoes(),0);
        ArrayList<FunctionObjects> functions = process1.getFunctions();
        for(int i = 0 ; i < functions.size() ; i++){
            System.out.println("OPCODE: " + functions.get(i).getOpcode());
        }

    }
    
}