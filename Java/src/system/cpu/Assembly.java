package system.cpu;
import system.memory.*;;

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
    
    /**
     * Verifica se um valor de um Registrador é maior que Zero, 
     * se for, ele vai pegar o valor de outro Registrador e enviar o PC para o valor, 
     * senão ele somente vai para a proxima linha do programa
     * @param rs
     * @param rc
     */
    public void JMPIG(String rs, String rc) {
        ObjectRegister object1 = getRegister(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getRegister(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs > 0){controlUnit.setPc(valueRc);}
        else{controlUnit.setPc(controlUnit.getPc() + 1);}
        
    }

    /**
     * Verifica se um valor de um Registrador é menor que Zero, se for, 
     * ele vai pegar o valor de outro Registrador e enviar o PC para o valor, 
     * senão ele somente vai para a proxima linha do programa
     * @param rs
     * @param rc
     */
    public void JMPIL(String rs, String rc) {
        ObjectRegister object1 = getRegister(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getRegister(rc);
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
    
    /**
     * Imediatamente subtrai um valor dentro de um Registrador 
     * com um valor entrado
     * @param rd
     * @param k
     */
    public void SUBI(String rd, Integer k) {
        ObjectRegister registerValue = getRegister(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        memory.updateRegister(controlUnit.getRegisterLocation(rd),registerValue);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    /**
     * Imediatamente Carrega um valor entrado para dentro de um Registrador
     * @param rd
     * @param k
     */
    public void LDI(String rd, Integer k) {
        setRegValue(k, rd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    /**
     * Imediatamente Carregamos um valor vindo 
     * de uma Posição de Memória Específica
     * @param rd
     * @param a
     */
    public void LDD(String rd, Integer a) {
        Object value = memory.getObjectOnPosition(a);
        setRegValue(value, rd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    /**
     * Imediatamente Colocamos um valor de um Registrador
     * dentro de uma Posição da Memória
     * @param a
     * @param rd
     */
    public void STD(Integer a, String rd) {
        try{
            ObjectRegister objectRd = getRegister(rd);
            Object value = objectRd.getValue();
            memory.addValueOnPosition(value, a);
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
    
    /**
     * Multiplica o valor armazenado entre dois Registradores 
     * no primeiro Registrador inserido
     * @param rd
     * @param rs
     */
    public void MULT(String rd, String rs) {
        ObjectRegister objectRd = getRegister(rd);
        ObjectRegister objectRs = getRegister(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer mult = valueRd * valueRs;
        objectRd.setValue(mult);
        memory.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
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
    
    /**
     * Pega o valor que está no Rd e envia o valor em Rs 
     * para a posição de memória que era o valor do Rd
     * @param rd
     * @param rs
     */
    public void STX(String rd, String rs) {
        ObjectRegister rdObject = getRegister(rd);
        Integer value = (Integer) rdObject.getValue();
        ObjectRegister rsObject = getRegister(rs);
        Object valueRs = rsObject.getValue();    
        memory.addValueOnPosition(valueRs, value);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }


    // FUNÇÕES AUXILIARES

    /**
     * Cria um Registrador e o Salva na Memória
     * @param value
     * @param register
     */
    public void setRegValue(Object value,String register){
		ObjectRegister object = new ObjectRegister();
		object.setRegister(register);
		object.setValue(value);
		memory.addRegister(object);
		Integer position = memory.findRegister(object); 
		controlUnit.setRegisterPosition(register, position);
    }
    
    /**
     * Pegar um Registrador da Memória de Entrada
     * @param register
     * @return Object
     */
    public ObjectRegister getRegister(String register){
		ObjectRegister value = null;
		switch(register){
            case "R1": value = memory.getValue(controlUnit.getReg("R1"));break;
            case "R2": value = memory.getValue(controlUnit.getReg("R2"));break;
            case "R3": value = memory.getValue(controlUnit.getReg("R3"));break;
            case "R4": value = memory.getValue(controlUnit.getReg("R4"));break;
            case "R5": value = memory.getValue(controlUnit.getReg("R5"));break;
            case "R6": value = memory.getValue(controlUnit.getReg("R6"));break;
            case "R7": value = memory.getValue(controlUnit.getReg("R7"));break;
            case "R8": value = memory.getValue(controlUnit.getReg("R8"));break;
		}
	 return value;
    }
    

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 ASSEMBLY COMPILANDO!");
    }
}