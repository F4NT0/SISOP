public class App {

    public static void main(String[] args) {
        Memory memory = new Memory();
        memory.remove(3);
        for (Integer i = 1; i <= 1024; i++) {memory.add(i);}
        memory.remove(3);
        System.out.println(memory.array());
        System.out.println(memory.array().size());
    }

}
