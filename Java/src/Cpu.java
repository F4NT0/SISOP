import java.util.ArrayList;
import java.util.List;

/************************
 * CPU DA MÁQUINA VIRTUAL
 *************************/

public class Cpu{
    private Integer R0,R1,R2,R3,R4,R5,R6,R7; //localização do Registrador na memória
    private Integer pc;
    private Memory memory = new Memory();
    //private SystemFunctions assemblyFunctions = new SystemFunctions();
    private Integer programSize;


    public Cpu(){ // Valores começam em -1 para não armazenar um valor de memoria real
        this.R0 = -1;
        this.R1 = -1;
        this.R2 = -1;
        this.R3 = -1;
        this.R4 = -1;
        this.R5 = -1;
        this.R6 = -1;
        this.R7 = -1;
        this.pc = 0;
        this.programSize = 0;
    }


    /*************************************************************************
     *  FUNÇÕES PARA GERENCIAMENTO DOS REGISTRADORES E INTERAÇÃO COM A MEMÓRIA
     ************************************************************************/


    //----------------------- Getters -----------------------------------
    public Integer getR0(){return R0;}
    public Integer getR1(){return R1;}
    public Integer getR2(){return R2;}
    public Integer getR3(){return R3;}
    public Integer getR4(){return R4;}
    public Integer getR5(){return R5;}
    public Integer getR6(){return R6;}
    public Integer getR7(){return R7;}
    public Integer getPc(){return pc;}
    public Integer getProgramSize(){return programSize;}
    public Memory getMemory(){return memory;}

    //----------------------- Setters -------------------------------------
    public void setR0(Integer R0){this.R0 = R0;}
    public void setR1(Integer R1){this.R1 = R1;}
    public void setR2(Integer R2){this.R2 = R2;}
    public void setR3(Integer R3){this.R3 = R3;}
    public void setR4(Integer R4){this.R4 = R4;}
    public void setR5(Integer R5){this.R5 = R5;}
    public void setR6(Integer R6){this.R6 = R6;}
    public void setR7(Integer R7){this.R7 = R7;}
    public void setPc(Integer pc){this.pc = pc;}
    public void setProgramSize(Integer programSize){this.programSize = programSize;}

    //----------------------- Armazena a posição de um Registrador -----------------
    public void setRegisterPosition(String register, Integer position){
        switch(register){
            case "R0":
                setR0(position);
            break;
            case "R1":
                setR1(position);
            break;
            case "R2":
                setR2(position);
            break;
            case "R3":
                setR3(position);
            break;
            case "R4":
                setR4(position);
            break;
            case "R5":
                setR5(position);
            break;
            case "R6":
                setR6(position);
            break;
            case "R7":
                setR7(position);
            break;
        }
    }

    //---------------- Armazena um valor de um Registrador na Memória -----------------
    public void setRegValue(Object value, String register){ 
        ObjectRegister object = new ObjectRegister();
        object.setRegister(register);
        object.setValue(value);
        memory.addRegister(object);
        Integer position = memory.findRegister(object);
        setRegisterPosition(register, position);
    }


    //--------------- Define que um registrador irá mudar uma pos especifica do registrador -------
    public void setRegValuePosition(ObjectRegister object, Integer position){
        Integer positionFind = memory.findRegister(object);
        if(positionFind == -1){
            memory.addRegister(object);
        }
        memory.setRegisterOnPosition(position, object);
        memory.remove(positionFind);
   }

    //--------------- Retorna o valor de um Registrador -------------------------------
    public ObjectRegister getValue(String register){
        ObjectRegister value = null;
        switch(register){
            case "R0":
                value = memory.getValue(R0);
                break;
            case "R1":
                value = memory.getValue(R1);
                break;
            case "R2":
                value = memory.getValue(R2);
                break;
            case "R3":
                value = memory.getValue(R3);
                break;
            case "R4":
                value = memory.getValue(R4);
                break;
            case "R5":
                value = memory.getValue(R5);
                break;
            case "R6":
                value = memory.getValue(R6);
                break;
            case "R7":
                value = memory.getValue(R7);
                break;
        }
        return value;

    }

    //--------------- Retorna um objeto completo somente pela posição ------------------
    public ObjectRegister getValueDirect(Integer position){
        ObjectRegister value = memory.getValue(position);
        return value;
    }

    //---------------- Atualiza um Registrador -----------------------------------------
    public void updateRegister(ObjectRegister object){
        memory.updateRegister(object);
    }


    /************************************************
    * FUNÇÕES DE LEITURA E ARMAZENAMENTO DO PROGRAMA 
    *************************************************/


    //----------------------- Carrega Programa  ------------------------------------
    public void loadProgram(String file){
        ObjectCreator objects = new ObjectCreator();
        objects.readAndCreateFunctions(file);
        storeProgram(objects.getFuncoes());
        setProgramSize(objects.getProgramSize()-1);

    }

    //----------------------- Armazena o Programa na Memória ------------------------
    public void storeProgram(ArrayList<Funcao> program){
        memory.setProgram(program.size(), program);
        pc = 0;
    }

