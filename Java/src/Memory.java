import java.util.List;
import java.util.ArrayList;

final class Memory <T> {

    private final Integer memorySize = 1024;
    private List <T> memoryArray;
    private Integer programCounter;



    public Memory() {
        memoryArray = new ArrayList<>(memorySize);
        programCounter = 0;
    }

    public void set (int index, T value) {
        memoryArray.set(index, value);
    }

    public void add (T value) {
        memoryArray.add(value);
    }

    public void remove (int index) {
        memoryArray.remove(index);
    }

    public void createPartition () {
    }

    public void realocate () {

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}