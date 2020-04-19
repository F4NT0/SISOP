import java.util.ArrayList;
import java.util.List;

/************************
 * CPU DA MÁQUINA VIRTUAL
 *************************/

public class Cpu{
    private Integer R1,R2,R3,R4,R5,R6,R7,R8; //localização do Registrador na memória
    private Integer pc;
    private Memory memory = new Memory();
    private Integer programSize;


    public Cpu(){
        // Valores começam em -1 para não armazenar um valor de memoria real 
        this.R1 = -1;
        this.R2 = -1;
        this.R3 = -1;
        this.R4 = -1;
        this.R5 = -1;
        this.R6 = -1;
        this.R7 = -1;
        this.R8 = -1;
        this.pc = 0;
        this.programSize = 0;
    }


    /**------------------------------------------------------------------------
    *  FUNÇÕES PARA GERENCIAMENTO DOS REGISTRADORES E INTERAÇÃO COM A MEMÓRIA
    ------------------------------------------------------------------------*/


    //----------------------- Getters -----------------------------------
    public Integer getR1(){return R1;}
    public Integer getR2(){return R2;}
    public Integer getR3(){return R3;}
    public Integer getR4(){return R4;}
    public Integer getR5(){return R5;}
    public Integer getR6(){return R6;}
    public Integer getR7(){return R7;}
    public Integer getR8(){return R8;}
    public Integer getPc(){return pc;}
    public Integer getProgramSize(){return programSize;}
    public Memory getMemory(){return memory;}

    //----------------------- Setters -------------------------------------
    public void setR1(Integer R1){this.R1 = R1;}
    public void setR2(Integer R2){this.R2 = R2;}
    public void setR3(Integer R3){this.R3 = R3;}
    public void setR4(Integer R4){this.R4 = R4;}
    public void setR5(Integer R5){this.R5 = R5;}
    public void setR6(Integer R6){this.R6 = R6;}
    public void setR7(Integer R7){this.R7 = R7;}
    public void setR8(Integer R8){this.R8 = R8;}
    public void setPc(Integer pc){this.pc = pc;}
    public void setProgramSize(Integer programSize){this.programSize = programSize;}

    
    /**
     * Armazena a posição de um Registrador dentro da CPU
     * @param register
     * @param position
     */
    private void setRegisterPosition(String register, Integer position){
        switch(register){
            case "R1":setR1(position);break;
            case "R2":setR2(position);break;
            case "R3":setR3(position);break;
            case "R4":setR4(position);break;
            case "R5":setR5(position);break;
            case "R6":setR6(position);break;
            case "R7":setR7(position);break;
            case "R8":setR8(position);break;
        }
    }

    /**
     * Armazena um valor em um Registrador na Memória
     * @param value
     * @param register
     */
    public void setRegValue(Object value, String register){ 
        ObjectRegister object = new ObjectRegister();
        object.setRegister(register);
        object.setValue(value);
        memory.addRegister(object);
        Integer position = memory.findRegister(object);
        setRegisterPosition(register, position);
    }

    /**
     * Armazena um Objeto(Integer,Char) direto na memória
     * @param value
     * @param position
     */
    public void setValueOnMemory(Object value, Integer position){
        memory.addValueOnPosition(value, position);
    }

    /**
     * Define que um registrador irá mudar uma posição especifica do registrador
     * @param object
     * @param position
     */
    public void setRegValuePosition(ObjectRegister object, Integer position){
        Integer positionFind = memory.findRegister(object);
        if(positionFind == -1){
            memory.addRegister(object);
        }
        memory.setRegisterOnPosition(position, object);
        memory.remove(positionFind);
   }

    /**
     * Retorna o Objeto Registrador da memória
     * @param register 
     * @return value
     */
    public ObjectRegister getValue(String register){
        ObjectRegister value = null;
        switch(register){
            case "R1":value = memory.getValue(R1);break;
            case "R2":value = memory.getValue(R2);break;
            case "R3":value = memory.getValue(R3);break;
            case "R4":value = memory.getValue(R4);break;
            case "R5":value = memory.getValue(R5);break;
            case "R6":value = memory.getValue(R6);break;
            case "R7":value = memory.getValue(R7);break;
            case "R8":value = memory.getValue(R8);break;
        }
        return value;
    }

