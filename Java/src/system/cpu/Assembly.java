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

    /**
     * Envia o PC para uma posição específica
     * @param k
     */
    public void JMP(Integer k) { 
        controlUnit.setPc(k);
    }
    
    /**
     * Envia o PC para uma posição armazenada em um Registrador
     * @param rs
     */
    public void JMPI(String rs) {
        ObjectRegister object = getRegister(rs);
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
    
    /**
     * Verifica se um valor de um Registrador é igual que Zero, 
     * se for, ele vai pegar o valor de outro Registrador e 
     * enviar o PC para o valor, 
     * senão ele somente vai para a proxima linha do programa
     * @param rs
     * @param rc
     */
    public void JMPIE(String rs, String rc) {
        ObjectRegister object1 = getRegister(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getRegister(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs == 0){controlUnit.setPc(valueRc);}
        else{controlUnit.setPc(controlUnit.getPc() + 1);}
    }
    
    /**
     * Imediatamente soma um valor dentro de um Registrador 
     * com um valor entrado
     * @param rd
     * @param k
     */
    public void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = getRegister(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        memory.updateRegister(controlUnit.getRegisterLocation(rd),registerValue);
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
    
    /**
     * Somamos o valor armazenado entre dois Registradores 
     * no primeiro Registrador inserido
     * @param rd
     * @param rs
     */
    public void ADD(String rd, String rs) {
        ObjectRegister objectRd = getRegister(rd);
        ObjectRegister objectRs = getRegister(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer soma = valueRd + valueRs;
        objectRd.setValue(soma);
        memory.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
        controlUnit.setPc(controlUnit.getPc() + 1);
    }
    
    /**
     * Subtraimos o valor armazenado entre dois Registradores 
     * no primeiro Registrador inserido
     * @param rd
     * @param rs
     */
    public void SUB(String rd, String rs) {
        ObjectRegister objectRd = getRegister(rd);
        ObjectRegister objectRs = getRegister(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer sub = valueRd - valueRs;
        objectRd.setValue(sub);
        memory.updateRegister(controlUnit.getRegisterLocation(rd), objectRd);
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
    
    /**
     * Pega o valor que está no Rs e acessa a posição da memória 
     * desse valor e armazena em um Novo Registrador Rd
     * OBS: se na memória for um número direto(usando STD) ele salva um numero
     * senão é um Objeto
     * @param rd
     * @param rs
     */
    public void LDX(String rd, String rs) {
        ObjectRegister objectRs = getRegister(rs);
        Integer value = (Integer) objectRs.getValue();
        Object getObject = memory.getObjectOnPosition(value); 
        Object valueRd = getObject; 
        setRegValue(valueRd, rd); 
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
            case "R1": value = memory.getValue(controlUnit.getRegisterLocation("R1"));break;
            case "R2": value = memory.getValue(controlUnit.getRegisterLocation("R2"));break;
            case "R3": value = memory.getValue(controlUnit.getRegisterLocation("R3"));break;
            case "R4": value = memory.getValue(controlUnit.getRegisterLocation("R4"));break;
            case "R5": value = memory.getValue(controlUnit.getRegisterLocation("R5"));break;
            case "R6": value = memory.getValue(controlUnit.getRegisterLocation("R6"));break;
            case "R7": value = memory.getValue(controlUnit.getRegisterLocation("R7"));break;
            case "R8": value = memory.getValue(controlUnit.getRegisterLocation("R8"));break;
		}
	 return value;
    }
    

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 ASSEMBLY COMPILANDO!");
    }
}