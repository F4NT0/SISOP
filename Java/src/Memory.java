import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.ArrayList;

final class Memory {

    private final Integer memorySize = 1024;
    private List <Object> memoryArray;
    private Integer programCounter;

    public Memory() {
        memoryArray = new ArrayList<>(memorySize);
        for (int i = 0; i < memorySize; i++) { memoryArray.set(i, null); }
        programCounter = 0;
    }

    public void set (int index, Object value) {
        memoryArray.set(index, value);
    }

    public void add (Object value) throws OutOfMemoryError {
        if (memoryArray.size() >= memorySize) {
            throw new OutOfMemoryError("Tried to add Object " + value + " while memory is full.");
        }
        memoryArray.add(value);
    }


    public void remove (int index) throws IndexOutOfBoundsException {
        if (memoryArray.size() < index) {
            throw new IndexOutOfBoundsException("Tried to acess ");
        }
        memoryArray.remove(index);
    }

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