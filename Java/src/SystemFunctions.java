/**********************************************************
* FUNÇÕES DE ASSEMBLY DOS PROGRAMAS CONSTRUIDOS PARA O PC
***********************************************************/


public class SystemFunctions {

    //---------------- Variáveis Globais --------------------------------------------
    private int pc; // Program Counter
    private int [] register = {0, 0, 0, 0, 0, 0, 0, 0};
    private String [] indexRegister = {"r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7"};
    private Cpu cpu = new Cpu();

    //----------------- Inicialização do PC no zero ----------------------------------
    public SystemFunctions() {
        this.pc = 0;
    }

    //--------------------------- Getters ---------------------------------------------
    public int getPC() {
        return this.pc;
    }

    public void getRegisterValues() {
        for(int i : register) {
            int j = 0;
            System.out.println(j +": " + i);
        }
    }

    //------------------------- Execução das Funções dependendo do tipo ------------------ 
    public void execDirectValues(String opcode, String rd, int k){
        switch(opcode){
            case "ADDI" : 
            ADDI(rd, k);
            break;
            case "SUBI" : 
            SUBI(rd, k);
            break;
            case "LDI" :
            LDI(rd, k);
            break;
        }
    }

    public void execVectorOperations(String opcode, String rd , int a, Memory memory){
        switch(opcode){
            case "LDD" : 
                LDD(rd, a, memory);
                break;
            case "STD" : 
                STD(a, rd, memory);
                break;
        }
    }

    public void execRegisterOperations(String opcode, String rd , String rs, Memory memory){
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

    public void execJumpOperations(String opcode, String rs, String rc, Memory memory) {
        switch(opcode) {
          case "JMPIG" : 
            JMPIG(rs, rc);
            break;
          case "JMPIL" : 
            JMPIL(rs,rc);
            break;
          case "JMPIE" :
            JMPIE(findRegisterIndex(rs), findRegisterIndex(rc));
            break;
          default :
            break;        
        }
    }

    public void execRegisterVectorOperations(String opcode, String rd, String rs, Memory memory ){
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
    public void execJMPI(String opcode, String rs) {
        JMPI(rs);   
    }

    public void execJMP(String opcode, int k){
        JMP(k);
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


    // UPDATED
    private void JMP(int k) {
        cpu.setPc(k);
    }

    // UPDATED
    private void JMPI(String rs) {
        ObjectRegister object = cpu.getValue(rs);
        Integer value = (Integer) object.getValue();
        cpu.setPc(value);
    }

    // UPDATED
    private void JMPIG(String rs, String rc) {
        ObjectRegister object1 = cpu.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = cpu.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs > 0){
            cpu.setPc(valueRc);
        }
        cpu.setPc(cpu.getPc() + 1);
    }
    
    private void JMPIL(String rs, String rc) {
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

    // UPDATED
    private void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = cpu.getValue(rd);
        int oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        cpu.updateRegister(registerValue);
        pc++;
    }

    // UPDATED
    private void SUBI(String rd, int k) {
        ObjectRegister registerValue = cpu.getValue(rd);
        int oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        pc++;
    }

    // UPDATED
    private void LDI(String rd, int k) {
        cpu.setRegValue(k, rd);
        pc++;
    }

    // UPDATED
    private void LDD(String rd, int a, Memory memory) {
        ObjectRegister object = memory.getValue(a);
        Object value = object.getValue();
        cpu.setRegValue(value, rd);
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

    
    private void LDX(String rd, String rs, Memory memory) {
        ObjectRegister rsObject = cpu.getValue(rs);
        Object value = rsObject.getValue();
        cpu.setRegValue(value, rd);
        pc++;
    }

    // Precisa fazer com que ele encontre na memória
    private void STX(String rd, String rs, Memory memory) {
        memory[register[rd]] = register[rs];
        pc++;
    }
}