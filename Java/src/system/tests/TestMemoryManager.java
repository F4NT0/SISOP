package system.tests;
import system.memory.*;
import system.process.Process;
import system.in_out.reader.*;

public class TestMemoryManager {
   public static void main(String[] args){
    System.out.println("\n🔰 TESTE DAS FUNÇÕES DO GERENTE DE MEMÓRIA\n");

    Memory memory = new Memory();
    MemoryManager mm = new MemoryManager(memory);

    // Testando uma Partição
    //mm.addPartition(0, 0, 20);
    //Partition p = mm.findPartition(0);
    
    // Criando 4 Partições - entrada: id da particao,inicio da memória,fim da memória
    mm.addPartition(0, 0, 19);
    //mm.addPartition(1, 20, 39);
    //mm.addPartition(2, 40, 59);
    //mm.addPartition(3, 60, 79);

    //Criando um Processo e o programa

    // Criação dos Objetos Função
    ProgramReader functions = new ProgramReader();
    functions.readAndCreateFunctions("prog.txt");

    // Criando um Processo - necessita as Funções e o ID do PCB que vai ser criado
    Process process1 = new Process(functions.getFuncoes(),0);

    // Selecionando a Partição que o Processo vai rodar
    System.out.println("Partição Criada? " + mm.selectPartition(process1));

    // Imprimindo todas as Partições
    //mm.printPartitions();

    // Imprimindo particao antes e depois de deletar
    //mm.printPartition(mm.findPartition(0));
    //mm.deleteProgram(mm.findPartition(0));
    //mm.printPartition(mm.findPartition(0));


}
}