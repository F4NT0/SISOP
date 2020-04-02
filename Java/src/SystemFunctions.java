/**********************************************************
* FUNÇÕES DE ASSEMBLY DOS PROGRAMAS CONSTRUIDOS PARA O PC
***********************************************************/


public class SystemFunctions {

    //---------------- Variáveis Globais --------------------------------------------
    private Cpu cpu = new Cpu();


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

    public void execVectorOperations(String opcode, String rd , int a){
        switch(opcode){
            case "LDD" : 
                LDD(rd, a);
                break;
            case "STD" : 
                STD(a, rd);
                break;
        }
    }

    public void execRegisterOperations(String opcode, String rd , String rs){
        switch(opcode){
            case "ADD" :
                ADD(rd, rs);
                break;
            case "SUB" : 
                SUB(rd, rs);
                break;
            case "MULT" : 
                MULT(rd, rs);
                break;
        }
    }

    public void execJumpOperations(String opcode, String rs, String rc) {
        switch(opcode) {
          case "JMPIG" : 
            JMPIG(rs, rc);
            break;
          case "JMPIL" : 
            JMPIL(rs,rc);
            break;
          case "JMPIE" :
            JMPIE(rs, rc);
            break;
          default :
            break;        
        }
    }

    public void execRegisterVectorOperations(String opcode, String rd, String rs){
        switch(opcode){
            case "LDX" :
                LDX(rd, rs);
            break;
            case "STX" :
                STX(rd, rs);
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
    
    // UPDATED
    private void JMPIL(String rs, String rc) {
        ObjectRegister object1 = cpu.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = cpu.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs < 0){
            cpu.setPc(valueRc);
        }
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void JMPIE(String rs, String rc) {
        ObjectRegister object1 = cpu.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = cpu.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs == 0){
            cpu.setPc(valueRc);
        }
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = cpu.getValue(rd);
        int oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        cpu.updateRegister(registerValue);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void SUBI(String rd, Integer k) {
        ObjectRegister registerValue = cpu.getValue(rd);
        int oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void LDI(String rd, Integer k) {
        cpu.setRegValue(k, rd);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void LDD(String rd, int a) {
        ObjectRegister object = cpu.getValueDirect(a);
        Object value = object.getValue();
        cpu.setRegValue(value, rd);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void STD(int a, String rd) {
        ObjectRegister objectRd = cpu.getValue(rd);
        cpu.setRegValuePosition(objectRd, a);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void ADD(String rd, String rs) {
        ObjectRegister objectRd = cpu.getValue(rd);
        ObjectRegister objectRs = cpu.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer soma = valueRd + valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(soma);
        cpu.updateRegister(newRd);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void SUB(String rd, String rs) {
        ObjectRegister objectRd = cpu.getValue(rd);
        ObjectRegister objectRs = cpu.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer sub = valueRd - valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(sub);
        cpu.updateRegister(newRd);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void MULT(String rd, String rs) {
        ObjectRegister objectRd = cpu.getValue(rd);
        ObjectRegister objectRs = cpu.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer mult = valueRd * valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(mult);
        cpu.updateRegister(newRd);
        cpu.setPc(cpu.getPc() + 1);
    }

    // UPDATED
    private void LDX(String rd, String rs) {
        ObjectRegister rsObject = cpu.getValue(rs); //pega o objeto rs
        Integer value = (Integer) rsObject.getValue(); // pega o valor do objeto rs
        ObjectRegister getObject = cpu.getValueDirect(value); //pega o objeto da posicao armazenada em rs
        Object valueRd = getObject.getValue(); // valor que sera armazenado em rd
        cpu.setRegValue(valueRd, rd); // novo objeto na memória conectado no vetor rd
        cpu.setPc(cpu.getPc() + 1); //atualiza o pc
    }

    // UPDATED
    private void STX(String rd, String rs) {
        ObjectRegister rdObject = cpu.getValue(rd);
        Integer value = (Integer) rdObject.getValue();
        ObjectRegister getObject = cpu.getValueDirect(value);
        Object valueRs = getObject.getValue();
        cpu.setRegValue(valueRs, rs);
        cpu.setPc(cpu.getPc() + 1);
      
    }
}
