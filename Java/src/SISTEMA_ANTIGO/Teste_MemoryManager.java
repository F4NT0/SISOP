import java.util.ArrayList;

public class Teste_MemoryManager {
    
    public static void main(String[] args) {
        ArrayList<Funcao> funcoes = new ArrayList<Funcao>(); //vetor com as Funcoes lidas do arquivo
        ObjectCreator programa = new ObjectCreator(); // Inicializando o ObjectCreator de Teste(SHELL)
        programa.readAndCreateFunctions("prog.txt"); //lendo e gravando o programa
        funcoes = programa.getFuncoes(); //salvando o vetor de objetos lidos do programa
        Memory m = new Memory();
        Process p = new Process(funcoes, 1);
        ProcessManager pm = new ProcessManager();
        pm.addProcessToQueue(p);
        MemoryManager mm = new MemoryManager(1);
        mm.addPartition(0, 100);
        pm.selectPartition(m, mm);

        for(int i = mm.getPartitions().get(0).getRB(); i < mm.getPartitions().get(0).getRL(); i++) {
            System.out.println("Pos: " + i + ": " + m.getMemory().get(i));
        }
    }
}