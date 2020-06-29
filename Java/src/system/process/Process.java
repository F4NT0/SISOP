package system.process;

import java.util.ArrayList;

import system.in_out.reader.FunctionObjects;
import system.process.ProcessControlBlock.ContextData;

public class Process {
    private ProcessControlBlock processControlBlock;
    private ArrayList<FunctionObjects> functions; 

    // Construtores
    public Process(ArrayList<FunctionObjects> program, Integer pcbID) {
        this.processControlBlock = new ProcessControlBlock(pcbID);
        this.functions = program;
    }
    
    public Process(){}

    public void setContextData(ContextData contextData) {
        this.processControlBlock.setContextData(contextData);
    }
    
    public void setPCB(ProcessControlBlock processControlBlock) {
        this.processControlBlock = processControlBlock;
    }
    
    public void setFunctions(ArrayList<FunctionObjects> functions) {this.functions = functions;}

    public ProcessControlBlock getPCB() {return processControlBlock;}
    
    public ArrayList<FunctionObjects> getFunctions() {return functions;}
    public static void main(String[] args){
		System.out.println("🆗 PROCESS COMPILANDO!");
    } 
    
}