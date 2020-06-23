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

    public Object getFromIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        return memoryArray.get(index);
    }

    public Object setIndexElement(Integer index, Object object) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        Object original = memoryArray.get(index);
        memoryArray.set(index, object);
        return original;
    }

    public Object deleteIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= memorySize) {
            throw new IndexOutOfBoundsException("Illegal access ocurred.");
        }
        Object original = memoryArray.get(index);
        memoryArray.set(index, null);
        return original;
    }

    public Integer size() {
        return memorySize;
    }
    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 MEMORY COMPILANDO!");
    } 

}
