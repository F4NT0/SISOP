import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Process {

    private ProcessControlBlock pcb;
    private List <Funcao> program;
    private Stack<Funcao> syscalls;

    public Process(ArrayList<Funcao> program, int identifier) {
        this.pcb = new ProcessControlBlock(identifier, program.size());
        this.program = new ArrayList<>();
        this.syscalls = new Stack<>();
    }

    public List<Funcao> getProgram() {return this.program;}
    public Stack<Funcao> getSyscalls() {return this.syscalls;}
    public ProcessControlBlock getPCB() {return this.pcb;}

    public void saveContextData(Cpu c) {

    }

    // public void run(MemoryManager me, Memory m) {
    //     Partition p = me.getProcessPartition(pcb.getID(), m);
    //     for(int i = 0; i < program.size(); i ++) {
    //         Class c = Cpu.class;
    //         Method m = c.getMethod("runningFunctions", Object);
    //         // Cpu.class.getMethod("runningFunctions", Funcao);
    //     }
    // }


}