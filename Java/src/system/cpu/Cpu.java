package system.cpu;

/**
--------------------------------------------------------------------------
CPU CONCORRENTE DO NOSSO SISTEMA OPERACIONAL
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
-------------------------------------------------------------------------
 */

import java.util.concurrent.Semaphore;
import system.process.Process;

public class Cpu implements Runnable {

	private Semaphore semaphoreCPU, semaphoreTimer;
	private ControlUnit controlUnit; 
	private Process process;
	private Boolean flagDivZero, flagTrap, flagSTOP, flagMemoryOutOfBounds;

	public Cpu(Semaphore cpu, Semaphore timer) {
		this.semaphoreCPU = cpu;
		this.semaphoreTimer = timer;
		this.controlUnit = new ControlUnit();
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
		} catch (Exception exception) {
			if (exception.getMessage().contains("Program STOP reached")) {
				// parar programa
				this.flagSTOP = true;
				stopFlag();
			} else if (exception.getMessage().contains("Essa partição não existe.")) {
				this.flagMemoryOutOfBounds = true;
				outOfBoundsMemoryHandler();
				//TODO: colocar mensagem da exception de div por zero
			} else if (exception.getMessage().contains("")) {
				this.flagDivZero = true;
				divZeroHandler();
				//TODO: colocar mensagem da exception de TRAP
			} else if (exception.getMessage().contains("")){
				this.flagTrap = true;
				trapHandler();
			}
			exception.printStackTrace();
		}
		// garantir que try catch verifica divisão por zero,
		// flag de memória fora do devido, STOP e TRAP
		// usar os métoddos criados a baixo
	}

	

	private void divZeroHandler() {
		this.flagDivZero = true;
		// TODO: write this function
	}
	private void outOfBoundsMemoryHandler() {
		// TODO: write this function
		this.flagMemoryOutOfBounds = true;
	}
	private void stopFlag() {
		this.flagSTOP = true;
		// TODO: 
		// printar na shell o resultado
		// tirar da memoria o processo
		// tirar do gerente de memoria
	}
	private void trapHandler() {
		this.flagTrap = true;
		// TODO: write this function
	}

	public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 CPU COMPILANDO!");
    }
}

