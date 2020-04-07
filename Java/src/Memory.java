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
        int pos = memoryArray.indexOf(null);
        memoryArray.set(pos, value);
    }

    // --------------- Função que adiciona um Registrador direto em uma posição -------------
    public void setRegisterOnPosition(int position, ObjectRegister object){
        memoryArray.set(position, object);
    }
    
    // ------------ Função que retorna a posição de um registrador ------------------------
    public int findRegister(ObjectRegister object){
        int position = memoryArray.indexOf(object);
        return position;
    }

    //------------ Função para retornar o objeto de uma posição --------------
    public ObjectRegister getValue(int position){   
        ObjectRegister object = (ObjectRegister) memoryArray.get(position);
        return object;
    }


    //------------- Função que atualiza um valor na memória ------------------
    public void updateRegister(ObjectRegister object) throws IndexOutOfBoundsException{
        int position = memoryArray.indexOf(object);
        try{
            if(position == -1){
                addRegister(object);
            }
            memoryArray.set(position,object);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Posicao não permitida");
        }
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

    public List<Object> array() {
        return this.memoryArray;
    }

}