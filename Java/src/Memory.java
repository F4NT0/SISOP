/***********************************************
* CLASSE DAS FUNÇÕES DE INTERAÇÃO COM A MEMÓRIA
***********************************************/

import java.util.List;
import java.util.ArrayList;

final class Memory {

    private final Integer memorySize = 1024;
    private List <Object> memoryArray;



    public Memory() {
        memoryArray = new ArrayList<>(memorySize);
        for(int i = 0 ; i < memorySize ; i++){ memoryArray.add(i, null);}
    }

    /**--------------------------------------------
    * ADICIONANDO E RECUPERANDO OBJETOS DA MEMÓRIA
    ---------------------------------------------*/

    /**
     * Adiciona os Objetos Funcao criados no ObjectCreator na Memória
     * @param sizeProgram
     * @param programa
     */
    public void setProgram (int sizeProgram, ArrayList<Funcao> programa) {
        for(int i = 0 ; i < sizeProgram ; i++){
            memoryArray.set(i,programa.get(i));
        }
    }

    /**
     * Adiciona o Objeto Registrador na Memória
     * @param value
     */
    public void addRegister (Object value){
        memoryArray.set(memoryArray.indexOf(null), value);
    }
    
    /**
     * Adiciona um Objeto Integer/Char direto na memória
     * @param value
     */
    public void addValue(Object value){
        memoryArray.set(memoryArray.indexOf(null),value);
    }

    /**
     * Adiciona um Objeto Integer/Char em uma Posição na Memória
     * @param value
     * @param position
     */
    public void addValueOnPosition(Object value, Integer position){
        memoryArray.set(position,value);
    }

    /**
     * Adiciona um Objeto Registrador direto em uma Posição de Memória
     * @param position
     * @param object
     */
    public void setRegisterOnPosition(int position, ObjectRegister object){
        memoryArray.set(position, object);
    }
    
    /**
     * Retorna a Posição de um Objeto Registrador da Memória
     * @param object
     * @return Integer
     */
    public int findRegister(ObjectRegister object){
        return memoryArray.indexOf(object);
    }

    /**
     * Retorna o Objeto de uma Posição da Memória
     * @param position
     * @return object ObjectRegister
     * @throws IndexOutOfBoundsException
     */
    public ObjectRegister getValue(int position) throws IndexOutOfBoundsException{   
        ObjectRegister object = new ObjectRegister();
        try{
            object = (ObjectRegister) memoryArray.get(position);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index fora da Memória");
        }
        return object;
    }

    /**
     * Retorna um Objeto Integer/Char pela posição de Memória
     * @param position
     * @return object Object
     */
    public Object getObjectOnPosition(Integer position){
        Object object = new Object();
        try{
            object = memoryArray.get(position);
        }catch(IndexOutOfBoundsException e){

        }
        return object;
    }
    
    /**
     * Retorna um Objeto Funcao pelo valor do Program Counter da CPU
     * @param pc
     * @return object Funcao
     */
    public Funcao getProgram(Integer pc){
        return (Funcao) memoryArray.get(pc);
    }

    /**
     * Atualiza um Objeto Registrador da Memória
     * @param location
     * @param newRegister
     */
    public void updateRegister(Integer location, ObjectRegister newRegister){
        memoryArray.set(location,newRegister);
        
    }

    /**--------------------------------------
    * FUNÇÕES QUE REMOVEM E LIMPAM A MEMÓRIA
    ----------------------------------------*/

    /**
     * Remove um Objeto pela sua posição
     * @param position
     * @throws IndexOutOfBoundsException
     */
    public void remove (int position) throws IndexOutOfBoundsException {
        if (memoryArray.size() < position) {
            throw new IndexOutOfBoundsException("Tried to acess ");
        }
        memoryArray.set(position,null);
    }

    /**
     * Remove um Objeto Específico
     * @param object
     */
    public void remove(Object object) {
        this.memoryArray.set(this.memoryArray.indexOf(object), null);
    }


    public void add(Object value, int index) {
        memoryArray.set(index, value);
    }

    public Object getObject(int index) {
        return memoryArray.get(index);
    }

    public void setValue(Object value, int index) {
        memoryArray.set(index, value);
    }

    public void createPartition () {
    }

    public void realocate () {

    }

    public void alocateProgram(Process program, Partition p ) {

    }

    public List<Object> array() {
        return this.memoryArray;
    }

}