package process;

import java.util.List;

import process.ProcessControlBlock.ContextData;

/**
 * Mudar a lista de functions (de object para function quando tiver)
 * Linha 13, 15, 28, 35
*/

public class Process {

    private ProcessControlBlock processControlBlock;
    private List<Object> functions; 

    public Process(List<Object> program, Integer pcbID) {
        this.processControlBlock = new ProcessControlBlock(pcbID);
        this.functions = program;
    }

    public void setContextData(ContextData contextData) {
        this.processControlBlock.setContextData(contextData);
    }
    public void setPCB(ProcessControlBlock processControlBlock) {
        this.processControlBlock = processControlBlock;
    }
    public void setFunctions(List<Object> functions) {
        this.functions = functions;
    }

    public ProcessControlBlock getPCB() {
        return processControlBlock;
    }
    public List<Object> getFunctions() {
        return functions;
    }
    
}