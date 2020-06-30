package system.cpu;
import system.process.Process;

/**
--------------------------------------------------------------------------
UNIDADE DE CONTROLE QUE RODA AS FUNÇÕES E CRIA PROCESSOS
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
-------------------------------------------------------------------------
 */

import system.memory.*;
import java.util.ArrayList;
//import java.util.List;

import system.in_out.reader.*;

public class ControlUnit{
	private Integer R1,R2,R3,R4,R5,R6,R7,R8;
	private Integer pc;
	private Memory memory;
	private Integer programSize;
	public ControlUnit(Memory mem){
		R1 = R2 = R3 = R4 = R5 = R6 = R7 = R8 = -1;
		pc = 0;
		programSize = 0;
		memory = mem;
	}

	/**
	==========================================
	Métodos de Interação com os Registradores
	==========================================
	*/

	public Integer getProgramSize(){return programSize;}
	public Integer getPc(){return pc;}

	/**
	 * Salva a posição de memória do Registrador
	 * @param register
	 * @param position
	 */
	public void setRegisterPosition(String register,Integer position){
		switch(register){
			case "R1":this.R1 = position;break;
			case "R2":this.R2 = position;break;
			case "R3":this.R3 = position;break;
			case "R4":this.R4 = position;break;
			case "R5":this.R5 = position;break;
			case "R6":this.R6 = position;break;
			case "R7":this.R7 = position;break;
			case "R8":this.R8 = position;break;
		}
	}

	public void setPc(Integer pc){this.pc = pc;}
	public void setProgramSize(Integer ps){programSize = ps;}

	/**
	 * Retorna a posição do Registrador salvo na
	 * Unidade de Controle da CPU
	 * @param register
	 * @return Integer
	 */
	public Integer getRegisterLocation(String register){
		Integer location = -1;
		switch(register){
			case "R1": location = R1;break;
			case "R2": location = R2;break;
			case "R3": location = R3;break;
			case "R4": location = R4;break;
			case "R5": location = R5;break;
			case "R6": location = R6;break;
			case "R7": location = R7;break;
			case "R8": location = R8;break;
		}
		return location;
	}


	/** 
	================================
	Métodos de Interação com Memória
	================================
	*/

	// public void setRegValuePosition(ObjectRegister object,Integer position){
	// 	Integer positionFind = memory.findRegister(object);
	// 	if(positionFind == -1){
	// 		memory.addRegister(object);
	// 	}
	// 	memory.setRegisterOnPosition(position,object);
	// 	memory.remove(positionFind);
	// }

	
	
    /**
    ========================================================= 
    Métodos de Leitura e Armazenamento do Programa na Memória
    =========================================================
    */

	
	// /**
	//  * Adiciona o programa dentro da Memória
	//  * @param program
	//  */
    // private  void storeProgram(ArrayList<FunctionObjects> program){
    //     memory.setProgram(program.size(),program);
    //     pc = 0;
    // }

	/**
	 * Carrega o Programa para um Processo
	 * @param file
	 */
    public void loadProgram(String file, int newPcb, MemoryManager memoryManager){
        ProgramReader objects = new ProgramReader();
		objects.readAndCreateFunctions(file);
		Process process = new Process(objects.getFuncoes(),newPcb);
		memoryManager.selectPartition(process);
		setProgramSize(objects.getProgramSize()-1);
		pc = 0;
    }

	/**
	 * Compila cada linha do programa com sua Função
	 * @param object
	 */
    private void runningFunctions(FunctionObjects object){
        try {
			Assembly assembly = new Assembly(memory, this);
        	String opcode = object.getOpcode();
        	String rs = object.getRs();
        	String rd = object.getRd();
        	String rc = object.getRc();
        	Integer k = object.getK();
        	Integer a = object.getA();
        	switch(opcode) {
            case "JMP":assembly.JMP(k);break;case "JMPI":assembly.JMPI(rs);break;
            case "JMPIG":assembly.JMPIG(rs, rc);break;case "JMPIL":assembly.JMPIL(rs, rc);break;
            case "JMPIE":assembly.JMPIE(rs, rc);break;case "ADDI":assembly.ADDI(rd, k);break;
            case "SUBI":assembly.SUBI(rd, k);break;case "LDI":assembly.LDI(rd, k);break;
            case "LDD":assembly.LDD(rd, a);break;case "STD":assembly.STD(a, rs);break;
            case "ADD":assembly.ADD(rd, rs);break;case "SUB":assembly.SUB(rd, rs);break;
            case "MULT":assembly.MULT(rd, rs);break;case "LDX":assembly.LDX(rd, rs);break;
			case "STX":assembly.STX(rd, rs);break;
			case "STOP": new Exception("Program STOP reached");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e);
		}
    }

	//TODO: Mudar isso para funcionar no modelo atual.
    public void runningProgram(Integer size){
        FunctionObjects object = memory.getProgram(getPc());
        runningFunctions(object);
        if(size == 0){System.out.println("Finish Program!");}
        if(object.getOpcode().equals("STOP")){size = 0;}
        else{runningProgram(size-1);}
    }

	/**
	 * Apresenta os Valores finais dos Registradores
	 * @return
	 */
    public String finalValues(){
		String[] options = {"R1","R2","R3","R4","R5","R6","R7","R8"};
		String exit = "";
		for(int i = 0 ; i < options.length ; i++){
			if(getRegisterLocation(options[i]) != -1){
				exit = exit + options[i] + " " + memory.getValue(getRegisterLocation(options[i])).getValue() + "\n";  
			}
		}
        return exit;
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 CONTROL UNIT COMPILANDO!");
    }

	


}

