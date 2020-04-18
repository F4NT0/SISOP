import java.util.LinkedList;
import java.util.Queue;

public class ProcessManager {
    
    private Queue<Process> processList;
    private MemoryManager mm;

    public ProcessManager() {
        this.processList = new LinkedList<Process>();
        this.mm = new MemoryManager(4);
    }

    public void addProcess(Process p) {
        processList.add(p);
    }

    public void removeProcess() {
        processList.remove();
    }

    public void swapProcess() {
        Process aux = processList.poll();
        processList.add(aux);
    }

    public Process checkNextProcess() {return processList.peek();}

    // public void realocateProgram(Process p) {
    //     mm.realocate(p.getProgram(), p);
    // }

    public void selectPartition(Memory m) {
        Process next = checkNextProcess();
        //Mudar o getLimit por mm.getPartitions().size()
        for(int i = 0; i <= mm.getLimit() - 1; i++) {
            if(next.getProgram().size() >= mm.getPartitions().get(i).getProgramSize() && mm.getPartitions().get(i).isAvailible()) {
                mm.realocate(next.getProgram(), mm.getPartitions().get(i));
                mm.getPartitions().get(i).malloc(next, m);
                return;
            }
        }
    }
}