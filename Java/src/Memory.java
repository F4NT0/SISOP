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
        for (int i = 0; i < memorySize; i++) { memoryArray.set(i, null); }
    }

    // ------------------------ Função que adiciona os Objetos do programa --------
    public void setProgram (int sizeProgram, ArrayList<Funcao> programa) {
        for(int i = 0 ; i < sizeProgram ; i++){
            memoryArray.add(programa.get(i));
        }
    }

    // -------------- Função que adiciona um valor de Registrador na memória ------------
    public void addRegister (Object value) throws OutOfMemoryError {
        if (memoryArray.size() >= memorySize) {
            throw new OutOfMemoryError("Tried to add Object " + value + " while memory is full.");
        }
        memoryArray.add(value);
    }

    // --------------- Função que adiciona um Registrador direto em uma posição -------------
    public void setRegisterOnPosition(int position, ObjectRegister object) throws OutOfMemoryError{
        if (memoryArray.size() >= memorySize) {
            throw new OutOfMemoryError("Tried to add Object " + object + " while memory is full.");
        }
        memoryArray.add(position, object);
    }
    
    // ------------ Função que retorna a posição de um registrador ------------------------
    public int findRegister(ObjectRegister object){
        int position = memoryArray.lastIndexOf(object.getRegister());
        return position;
    }

    //------------ Função para retornar o objeto de uma posição --------------
    public ObjectRegister getValue(int position){   
        ObjectRegister object = (ObjectRegister) memoryArray.get(position);
        return object;
    }


    //------------- Função que atualiza um valor na memória ------------------
    public void updateRegister(ObjectRegister object){
        int position = memoryArray.lastIndexOf(object.getRegister());
        if(position == -1){
            addRegister(object);
        }
        memoryArray.add(position,object);
    }

    // --------------- Função que remove o Objeto da Memória por index ------------------------
    public void remove (int index) throws IndexOutOfBoundsException {
        if (memoryArray.size() < index) {
            throw new IndexOutOfBoundsException("Tried to acess ");
        }
        memoryArray.remove(index);
    }

    // ---------------- Função que remove um objeto especifico --------------------------------
    public void remove(Object object) {
        this.memoryArray.remove(object);
    }




    public void createPartition () {
    }

    public void realocate () {

    }

    public List array() {
        return this.memoryArray;
    }

}