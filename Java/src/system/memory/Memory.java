package system.memory;

import java.util.ArrayList;
import java.util.List;
import system.cpu.ObjectRegister;


public class Memory {
    private final Integer memorySize = 1024;
    private List <Object> memoryArray;
    
    public Memory() {
        memoryArray = new ArrayList<>();
        for(int i = 0; i < memorySize; i++) { memoryArray.add(i, null); }
    }

    /**
     * Pega um Objeto de uma Posição da Memória
     * @param index 
     * @return Object
     * @throws IndexOutOfBoundsException
     */
    public Object getFromIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        return memoryArray.get(index);
    }

    /**
     * Adiciona o Valor numa Posição da Memória
     * @param index
     * @param object
     * @return Object
     * @throws IndexOutOfBoundsException
     */
    public Object setIndexElement(Integer index, Object object) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        Object original = memoryArray.get(index);
        memoryArray.set(index, object);
        return original;
    }

    /**
     * Deleta o Valor que está no Index 
     * @param index
     * @return Object
     * @throws IndexOutOfBoundsException
     */
    public Object deleteIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        Object original = memoryArray.get(index);
        memoryArray.set(index, null);
        return original;
    }

    /**
     * Pega o tamanho da memória
     * @return
     */
    public Integer size() {
        return memorySize;
    }

    /**
     * Testa o Status 
     */
    public void getMemory(){
        // tem que por size()
        for(int i = 0 ; i < 20 ; i++){
            System.out.println("Posição " + i + ": " + memoryArray.get(i));
        }
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
     * Adiciona um Objeto Integer/Char em uma Posição na Memória
     * @param value
     * @param position
     */
    public void addValueOnPosition(Object value, Integer position){
        memoryArray.set(position,value);
    }

    /**
     * Adiciona o Objeto Registrador na Memória
     * @param value
     */
    public void addRegister (Object value){
        memoryArray.set(memoryArray.indexOf(null), value);
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
     * Adiciona um Objeto Registrador direto em uma Posição de Memória
     * @param position
     * @param object
     */
    public void setRegisterOnPosition(int position, ObjectRegister object){
        memoryArray.set(position, object);
    }

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
     * Atualiza um Objeto Registrador da Memória
     * @param location
     * @param newRegister
     */
    public void updateRegister(Integer location, ObjectRegister newRegister){
        memoryArray.set(location,newRegister);
        
    }




    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 MEMORY COMPILANDO!");
    } 

}
