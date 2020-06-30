package system.tests;

import system.process.*;
import system.process.Process;

import system.in_out.reader.*;

public class TestProcessManager {
    public static void main(String[] args){
        System.out.println("\n🔰 TESTE DOS GERENTES DE PROCESSOS\n");
        
        ProcessManager pm = new ProcessManager();
        
        // Criando Processo de todos os Programas
        
        // Pega o programa Lido
        ProgramReader program1 = new ProgramReader();
        //ProgramReader program2 = new ProgramReader();
        
        // Programa 1
        program1.readAndCreateFunctions("prog.txt");
        Process process1 = new Process(program1.getFuncoes(),0);
        pm.addProcess(process1);
        //process1.printOpcodes();

        // Programa 2
        program1.readAndCreateFunctions("prog2.txt");
        Process process2 = new Process(program1.getFuncoes(),1);
        pm.addProcess(process2);
        //process2.printOpcodes();
        
        //Verificando
        System.out.println("Numero de Processos: " + pm.getAllProcessSize());
        pm.verifyOpcode();

         
 

        

    }

    

}