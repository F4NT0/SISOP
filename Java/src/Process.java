import java.util.List;
import java.util.ArrayList;

public class Process {

    private ProcessControlBlock processControlBlock;
    private List<Funcao> functions; // program
//    need to pull necessary program data

    public Process (ArrayList<Funcao> program, Integer pcbLocationID) {
        this.functions = program;
        this.processControlBlock = new ProcessControlBlock(pcbLocationID);
    }

    void setPCBContextData(ProcessControlBlock.ContextData contextData) {
        this.processControlBlock.setContextData(contextData);
    }

    public ProcessControlBlock getProcessControlBlock() {
        return processControlBlock;
    }

    public void setProcessControlBlock(ProcessControlBlock processControlBlock) {
        this.processControlBlock = processControlBlock;
    }

    public List<Funcao> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Funcao> functions) {
        this.functions = functions;
    }

}
