import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProcessManager {
    
    private Queue<Process> processList;
    private Stack<Process> activeProcessList;
    // private MemoryManager mm;
    private final int time_slice = 4;


    public ProcessManager() {
        this.processList = new LinkedList<Process>();
        this.activeProcessList = new Stack<>();
        // this.mm = new MemoryManager(4);
    }

    public void addProcess(Process p) {
        processList.add(p);
    }

    public void removeProcess() {
        activeProcessList.add(processList.remove());
    }

    public void swapProcess() {
        Process aux = processList.poll();
        processList.add(aux);
    }

    public Process checkNextProcess() {return processList.peek();}


    public void selectPartition(Memory m, MemoryManager mm) {
        Process next = checkNextProcess();
        // Partition p; pode ser mudado.
        //Mudar o getLimit por mm.getPartitions().size()
        for(int i = 0; i <= mm.getLimit() - 1; i++) {
            if(next.getProgram().size() < mm.getPartitions().get(i).getSize() && mm.getPartitions().get(i).isAvailable()) {
                mm.realocate(next.getProgram(), mm.getPartitions().get(i));
                mm.malloc(next, m, mm.getPartitions().get(i));
                // mm.getPartitions().get(i).malloc(next, m);
                processList.remove();
                return;
            }
        }
    }

    public void updateProcessState(int process_id) {
        for(Process p : processList) {
            if(p.getPCB().getID() == process_id)
                p.getPCB().switchState();
        }
    }


}