package system.tests;

import system.process.*;
import system.process.Process;

import java.util.ArrayList;

import system.in_out.reader.*;

public class TestProcessManager {
    public static void main(String[] args){
        System.out.println("\n🔰 TESTE DOS GERENTES DE PROCESSOS\n");
        
        ProcessManager pm = new ProcessManager();
        
        // Criando Processo de todos os Programas
        
        // Pega o programa Lido
        ProgramReader program1 = new ProgramReader();
        ProgramReader program2 = new ProgramReader();
        
        // Programa 1
        program1.readAndCreateFunctions("prog.txt");
        ArrayList<FunctionObjects> p1 = program1.getFuncoes();
        pm.newProcess(p1,0);
        //pm.addProcess(pro1);

        // Programa 2
        program2.readAndCreateFunctions("prog2.txt");
        ArrayList<FunctionObjects> p2 = program2.getFuncoes();
        pm.newProcess(p2,1);
        //pm.addProcess(pro2);
 
    
        //Verificando
        System.out.println("Numero de Processos: " + pm.getAllProcessSize());
        pm.verifyOpcode();

         
 

        

    }

    

}