package system.cpu;

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

	// public ObjectRegister getValueDirect(Integer position){
	// 	ObjectRegister value = memory.getValue(position);
	// 	return value;
		
	// }
	
    /**
    ========================================================= 
    Métodos de Leitura e Armazenamento do Programa na Memória
    =========================================================
    */

    public void storeProgram(ArrayList<FunctionObjects> program){
        //memory.setProgram(program.size(),program);
        pc = 0;
    }

    public void loadProgram(String file){
        ProgramReader objects = new ProgramReader();
        objects.readAndCreateFunctions(file);
        storeProgram(objects.getFuncoes());
        setProgramSize(objects.getProgramSize()-1);
    }

    public void runningFunctions(FunctionObjects object) throws Exception {
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
			case "STOP": throw new Exception("Program STOP reached");
		}
		
		// verifica se há alguma interrupcao
		try {
			
		} catch (IllegalArgumentException e) {
			//TODO: handle exception
		}
    }

	//TODO: Mudar isso para funcionar no modelo atual.
    public void runningProgram(Integer size){
        //FunctionObjects object = memory.getProgram(getPc());
        //runningFunctions(object);
        if(size == 0){System.out.println("Finish Program!");}
        //if(object.getOpcode().equals("STOP")){size = 0;}
        else{runningProgram(size-1);}
    }

    public String finalValues(){
        try{
            String r1,r2,r3,r4,r5,r6,r7,r8 = "";
            //if(getReg("R1") != -1){ObjectRegister object = memory.getValue(getReg("R1"));r1 = "R1: " + object.getValue();}
            //if(getReg("R2") != -1){ObjectRegister object = memory.getValue(getReg("R2"));r2 = "R2: " + object.getValue();}
            //if(getReg("R3") != -1){ObjectRegister object = memory.getValue(getReg("R3"));r3 = "R3: " + object.getValue();}
            //if(getReg("R4") != -1){ObjectRegister object = memory.getValue(getReg("R4"));r4 = "R4: " + object.getValue();}
            //if(getReg("R5") != -1){ObjectRegister object = memory.getValue(getReg("R5"));r5 = "R5: " + object.getValue();}
            //if(getReg("R6") != -1){ObjectRegister object = memory.getValue(getReg("R6"));r6 = "R6: " + object.getValue();}
            //if(getReg("R7") != -1){ObjectRegister object = memory.getValue(getReg("R7"));r7 = "R7: " + object.getValue();}
            //if(getReg("R8") != -1){ObjectRegister object = memory.getValue(getReg("R8"));r8 = "R8: " + object.getValue();}
            //String exit = r1 + "\n" + r2 + "\n" + r3 + "\n" + r4 + "\n" + r5 + "\n" + r6 + "\n" + r7 + "\n" + r8 + "\n"; 
            //return exit;
        }catch(NullPointerException e){
            System.err.print("Erro: " + e);
        }
        return "";
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 CONTROL UNIT COMPILANDO!");
    }

	


}

