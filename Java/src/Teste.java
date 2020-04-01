import java.util.ArrayList;

/**
 * ARQUIVO DE TESTE DA LEITURA DO ARQUIVO E AS FUNÇÕES
 */

 public class Teste{
    // Chamada da CPU
    Cpu cpu = new Cpu();

    // Lendo o programa
    public void programTest(){
        cpu.loadProgram("prog.txt");
        cpu.testMemory();
    }
    
    public static void main(String[] args){
        Teste teste = new Teste();
        teste.programTest();
    }
 }