    /**
     * Retorna um Registrador completo somente pela posição da Memória
     * @param position
     * @return value
     */
    public ObjectRegister getValueDirect(Integer position){
        ObjectRegister value = memory.getValue(position);
        return value;
    }

    /**
     * Retorna um Objeto armazenado direto na memória
     * @param position
     * @return value
     */
    public Object getIntegerDirect(Integer position){
        Object value = memory.getObjectOnPosition(position);
        return value;
    }

    /**
     * Atualiza os valores de um Objeto Registrador
     * @param location
     * @param newRegister
     */
    public void updateRegister(Integer location, ObjectRegister newRegister){
        memory.updateRegister(location, newRegister);
    }

    /**
     * Retorna a localização de um Registrador
     * @param register
     * @return
     */
    public Integer getRegisterLocation(String register){
        Integer location = -1;
        switch(register){
            case "R1": location = getR1(); break;
            case "R2": location = getR2(); break;
            case "R3": location = getR3(); break;
            case "R4": location = getR4(); break;
            case "R5": location = getR5(); break;
            case "R6": location = getR6(); break;
            case "R7": location = getR7(); break;
            case "R8": location = getR8(); break;

        }
        return location;

    }


    /*-----------------------------------------------
    * FUNÇÕES DE LEITURA E ARMAZENAMENTO DO PROGRAMA 
    ------------------------------------------------*/


    /**
     * Função de interação do Programa para enviar á memória
     * @param file
     */
    public void loadProgram(String file){
        ObjectCreator objects = new ObjectCreator();
        objects.readAndCreateFunctions(file);
        clearMemory();
        storeProgram(objects.getFuncoes());
        setProgramSize(objects.getProgramSize()-1);

    }

    /**
     * Salva a Lista de Objetos Funcao para a Memória
     * @param program
     */
    private void storeProgram(ArrayList<Funcao> program){
        memory.setProgram(program.size(), program);
        pc = 0;
    }

    /**
     * Função que testa como a Memória está no momento
     */
    public void testMemory(){
        List<Object> teste = memory.array();
        for(Integer i = 0 ; i <= 20 ; i++){
            System.out.println("Pos: " + i + ": " + teste.get(i));
        }
        
    }

    /**
     * Limpa a Memória para ler outro programa
     */
    public void clearMemory(){
        memory.clearMemory();
        setR1(-1);setR2(-1);
        setR3(-1);setR4(-1);
        setR5(-1);setR6(-1);
        setR7(-1);setR8(-1);
    }
    

    /*----------------------------------------- 
    * RODANDO O PROGRAMA E FUNÇÕES DE ASSEMBLY 
    ------------------------------------------*/

    /**
     * Pega o Objeto Funcao de entrada e realiza a Função Assembly de entrada
     * @param object
     */
    public void runningFunctions(Funcao object){
        String opcode = object.getOpcode();
        String rs = object.getRs();
        String rd = object.getRd();
        String rc = object.getRc();
        Integer k = object.getK();
        Integer a = object.getA();
        switch(opcode){
            case "JMP":JMP(k);break;
            case "JMPI":JMPI(rs);break;
            case "JMPIG":JMPIG(rs, rc);break;
            case "JMPIL":JMPIL(rs, rc);break;
            case "JMPIE":JMPIE(rs, rc);break;
            case "ADDI":ADDI(rd, k);break;
            case "SUBI":SUBI(rd, k);break;
            case "LDI":LDI(rd, k);break;
            case "LDD":LDD(rd, a);break;
            case "STD":STD(a, rs);break;
            case "ADD":ADD(rd, rs);break;
            case "SUB":SUB(rd, rs);break;
            case "MULT":MULT(rd, rs);break;
            case "LDX":LDX(rd, rs);break;
            case "STX":STX(rd, rs);break;    
        }
    }

    /**
     * Função que roda o programa de forma Recursiva
     */
    public void runningProgram(Integer size){
        Funcao object = memory.getProgram(getPc());
        runningFunctions(object);
        if(size == 0){System.out.println("Finish Program!");}
        if(object.getOpcode().equals("STOP")){size = 0;}
        else{runningProgram(size-1);}  
    }   
    
