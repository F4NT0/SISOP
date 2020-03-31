/**********************************************************
* FUNÇÕES DE ASSEMBLY DOS PROGRAMAS CONSTRUIDOS PARA O PC
***********************************************************/


public class SystemFunctions {

    private int pc; // Program Counter
    private int [] register = {0, 0, 0, 0, 0, 0, 0, 0};
    private String [] indexRegister = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7"};

    public SystemFunctions() {
        this.pc = 0;
    }

    // -------------------- Verificação do OPCODE com 2 Registradores--------------------------- 
    public void exec(String opcode, String param1, String param2, int[] memory) {
        switch(opcode) {
          case "JMPIG" : 
            JMPIG(register[findRegisterIndex(param1)], register[findRegisterIndex(param2)]);
            break;
          case "JMPIL" : 
            JMPIL(register[findRegisterIndex(param1)], register[findRegisterIndex(param2)]);
            break;
          case "JMPIE" :
            JMPIE(register[findRegisterIndex(param1)], register[findRegisterIndex(param2)]);
            break;
          case "ADDI" : 
            ADDI(register[findRegisterIndex(param1)], Integer.parseInt(param2));
            break;
          case "SUBI" : 
            SUBI(register[findRegisterIndex(param1)], Integer.parseInt(param2));
            break;
          case "LDI" :
            LDI(register[findRegisterIndex(param1)], Integer.parseInt(param2));
            break;
          case "LDD" : 
            LDD(register[findRegisterIndex(param1)], mprf(param2), memory);
            break;
          case "STD" : 
            STD(mprf(param1), register[findRegisterIndex(param2)], memory);
            break;
          case "ADD" :
            ADD(register[findRegisterIndex(param1)], register[findRegisterIndex(param2)]);
            break;
          case "SUB" : 
            SUB(register[findRegisterIndex(param1)], Integer.parseInt(param2));
            break;
          case "MULT" : 
            MULT(Integer.parseInt(param1), register[findRegisterIndex(param2)]);
            break;
          case "LDX" :
            LDX(register[findRegisterIndex(param1)], mprf(param2), memory);
            break;
          case "STX" :
            STX(mprf(param1), register[findRegisterIndex(param2)], memory);
            break;
          case "STOP":
            break;
          default:
            break;        
        }
    }

    // ------------------ Funções de movimentação do PC ------------------------------
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

    // ------------------------ Função para encontrar o Registrador ---------------------
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

    /**************************************
    *  LISTA DE FUNÇÕES EXERCIDOS PELA VM
    **************************************/


    private void JMP(int k) {
        pc = k;
    }

    private void JMPI(int rs) {
        pc = rs;
    }

    private void JMPIG(int rs, int rc) {
        pc = rs > 0 ? pc = rs : pc++;
    }
    
    private void JMPIL(int rs, int rc) {
        pc = rs < 0 ? pc = rs : pc++;
    }

    private void JMPIE(int rs, int rc) {
        pc = rs == 0 ? pc = rs : pc++;
    }

    private void ADDI(int rd, int k) {
        rd = rd + k;
    }

    private void SUBI(int rd, int k) {
        rd = rd - k;
    }

    private void LDI(int rd, int k) {
        rd = k;
    }

    private void LDD(int rd, int a, int []memory) {
        rd = memory[a];
    }

    private void STD(int a, int rd, int[]memory) {
        memory[a] = rd;
    }

    private void ADD(int rd, int rs) {
        rd = rd + rs;
    }

    private void SUB(int rd, int rs) {
        rd = rd - rs;
    }

    private void MULT(int rd, int rs) {
        rd = rd * rs;
    }

    private void LDX(int rd, int rs, int[] memory) {
        rd = memory[rs];
    }

    private void STX(int rd, int rs, int[] memory) {
        memory[rd] = rs;
    }
}