    //---------------------- Função que testa a Memória ----------------
    public void testMemory(){
        List<Object> teste = memory.array();
        for(Integer i = 0 ; i <= 30 ; i++){
            System.out.println("Pos: " + i + ": " + teste.get(i));
        }
        
    }
    

    /***************************************** 
    * RODANDO O PROGRAMA E FUNÇÕES DE ASSEMBLY 
    ******************************************/

    //---------------- Função que pega o Objeto e faz uma Função --------------------
    public void runningFunctions(Funcao object){
        String opcode = object.getOpcode();
        String rs = object.getRs();
        String rd = object.getRd();
        String rc = object.getRc();
        Integer k = object.getK();
        Integer a = object.getA();
        switch(opcode){
            case "JMP":
                JMP(k);
                break;
            case "JMPI":
                JMPI(rs);
                break;
            case "JMPIG":
                JMPIG(rs, rc);
                break;
            case "JMPIL":
                JMPIL(rs, rc);
                break;
            case "JMPIE":
                JMPIE(rs, rc);
                break;
            case "ADDI":
                ADDI(rd, k);
                break;
            case "SUBI":
                SUBI(rd, k);
                break;
            case "LDI":
                LDI(rd, k);
                break;
            case "LDD":
                LDD(rd, a);
                break;
            case "STD":
                STD(a, rd);
                break;
            case "ADD":
                ADD(rd, rs);
                break;
            case "SUB":
                SUB(rd, rs);
                break;
            case "MULT":
                MULT(rd, rs);
                break;
            case "LDX":
                LDX(rd, rs);
                break;
            case "STX":
                STX(rd, rs);
                break;
            default:
                
            
                
        }
    }

    //---------------------- Função que faz as Funções de Assembly  ------------
    public void runningProgram(Integer size){
        System.out.println("Entrou Aqui!");
        Funcao object = memory.getProgram(getPc());
        runningFunctions(object);
        System.out.println("OPCODE: " + object.getOpcode());
        if(size == 0){System.out.println("Finish Program!");}
        else{runningProgram(size-1);}  
    }   

    //====================
    // FUNÇÕES DE ASSEMBLY
    //====================

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
        if(valueRs < 0){
            setPc(valueRc);
        }
        setPc(getPc() + 1);
    }

    private void JMPIE(String rs, String rc) {
        ObjectRegister object1 = getValue(rs);
        Integer valueRs = (Integer) object1.getValue();
        ObjectRegister object2 = getValue(rc);
        Integer valueRc = (Integer) object2.getValue();
        if(valueRs == 0){
            setPc(valueRc);
        }
        setPc(getPc() + 1);
    }

    private void ADDI(String rd, Integer k) {
        ObjectRegister registerValue = getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue + k);
        updateRegister(registerValue);
        setPc(getPc() + 1);
    }

    private void SUBI(String rd, Integer k) {
        ObjectRegister registerValue = getValue(rd);
        Integer oldValue = (Integer) registerValue.getValue();
        registerValue.setValue(oldValue - k);
        setPc(getPc() + 1);
    }

    private void LDI(String rd, Integer k) {
        setRegValue(k, rd);
        setPc(getPc() + 1);
    }

    private void LDD(String rd, Integer a) {
        ObjectRegister object = getValueDirect(a);
        Object value = object.getValue();
        setRegValue(value, rd);
        setPc(getPc() + 1);
    }

    private void STD(Integer a, String rd) {
        ObjectRegister objectRd = getValue(rd);
        setRegValuePosition(objectRd, a);
        setPc(getPc() + 1);
    }

    private void ADD(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer soma = valueRd + valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(soma);
        updateRegister(newRd);
        setPc(getPc() + 1);
    }

    private void SUB(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer sub = valueRd - valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(sub);
        updateRegister(newRd);
        setPc(getPc() + 1);
    }

    private void MULT(String rd, String rs) {
        ObjectRegister objectRd = getValue(rd);
        ObjectRegister objectRs = getValue(rs);
        Integer valueRd = (Integer) objectRd.getValue();
        Integer valueRs = (Integer) objectRs.getValue();
        Integer mult = valueRd * valueRs;
        ObjectRegister newRd = new ObjectRegister();
        newRd.setRegister(rd);
        newRd.setValue(mult);
        updateRegister(newRd);
        setPc(getPc() + 1);
    }

    private void LDX(String rd, String rs) {
        ObjectRegister rsObject = getValue(rs); //pega o objeto rs
        Integer value = (Integer) rsObject.getValue(); // pega o valor do objeto rs
        ObjectRegister getObject = getValueDirect(value); //pega o objeto da posicao armazenada em rs
        Object valueRd = getObject.getValue(); // valor que sera armazenado em rd
        setRegValue(valueRd, rd); // novo objeto na memória conectado no vetor rd
        setPc(getPc() + 1); //atualiza o pc
    }

    private void STX(String rd, String rs) {
        ObjectRegister rdObject = getValue(rd);
        Integer value = (Integer) rdObject.getValue();
        ObjectRegister getObject = getValueDirect(value);
        Object valueRs = getObject.getValue();
        setRegValue(valueRs, rs);
        setPc(getPc() + 1);
      
    }





}