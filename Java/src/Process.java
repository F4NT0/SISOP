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


}