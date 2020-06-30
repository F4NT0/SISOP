package system.tests;
import system.process.*;
import system.process.Process;

import system.in_out.reader.*;
import system.process.ContextData;

public class TestProcess {
    public static void main(String[] args){
        System.out.println("\n🔰 TESTE DAS FUNÇÕES DOS PROCESSOS\n");
        // Pega o programa Lido
        ProgramReader objects = new ProgramReader();
        objects.readAndCreateFunctions("prog.txt");

        // Cria o Processo - a lista de FunctionObjects e o id do PCB
        Process process1 = new Process(objects.getFuncoes(),0);

        // Pegando o PCB
        ProcessControlBlock pcb = process1.getPCB();
        System.out.println("PCB ID: " + pcb.getId());
        System.out.println("PCB PC: " + pcb.getProgramCounter());
        System.out.println("PCB ProgramState: " + pcb.getProgramState());

        // Criando um ContextData do Processo
        ContextData registradores = new ContextData(-1,-1,-1,-1,-1,-1,-1,-1);
        // Adicionando o ContextData ao Processo
        process1.setContextData(registradores);

        // Testando se está dentro do PCB
        ContextData saida = process1.getPCB().getContextData();
        System.out.println("R1: " + saida.getR1());
        System.out.println("R2: " + saida.getR2());
        System.out.println("R3: " + saida.getR3());
        System.out.println("R4: " + saida.getR4());
        System.out.println("R5: " + saida.getR5());
        System.out.println("R6: " + saida.getR6());
        System.out.println("R7: " + saida.getR7());
        System.out.println("R8: " + saida.getR8()); 


    }
    
}