package system.process;

import java.util.concurrent.Semaphore;

/**
SISTEMA DE ESCALONAMENTO DOS PROCESSOS
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
*/


/**
 * Run method
 * Restaurar estado da cpu quando CPU tiver sido montada
 * 
*/

public class Scheduler extends Thread {

    ProcessManager processManager;
    Semaphore semaphoreScheduler, semaphoreCPU, semaphoreTimer;

    public Scheduler(ProcessManager processManager, Semaphore scheduler,
     Semaphore cpu, Semaphore timer) {
        this.processManager = processManager;
        this.semaphoreScheduler = scheduler;
        this.semaphoreCPU = cpu;
        this.semaphoreTimer = timer;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                semaphoreScheduler.acquire(); // semaphoreScheduler.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Process process = processManager.getNextProcess();

            // restaurar estado da cpu para esse processo
            
            try {
                semaphoreCPU.release(); // semaphoreCPU.signal()
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 SCHEDULER COMPILANDO!");
    } 
}