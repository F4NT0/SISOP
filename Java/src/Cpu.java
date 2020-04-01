import java.util.ArrayList;

/************************
 * CPU DA MÁQUINA VIRTUAL
 *************************/

public class Cpu{
    private int r0,r1,r2,r3,r4,r5,r6,r7; //localização do Registrador na memória
    private int pc;
    private Memory memory = new Memory();


    public Cpu(){
        this.r0 = -1;
        this.r1 = -1;
        this.r2 = -1;
        this.r3 = -1;
        this.r4 = -1;
        this.r5 = -1;
        this.r6 = -1;
        this.r7 = -1;
        this.pc = 0;

    }

    //----------------------- Getters -----------------------------------
    public int getR0(){return r0;}
    public int getR1(){return r1;}
    public int getR2(){return r2;}
    public int getR3(){return r3;}
    public int getR4(){return r4;}
    public int getR5(){return r5;}
    public int getR6(){return r6;}
    public int getR7(){return r7;}
    public int getPc(){return pc;}
    public Memory getMemory(){return memory;}

    //----------------------- Setters -------------------------------------
    public void setR0(int r0){this.r0 = r0;}
    public void setR1(int r1){this.r1 = r1;}
    public void setR2(int r2){this.r2 = r2;}
    public void setR3(int r3){this.r3 = r3;}
    public void setR4(int r4){this.r4 = r4;}
    public void setR5(int r5){this.r5 = r5;}
    public void setR6(int r6){this.r6 = r6;}
    public void setR7(int r7){this.r7 = r7;}
    public void setPc(int pc){this.pc = pc;}

    //----------------------- Armazena a posição de um Registrador -----------------
    public void setRegisterPosition(String register, int position){
        switch(register){
            case "r0":
                setR0(position);
            break;
            case "r1":
                setR1(position);
            break;
            case "r2":
                setR2(position);
            break;
            case "r3":
                setR3(position);
            break;
            case "r4":
                setR4(position);
            break;
            case "r5":
                setR5(position);
            break;
            case "r6":
                setR6(position);
            break;
            case "r7":
                setR7(position);
            break;
        }
    }

    //----------------------- Carrega Programa  ------------------------------------
    public void loadProgram(String file){
        ObjectCreator objects = new ObjectCreator();
        objects.readAndCreateFunctions(file);
        storeProgram(objects.getFuncoes());
    }

    //----------------------- Armazena o Programa na Memória ------------------------
    public void storeProgram(ArrayList<Funcao> program){
        memory.setProgram(program.size(), program);
        pc = 0;
    }

    //---------------- Armazena um valor de um Registrador na Memória -----------------
    public void setRegValue(Object value, String register){
        ObjectRegister object = new ObjectRegister();
        object.setRegister(register);
        object.setValue(value);
        memory.addRegister(object);
        int position = memory.findRegister(object);
        setRegisterPosition(register, position);
    }

    //--------------- Retorna o valor de um Registrador -------------------------------
    public ObjectRegister getValue(String register){
        ObjectRegister value = null;
        switch(register){
            case "r0":
                value = memory.getValue(r0);
                break;
            case "r1":
                value = memory.getValue(r1);
                break;
            case "r2":
                value = memory.getValue(r2);
                break;
            case "r3":
                value = memory.getValue(r3);
                break;
            case "r4":
                value = memory.getValue(r4);
                break;
            case "r5":
                value = memory.getValue(r5);
                break;
            case "r6":
                value = memory.getValue(r6);
                break;
            case "r7":
                value = memory.getValue(r7);
                break;
        }
        return value;

    }

    //---------------- Atualiza um Registrador -----------------------------------------
    public void updateRegister(ObjectRegister object){
        memory.updateRegister(object);
    }

}