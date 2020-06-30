package system.process;

import java.util.ArrayList;
import system.in_out.reader.FunctionObjects;

/**
CRIADOR DE PROCESSOS NO SISTEMA OPERACIONAL
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
*/

public class Process {
    private ProcessControlBlock processControlBlock;
    private ArrayList<FunctionObjects> functions; 

    // Construtores
    public Process(ArrayList<FunctionObjects> program, Integer pcbID) {
        this.processControlBlock = new ProcessControlBlock(pcbID);
        this.functions = program;
    }

    /**
     * Adiciona as Posições dos Registradores do 
     * Control Unit dentro do Process Control Block
     * @param contextData
     */
    public void setContextData(ContextData contextData) {
        this.processControlBlock.setContextData(contextData);
    }
    
    /**
     * Define qual ProcessControlBlock no Processo
     * @param processControlBlock
     */
    public void setPCB(ProcessControlBlock processControlBlock) {
        this.processControlBlock = processControlBlock;
    }
    
    /**
     * Define a Lista de Funções que tem que fazer
     * @param functions
     */
    public void setFunctions(ArrayList<FunctionObjects> functions) {this.functions = functions;}

    /**
     * Retorna o ProcessControlBlock
     * @return processControlBlock
     */
    public ProcessControlBlock getPCB() {return processControlBlock;}
    
    /**
     * Pega a Lista de Funções do Processo
     * @return
     */
    public ArrayList<FunctionObjects> getFunctions() {return functions;}
    public static void main(String[] args){
		System.out.println("🆗 PROCESS COMPILANDO!");
    } 
    
}