    /**
     * Função de Saída para o Terminal
     */
    public String finalValues(){
        try{
            String r1 = "";
            String r2 = "";
            String r3 = "";
            String r4 = "";
            String r5 = "";
            String r6 = "";
            String r7 = "";
            String r8 = "";
            if(getR1() != -1){ObjectRegister object1 = memory.getValue(getR1());
                r1 = "R1: " + object1.getValue();}
            if(getR2() != -1){ObjectRegister object1 = memory.getValue(getR2());
                r2 = "R2: " + object1.getValue();}
            if(getR3() != -1){ObjectRegister object1 = memory.getValue(getR3());
                r3 = "R3: " + object1.getValue();}
            if(getR4() != -1){ObjectRegister object1 = memory.getValue(getR4());
                r4 = "R4: " + object1.getValue();}
            if(getR5() != -1){ObjectRegister object1 = memory.getValue(getR5());
                r5 = "R5: " + object1.getValue();}
            if(getR6() != -1){ObjectRegister object1 = memory.getValue(getR6());
                r6 = "R6: " + object1.getValue();}
            if(getR7() != -1){ObjectRegister object1 = memory.getValue(getR7());
                r7 = "R7: " + object1.getValue();}
            if(getR8() != -1){ObjectRegister object1 = memory.getValue(getR8());
                r8 = "R8: " + object1.getValue();}
            String exit = r1 + "\n" + r2 + "\n" + r3 + "\n" + r4 + "\n" + r5 + "\n" + r6 + "\n" + r7 + "\n" + r8 + "\n"; 
            return exit;

        }catch(NullPointerException e){
            System.err.println("Erro: " + e);
        }
        return "";
    }

    
    /**----------------
    * FUNÇÕES ASSEMBLY
    -----------------*/

    
    private void JMP(Integer k) {
        setPc(k);
    }

    private void JMPI(String rs) {
        ObjectRegister object = getValue(rs);
        Integer value = (Integer) object.getValue();
        setPc(value);
    }

    private void JMPIG(String rs, String rc) {
        ObjectRegister object1 = getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs > 0){setPc(valueRc);}
        else{setPc(getPc() + 1);}
        
    }

    private void JMPIL(String rs, String rc) {
        ObjectRegister object1 = getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs < 0){setPc(valueRc);}
        else{setPc(getPc() + 1);}
    }

    private void JMPIE(String rs, String rc) {
        ObjectRegister object1 = getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs == 0){setPc(valueRc);}
        else{setPc(getPc() + 1);}
    }

    private void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        updateRegister(getRegisterLocation(rd),registerValue);
        setPc(getPc() + 1); 
    }

    private void SUBI(String rd, Integer k) {
        ObjectRegister registerValue = getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        updateRegister(getRegisterLocation(rd), registerValue);
        setPc(getPc() + 1);
    }

    private void LDI(String rd, Integer k) {
        setRegValue(k, rd);
        setPc(getPc() + 1);
    }

    private void LDD(String rd, Integer a) {
        Object value = getIntegerDirect(a);
        setRegValue(value, rd);
        setPc(getPc() + 1);
    }

    private void STD(Integer a, String rd) {
        try{
            ObjectRegister objectRd = getValue(rd);
            Object value = objectRd.getValue();
            setValueOnMemory(value, a);
            setPc(getPc() + 1);
        }catch(NullPointerException e){
            System.err.println(e);
        }
    }

    private void ADD(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer soma = valueRd + valueRs;
        objectRd.setValue(soma);
        updateRegister(getRegisterLocation(rd), objectRd);
        setPc(getPc() + 1);
    }

    private void SUB(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer sub = valueRd - valueRs;
        objectRd.setValue(sub);
        updateRegister(getRegisterLocation(rd), objectRd);
        setPc(getPc() + 1);
    }

    private void MULT(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer mult = valueRd * valueRs;
        objectRd.setValue(mult);
        updateRegister(getRegisterLocation(rd), objectRd);
        setPc(getPc() + 1);
    }

    private void LDX(String rd, String rs) {
        ObjectRegister rsObject = getValue(rs);
        Integer value = (Integer) rsObject.getValue();
        Object getObject = memory.getObjectOnPosition(value); 
        Object valueRd = getObject; 
        setRegValue(valueRd, rd); 
        setPc(getPc() + 1); 
    }

    private void STX(String rd, String rs) {
        ObjectRegister rdObject = getValue(rd);
        Integer value = (Integer) rdObject.getValue();
        ObjectRegister rsObject = getValue(rs);
        Object rsValue = rsObject.getValue();    
        memory.addValueOnPosition(rsValue, value);
        setPc(getPc() + 1);
      
    }
}