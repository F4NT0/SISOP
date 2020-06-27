package system.cpu;
import system.memory.*;
import system.in_out.reader.*;

public class Assembly {

    ControlUnit controlUnit;
    Memory memory;


    public Assembly(Memory m, ControlUnit controlUnit) {
        this.memory = m;
        this.controlUnit = controlUnit;
    }
    /**
    ===================
    Métodos de Assembly
    ===================
    */

    public void JMP(Integer k) {
        //Partition pa = findPartition(controlUnit.getProcess().getPCB().getPartitionID())
        
        controlUnit.setPc(k);
    }
    
    public void JMPI(String rs) {
        ObjectRegister object = controlUnit.getValue(rs);
        Integer value = (Integer) object.getValue();
        controlUnit.setPc(value);
    }
    
    public void JMPIG(String rs, String rc) {
        ObjectRegister object1 = controlUnit.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = controlUnit.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs > 0){controlUnit.setPc(valueRc);}
        else{controlUnit.setPc(controlUnit.getPc() + 1);}
        
    }
    
    public void JMPIL(String rs, String rc) {
        ObjectRegister object1 = controlUnit.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = controlUnit.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs < 0){controlUnit.setPc(valueRc);}
        else{controlUnit.setPc(controlUnit.getPc() + 1);}
    }
    
    public void JMPIE(String rs, String rc) {
        ObjectRegister object1 = controlUnit.getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = controlUnit.getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs == 0){controlUnit.setPc(valueRc);}
        else{controlUnit.setPc(controlUnit.getPc() + 1);}
    }
    
    public void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = controlUnit.getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        controlUnit.updateRegister(controlUnit.getRegisterLocation(rd),registerValue);
        controlUnit.setPc(controlUnit.getPc() + 1); 
    }
    
    public void SUBI(String rd, Integer k) {
        ObjectRegister registerValue = controlUnit.getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        controlUnit.updateRegister(controlUnit.getRegisterLocation(rd), registerValue);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void LDI(String rd, Integer k) {
        controlUnit.setRegValue(k, rd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void LDD(String rd, Integer a) {
        Object value = controlUnit.getIntegerDirect(a);
        controlUnit.setRegValue(value, rd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void STD(Integer a, String rd) {
        try{
            ObjectRegister objectRd = controlUnit.getValue(rd);
            Object value = objectRd.getValue();
            controlUnit.setValueOnMemory(value, a);
            controlUnit.setPc(controlUnit.getPc() + 1);
        }catch(NullPointerException e){
            System.err.println(e);
        }
    }
    
    public void ADD(String rd, String rs) {
        ObjectRegister objectRd = controlUnit.getValue(rd);
        ObjectRegister objectRs = controlUnit.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer soma = valueRd + valueRs;
        objectRd.setValue(soma);
        controlUnit.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void SUB(String rd, String rs) {
        ObjectRegister objectRd = controlUnit.getValue(rd);
        ObjectRegister objectRs = controlUnit.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer sub = valueRd - valueRs;
        objectRd.setValue(sub);
        controlUnit.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void MULT(String rd, String rs) {
        ObjectRegister objectRd = controlUnit.getValue(rd);
        ObjectRegister objectRs = controlUnit.getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer mult = valueRd * valueRs;
        objectRd.setValue(mult);
        controlUnit.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    public void LDX(String rd, String rs) {
        ObjectRegister rsObject = controlUnit.getValue(rs);
        Integer value = (Integer) rsObject.getValue();
        //Object getObject = memory.getObjectOnPosition(value); 
        //Object valueRd = getObject; 
        //controlUnit.setRegValue(valueRd, rd); 
        controlUnit.setPc(controlUnit.getPc() + 1); 
    }
    
    public void STX(String rd, String rs) {
        ObjectRegister rdObject = controlUnit.getValue(rd);
        Integer value = (Integer) rdObject.getValue();
        ObjectRegister rsObject = controlUnit.getValue(rs);
        Object rsValue = rsObject.getValue();    
        //memory.addValueOnPosition(rsValue, value);
        controlUnit.setPc(controlUnit.getPc() + 1);
      
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 ASSEMBLY COMPILANDO!");
    }
}