package system.cpu;

import system.memory.*;
import java.util.ArrayList;
//import java.util.List;

import system.in_out.reader.*;

public class ControlUnit{
	private Integer R1,R2,R3,R4,R5,R6,R7,R8;
	private Integer pc;
	private Memory memory = new Memory(); //Mudar para ser usado a mesma memoria por todo o programa
	private Integer programSize;
	public ControlUnit(){
		R1 = R2 = R3 = R4 = R5 = R6 = R7 = R8 = -1;
		pc = 0;
		programSize = 0;
	}

	/**
	==========================================
	Métodos de Interação com os Registradores
	==========================================
	*/

	public Integer getReg(String reg){
		switch(reg){
			case "R1": return R1;case "R2": return R2;
			case "R3": return R3;case "R4": return R4;
			case "R5": return R5;case "R6": return R6;
			case "R7": return R7;case "R8": return R8;
		}
		return -1;
	}
	public Integer getProgramSize(){return programSize;}
	public Integer getPc(){return pc;}
	public Memory getMemory(){return memory;}
	public void setRegisterPosition(String register,Integer position){
		switch(register){
			case "R1":this.R1 = position;case "R2":this.R2 = position;
			case "R3":this.R3 = position;case "R4":this.R4 = position;
			case "R5":this.R5 = position;case "R6":this.R6 = position;
			case "R7":this.R7 = position;case "R8":this.R8 = position;
		}
	}
	public void setPc(Integer pc){this.pc = pc;}
	public void setProgramSize(Integer ps){programSize = ps;}

	public Integer getRegisterLocation(String register){
		Integer location = -1;
		switch(register){
			case "R1": location = getReg("R1");case "R2": location = getReg("R2");
			case "R3": location = getReg("R3");case "R4": location = getReg("R4");
			case "R5": location = getReg("R5");case "R6": location = getReg("R6");
			case "R7": location = getReg("R7");case "R8": location = getReg("R8");
		}
		return location;
	}

	

	/** 
	================================
	Métodos de Interação com Memória
	================================
	*/

	public void setRegValue(Object value,String register){
		ObjectRegister object = new ObjectRegister();
		object.setRegister(register);
		object.setValue(value);
		memory.addRegister(object);
		Integer position = memory.findRegister(object);
		setRegisterPosition(register, position);
	}

	public void setValueOnMemory(Object value,Integer position){
		memory.addValueOnPosition(value,position);
	}

	public void setRegValuePosition(ObjectRegister object,Integer position){
		Integer positionFind = memory.findRegister(object);
		if(positionFind == -1){
			memory.addRegister(object);
		}
		memory.setRegisterOnPosition(position,object);
		memory.remove(positionFind);
	}

	public ObjectRegister getValue(String register){
		ObjectRegister value = null;
		switch(register){
			case "R1": value = memory.getValue(R1);case "R2": value = memory.getValue(R2);
			case "R3": value = memory.getValue(R3);case "R4": value = memory.getValue(R4);
			case "R5": value = memory.getValue(R5);case "R6": value = memory.getValue(R6);
			case "R7": value = memory.getValue(R7);case "R8": value = memory.getValue(R8);
		}
	 return value;
	}

	public ObjectRegister getValueDirect(Integer position){
		ObjectRegister value = memory.getValue(position);
		return value;
		
	}

	//
	public Object getIntegerDirect(Integer position){
		Object value = memory.getObjectOnPosition(position);
		return value;
		
	}

	public void updateRegister(Integer location,ObjectRegister newRegister){
		memory.updateRegister(location,newRegister);
    }
    
	

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

	//Mudar isso para funcionar no modelo atual.
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

