import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Process {

    private ProcessControlBlock processControlBlock;
    private List<Funcao> functions; // program
//    need to pull necessary program data
//    should it be a hashmap, with variable name and its value?
//    private Map<String, Object> data;

    public Process (ArrayList<Funcao> program, Integer pcbLocationID) {
        this.functions = program;
        this.processControlBlock = new ProcessControlBlock(pcbLocationID);
//        data = new HashMap<>();
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
