package system.process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import system.in_out.reader.*;

/**
--------------------------------------------------------------------------
GERENTE DE PROCESSOS NO NOSSO SISTEMA OPERACIONAL
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
-------------------------------------------------------------------------
 */

public class ProcessManager {
    
    private Queue <Process> readyQueue, ioRequestQueue;
    private List <Process> bloquedList;
    private Process currentProcess;
    private ArrayList <Process> allProcess;

    public ProcessManager() {
        this.readyQueue = new LinkedList<>();
        this.ioRequestQueue = new LinkedList<>();
        this.bloquedList = new ArrayList<>();
        this.currentProcess = null;
        this.allProcess = new ArrayList<>(4);
    }

    /**
     * Número de todos os Processos criados
     * @return Integer
     */
    public Integer getAllProcessSize(){return allProcess.size();}
    
    
    public void verifyOpcode(){
        for(int i = 0 ; i < allProcess.size() ; i++){
            for(int j = 0 ; j < allProcess.get(i).getFunctions().size(); j++){
                System.out.println("TESTE: " + allProcess.get(i).getFunctions().get(j).getOpcode());
            }
            System.out.println("\n");   
        }
    }

    public void addProcess(Process p,int position) {
        allProcess.add(position,p);
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
    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 PROCESS MANAGER COMPILANDO!");
    } 

}