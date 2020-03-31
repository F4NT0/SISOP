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

    public int getPC() {
        return this.pc;
    }

    public void getRegisterValues() {
        for(int i : register) {
            int j = 0;
            System.out.println(j +": " + i);
        }
    }

    public void execDirectValues(String opcode, String param1, int param2, int[] memory){
        switch(opcode){
            case "ADDI" : 
            ADDI(findRegisterIndex(param1), param2);
            break;
            case "SUBI" : 
            SUBI(findRegisterIndex(param1), param2);
            break;
            case "LDI" :
            LDI(findRegisterIndex(param1), param2);
            break;
        }
    }

    public void execVectorOperations(String opcode, String rd , int a, int[] memory){
        switch(opcode){
            case "LDD" : 
                LDD(findRegisterIndex(rd), a, memory);
                break;
            case "STD" : 
                STD(a, findRegisterIndex(rd), memory);
                break;
        }
    }

    public void execRegisterOperations(String opcode, String rd , String rs, int[] memory){
        switch(opcode){
            case "ADD" :
                ADD(findRegisterIndex(rd), findRegisterIndex(rs));
                break;
            case "SUB" : 
                SUB(findRegisterIndex(rd), Integer.parseInt(rs));
                break;
            case "MULT" : 
                MULT(findRegisterIndex(rd), findRegisterIndex(rs));
                break;
        }
    }

    public void execJumpOperations(String opcode, String rs, String rc, int[] memory) {
        switch(opcode) {
          case "JMPIG" : 
            JMPIG(findRegisterIndex(rs), findRegisterIndex(rc));
            break;
          case "JMPIL" : 
            JMPIL(findRegisterIndex(rs), findRegisterIndex(rc));
            break;
          case "JMPIE" :
            JMPIE(findRegisterIndex(rs), findRegisterIndex(rc));
            break;
          default :
            break;        
        }
    }

    public void execRegisterVectorOperations(String opcode, String rd, String rs, int[] memory ){
        switch(opcode){
            case "LDX" :
                LDX(findRegisterIndex(rd), rs, memory);
            break;
            case "STX" :
                STX(rd, findRegisterIndex(rs), memory);
            break;  
        }
    }

    // ------------------ Funções de movimentação do PC ------------------------------
    public void execJMPI(String opcode, String param) {
        JMPI(register[findRegisterIndex(param)]);   
    }

    public void execJMP(String opcode, int param){
        JMP(param);
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

   
    /**************************************
    *  LISTA DE FUNÇÕES EXERCIDOS PELA VM
    **************************************/


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

    // Precisa fazer com que ele encontre na memória
    private void LDX(String rd, String rs, int[] memory) {
        register[rd]= memory[register[rs]];
        pc++;
    }

    // Precisa fazer com que ele encontre na memória
    private void STX(String rd, String rs, int[] memory) {
        memory[register[rd]] = register[rs];
        pc++;
    }
}