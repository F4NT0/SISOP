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

    public void runNextFunction () throws NullPointerException {
        if (currentProcess == null) {
            throw new NullPointerException("No new function assigned to run");
        }

        Integer currentStepIndex = currentProcess.getProcessControlBlock().addStepToProgramCounter();
        Funcao funcao = currentProcess.getFunctions().get(currentStepIndex);

        if (funcao.getOpcode().equals("STOP")) {
            finalizeCurrentProcess();
            if (!queue.isEmpty()) {
                currentProcess = queue.remove();
                runNextFunction();
            }
            return;
        }

//        run function

        updateCurrentProcess();
    }

    private void finalizeCurrentProcess () {
        currentProcess.getProcessControlBlock().setProgramState(ProcessControlBlock.ProgramState.ENDED);
        // perform removal from memory
        // screen prints
    }

    private void updateCurrentProcess () {
        if (currentProcess.getProcessControlBlock().getProgramCounter() % MAX_PC_DIVISOR == 0) {
            queue.add(currentProcess);
            currentProcess.getProcessControlBlock().setProgramState(ProcessControlBlock.ProgramState.NOT_RUNNING);
            currentProcess = queue.remove();
            currentProcess.getProcessControlBlock().setProgramState(ProcessControlBlock.ProgramState.RUNNING);
        }
    }

    public Boolean isEmpty () {
        return queue.isEmpty() || currentProcess == null;
    }

    public void addProcessToQueue (Process process) throws NullPointerException {
        if (process == null) {
            throw new NullPointerException("Tried to add null process");
        }
        queue.add(process);
    }



//    get free/occupied partition
//    compare
//    stop
//    memory method contact

}
