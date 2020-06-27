package system.memory;

import java.util.ArrayList;
import java.util.List;

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

    public void getMemory(){
        // tem que por size()
        for(int i = 0 ; i < 20 ; i++){
            System.out.println("Posição " + i + ": " + memoryArray.get(i));
        }
    }

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 MEMORY COMPILANDO!");
    } 

}
