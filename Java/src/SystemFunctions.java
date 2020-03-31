/**********************************************************
* FUNÇÕES DE ASSEMBLY DOS PROGRAMAS CONSTRUIDOS PARA O PC
***********************************************************/


public class SystemFunctions {

    private int pc;
    private int [] register = {0, 0, 0, 0, 0, 0, 0, 0};
    private String [] indexRegister = {"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8"};

    public SystemFunctions() {
        this.pc = 0;
    }

    public int getPC() {
        return this.pc;
    }

    public void getRegisterValues() {
        for(int i : register) {
            int j = 0;
            System.out.println(j +": " + i);
        }
    }

    public void exec(String opcode, String param1, String param2, int[] memory) {
        switch(opcode) {
          case "JMPIG" : 
            JMPIG(findRegisterIndex(param1), findRegisterIndex(param2));
            break;
          case "JMPIL" : 
            JMPIL(findRegisterIndex(param1), findRegisterIndex(param2));
            break;
          case "JMPIE" :
            JMPIE(findRegisterIndex(param1), findRegisterIndex(param2));
            break;
          case "ADDI" : 
            ADDI(findRegisterIndex(param1), Integer.parseInt(param2));
            break;
          case "SUBI" : 
            SUBI(findRegisterIndex(param1), Integer.parseInt(param2));
            break;
          case "LDI" :
            LDI(findRegisterIndex(param1), Integer.parseInt(param2));
            break;
          case "LDD" : 
            LDD(findRegisterIndex(param1), mprf(param2), memory);
            break;
          case "STD" : 
            STD(mprf(param1), findRegisterIndex(param2), memory);
            break;
          case "ADD" :
            ADD(findRegisterIndex(param1), findRegisterIndex(param2));
            break;
          case "SUB" : 
            SUB(findRegisterIndex(param1), Integer.parseInt(param2));
            break;
          case "MULT" : 
            MULT(findRegisterIndex(param1), findRegisterIndex(param2));
            break;
          case "LDX" :
            LDX(findRegisterIndex(param1), mprf(param2), memory);
            break;
          case "STX" :
            STX(mprf(param1), findRegisterIndex(param2), memory);
            break;  
          default :
            break;        
        }
    }

    public void exec(String opcode, String param) {
        switch (opcode) {
            case "JMP" :
                JMP(Integer.parseInt(param));
                break;
            case "JMPI" :
                JMPI(register[findRegisterIndex(param)]);
            default:
                break;
        }
    }

    private int findRegisterIndex(String register) {
        int index = 9;
        for(int i = 0; i <= indexRegister.length - 1; i++) {
            if(register.equals(indexRegister[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    //Nome de metodo temporario
    private int mprf(String param) {
        String [] value = param.split("\\[|\\]");
        int i;
        try {
            i = Integer.parseInt(value[1]);
            return i;
        } catch (Exception e) {
            i = findRegisterIndex(value[1]);
            return i;
        }
    }

    private void JMP(int k) {
        pc = k;
        // return pc;
    }

    private void JMPI(int rs) {
        pc = register[rs];
        // return pc;
    }

    private void JMPIG(int rs, int rc) {
        // pc = rs > 0 ? pc = rs : pc++;
        if(register[rc] > 0) {
            pc = register[rs];
            // return pc;
            return;
        }
        // return pc++;
        pc++;
    }
    
    private void JMPIL(int rs, int rc) {
        // pc = rs < 0 ? pc = rs : pc++;
        if(register[rc] < 0) {
            pc = register[rs];
            // return pc;
            return;
        }
        // return pc++;
        pc++;
    }

    private void JMPIE(int rs, int rc) {
        // pc = rs == 0 ? pc = rs : pc++;
        if(register[rc] == 0) {
            pc = register[rs];
            // return pc;
            return;
        }
        // return pc++;
        pc++;
    }

    private void ADDI(int rd, int k) {
        register[rd] = register[rd] + k;
        pc++;
    }

    private void SUBI(int rd, int k) {
        register[rd] = register[rd] - k;
        pc++;
    }

    private void LDI(int rd, int k) {
        register[rd] = k;
        pc++;
    }

    private void LDD(int rd, int a, int[] memory) {
        register[rd] = memory[register[a]];
        pc++;
    }

    private void STD(int a, int rd, int[] memory) {
        memory[register[a]] = register[rd];
        pc++;
    }

    private void ADD(int rd, int rs) {
        register[rd] = register[rd] + register[rs];
        pc++;
    }

    private void SUB(int rd, int rs) {
        register[rd] = register[rd] - register[rs];
        pc++;
    }

    private void MULT(int rd, int rs) {
        register[rd] = register[rd] * register[rs];
        pc++;
    }

    private void LDX(int rd, int rs, int[] memory) {
        register[rd]= memory[register[rs]];
        pc++;
    }

    private void STX(int rd, int rs, int[] memory) {
        memory[register[rd]] = register[rs];
        pc++;
    }
}