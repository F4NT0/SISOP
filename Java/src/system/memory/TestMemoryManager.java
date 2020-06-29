package system.memory;

public class TestMemoryManager {
   public static void main(String[] args){
    System.out.println("\n🔰 TESTE DAS FUNÇÕES DA MEMÓRIA\n");

    Memory memory = new Memory();
    MemoryManager mm = new MemoryManager(memory);

    // Testando uma Partição
    //    mm.addPartition(0, 0, 20);
    //    Partition p = mm.findPartition(0);
    //    System.out.println("Inicio Particao " + p.getID() + " : " + p.getRegisterBase());
    //    System.out.println("Fim Particao " + p.getID() + " : " + p.getRegisterLimit());
    //    System.out.println("Particao " + p.getID() + " Disponivel? : " + p.isAvailable());
    //    p.lockPartition();
    //    System.out.println("Particao " + p.getID() + " Disponivel? : " + p.isAvailable());
    //    System.out.println("Tamanho da Partição: " + p.getSize());
    

}
}