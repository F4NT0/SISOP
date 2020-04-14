import java.util.List;
import java.util.ArrayList;

/***********************************************
* CLASSE DAS FUNÇÕES DE INTERAÇÃO COM A MEMÓRIA
***********************************************/

final class Memory {

    private final Integer memorySize = 1024;
    private List <Object> memoryArray;

    // ------------------------- Função que inicia a memória ----------------
    public Memory() {
        memoryArray = new ArrayList<>(memorySize);
        for(int i = 0 ; i < memorySize ; i++){ memoryArray.add(i, null);}
    }

    // ------------------------ Função que adiciona os Objetos do programa --------
    public void setProgram (int sizeProgram, ArrayList<Funcao> programa) {
        for(int i = 0 ; i < sizeProgram ; i++){
            memoryArray.set(i,programa.get(i));
        }
    }

    // -------------- Função que adiciona um valor de Registrador na memória ------------
    public void addRegister (Object value){
        memoryArray.set(memoryArray.indexOf(null), value);
    }
    // --------------- Função que adiciona um objeto direto na memória ---------------
    public void addValue(Object value){
        memoryArray.set(memoryArray.indexOf(null),value);
    }

    //----------------Função que adiciona um objeto avulso em uma Posição da memória --------------
    public void addValueOnPosition(Object value, Integer position){
        memoryArray.set(position,value);
    }

    // --------------- Função que adiciona um Registrador direto em uma posição -------------
    public void setRegisterOnPosition(int position, ObjectRegister object){
        memoryArray.set(position, object);
    }
    
    // ------------ Função que retorna a posição de um registrador ------------------------
    public int findRegister(ObjectRegister object){
        return memoryArray.indexOf(object);
    }

    //------------ Função para retornar o objeto de uma posição --------------
    public ObjectRegister getValue(int position) throws IndexOutOfBoundsException{   
        ObjectRegister object = new ObjectRegister();
        try{
            object = (ObjectRegister) memoryArray.get(position);
        }catch(IndexOutOfBoundsException e){
            //System.out.println("Index fora da Memória");
        }
        return object;
    }

    //------------- Função que pega um objeto avulso da memória pela posição --------
    public Object getObjectOnPosition(Integer position){
        Object value = new Object();
        try{
            value = memoryArray.get(position);
        }catch(IndexOutOfBoundsException e){

        }
        return value;
    }

    //----------- Função para ler o programa -------------------
    public Funcao getProgram(Integer pc){
        return (Funcao) memoryArray.get(pc);
    }


    //------------- Função que atualiza um valor na memória ------------------
    public void updateRegister(Integer location, ObjectRegister newRegister){
        memoryArray.set(location,newRegister);
        
    }

    // --------------- Função que remove o Objeto da Memória por index ------------------------
    public void remove (int index) throws IndexOutOfBoundsException {
        if (memoryArray.size() < index) {
            throw new IndexOutOfBoundsException("Tried to acess ");
        }
        memoryArray.set(index, null);
    }

    // ---------------- Função que remove um objeto especifico --------------------------------
    public void remove(Object object) {
        this.memoryArray.set(this.memoryArray.indexOf(object), null);
    }




    public void createPartition () {
    }

    public void realocate () {

    }

    public List<Object> array() {
        return this.memoryArray;
    }

}