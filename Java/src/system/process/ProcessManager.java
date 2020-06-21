package system.process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProcessManager {
    
    private Queue <Process> readyQueue, ioRequestQueue;
    private List <Process> bloquedList;
    private Process currentProcess;

    public ProcessManager() {
        this.readyQueue = new LinkedList<>();
        this.ioRequestQueue = new LinkedList<>();
        this.bloquedList = new ArrayList<>();
        this.currentProcess = null;
    }

    public void newProcess() {
        // cria processo
        // seta pcb (pode não precisar, pois cria indiretamente)
        // coloca processo na fila ready
    }

    public Process getNextProcess() {
        if (readyQueue.isEmpty() && currentProcess == null) { return null; }
        if (readyQueue.isEmpty()) { return currentProcess; }
        if (!readyQueue.isEmpty()) {
            if (currentProcess != null) {
                // remove current process
                currentProcess.getPCB().setProgramState(ProgramState.READY);
                readyQueue.add(currentProcess);
            }
            // get new current process
            currentProcess = readyQueue.remove();
            currentProcess.getPCB().setProgramState(ProgramState.RUNNING);
        }
        return currentProcess;
    }

    public void endProcess(Process process) {
        if (!readyQueue.isEmpty() && readyQueue.contains(process)) {
            readyQueue.remove(process);
        } else if (!ioRequestQueue.isEmpty() && ioRequestQueue.contains(process)) {
            ioRequestQueue.remove(process);
        } else if (!bloquedList.isEmpty() && bloquedList.contains(process)) {
            bloquedList.remove(process);
        }
    }

    

}