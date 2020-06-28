/*********************************************
* ARQUIVO DE TESTE PARA CI/CD NO NOSSO GITHUB
**********************************************/
import java.util.ArrayList;
public class CI_CD {
    public static void main(String[] args){
        // ArrayList com as Funcoes do Arquivo
        ArrayList<Funcao> funcoes = new ArrayList<Funcao>();
        ArrayList<Funcao> funcoes2 = new ArrayList<Funcao>();
        ArrayList<Funcao> funcoes3 = new ArrayList<Funcao>();
        ArrayList<Funcao> funcoes4 = new ArrayList<Funcao>();

        // ------ Inicialização das Memórias --------------
        Memory m1 = new Memory();
        Memory m2 = new Memory();
        Memory m3 = new Memory();
        Memory m4 = new Memory();
        // ------ Inicialização do Process Manager ------
        ProcessManager pm = new ProcessManager();
        // ------ Inicialização do Memory Manager -------
        MemoryManager mm = new MemoryManager(4);
        // ------ Adição da Partição de memória ---------
        mm.addPartition(0, 255); //Primeira partição
        mm.addPartition(256, 511); //Segunda Partição
        mm.addPartition(512, 767); //Terceira Partição
        mm.addPartition(768, 1023); //Quarta Partição


        // ------ Criação do ObjectCreator e leitura do Arquivo -----
        System.out.println("----------------------------"); 
        System.out.println("LEITURA DO PROGRAMA PROG.TXT");
        System.out.println("----------------------------");
        ObjectCreator programa = new ObjectCreator();
        programa.readAndCreateFunctions("prog.txt");
        funcoes = programa.getFuncoes();
        // ------ Inicialização do Processo -------------
        Process p = new Process(funcoes,1);
        // ------ Adicionando Processo á pilha de Processos ------
        pm.addProcessToQueue(p);

        // ------ Criação do ObjectCreator e leitura do Arquivo -----
        System.out.println("----------------------------"); 
        System.out.println("LEITURA DO PROGRAMA PROG2.TXT");
        System.out.println("----------------------------");
        ObjectCreator programa2 = new ObjectCreator();
        programa2.readAndCreateFunctions("prog2.txt");
        funcoes2 = programa2.getFuncoes();
        // ------ Inicialização do Processo -------------
        Process p2 = new Process(funcoes2,2);
        // ------ Adicionando Processo á pilha de Processos ------
        pm.addProcessToQueue(p2);

        // ------ Criação do ObjectCreator e leitura do Arquivo -----
        System.out.println("----------------------------"); 
        System.out.println("LEITURA DO PROGRAMA TEST.TXT");
        System.out.println("----------------------------");
        ObjectCreator programa3 = new ObjectCreator();
        programa3.readAndCreateFunctions("prog2.txt");
        funcoes3 = programa3.getFuncoes();
        // ------ Inicialização do Processo -------------
        Process p3 = new Process(funcoes3,3);
        // ------ Adicionando Processo á pilha de Processos ------
        pm.addProcessToQueue(p3);

        // ------- Partição 1 ---------
        System.out.println("---------------------------------");
        System.out.println("VISUALIZAÇÃO DA PRIMEIRA PARTIÇÃO");
        System.out.println("---------------------------------");
        pm.selectPartition(m1, mm); //Primeira Partição
        for(int i = mm.getPartitions().get(0).getRB(); i < mm.getPartitions().get(0).getRL(); i++) {
            System.out.println("Pos [" + i + "] : " + m1.getMemory().get(i));
        }

        // ------ Partição 2 ----------
        System.out.println("---------------------------------");
        System.out.println("VISUALIZAÇÃO DA SEGUNDA PARTIÇÃO");
        System.out.println("---------------------------------");
        pm.selectPartition(m2, mm); //Primeira Partição
        for(int i = mm.getPartitions().get(1).getRB(); i < mm.getPartitions().get(1).getRL(); i++) {
            System.out.println("Pos [" + i + "] : " + m2.getMemory().get(i));
        }

        // ------ Partição 3 ----------
        System.out.println("---------------------------------");
        System.out.println("VISUALIZAÇÃO DA TERCEIRA PARTIÇÃO");
        System.out.println("---------------------------------");
        pm.selectPartition(m3, mm); //Primeira Partição
        for(int i = mm.getPartitions().get(2).getRB(); i < mm.getPartitions().get(2).getRL(); i++) {
            System.out.println("Pos [" + i + "] : " + m3.getMemory().get(i));
        }
        

        
    }
}