package system.cpu;

import java.util.concurrent.Semaphore;
import system.process.Process;

/**
 * Change atribute control unit type from Object to ControlUnit
 * Change on class initiation (new Object) to (new ControllUnit)
*/

public class Cpu implements Runnable {

	private Semaphore semaphoreCPU, semaphoreTimer;
	private Object controlUnit; 
	private Process process;

	public Cpu(Semaphore cpu, Semaphore timer) {
		this.semaphoreCPU = cpu;
		this.semaphoreTimer = timer;
		this.controlUnit = new Object();
		this.process = null;
	}

	@Override
	public void run() {
		while (true) {
			try {
				semaphoreCPU.acquire();
				semaphoreTimer.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			while (true) {
				// busca instrução
				executeNextInstruction();
				// if (houve interrupção por SW ou HW) {
					// ajusta PC pra retorno
					// salva estado da CPU no PCB do processo
					// executa rotina de tratamento
					// break e volta a esperar no semáforo
				// }
			}
		}
	}

	private void executeNextInstruction() {
		try {
			// executa próxima instrução
		} catch (Exception e) {
			e.printStackTrace();
		}
		// garantir que try catch verifica divisão por zero,
		// flag de memória fora do devido, STOP e TRAP
		// usar os métoddos criados a baixo
	}

	private void divZeroFlag() {
		// TODO: write this function
	}
	private void outOfBoundsMemoryFlag() {
		// TODO: write this function
	}
	private void stopFlag() {
		// TODO: write this function
	}
	private void trapFlag() {
		// TODO: write this function
	}
   
}
