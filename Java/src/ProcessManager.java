import java.util.LinkedList;
import java.util.Queue;

public class ProcessManager {

    private Queue <Process> queue;
    private Process currentProcess;
    private static Integer MAX_PC_DIVISOR = 10;

    public ProcessManager() {
        this.queue = new LinkedList<>();
    }

    public Process getNextProcess () {
        return queue.remove();
    }

    

    private void updateCurrentProcess () {
        if (currentProcess.getProcessControlBlock().addStepToProgramCounter() % MAX_PC_DIVISOR == 0) {
            queue.add(currentProcess);
            currentProcess.getProcessControlBlock().setProgramState(ProcessControlBlock.ProgramState.NOT_RUNNING);
            currentProcess = queue.remove();
            currentProcess.getProcessControlBlock().setProgramState(ProcessControlBlock.ProgramState.RUNNING);
        }
    }

    public Boolean isEmpty () {
        return queue.isEmpty() || currentProcess == null;
    }



//    get free/occupied partition
//    compare
//    stop
//    memory method contact

}
