/**************************************
* TESTE DAS FUNÇÕES DE ASSEMBLY DA CPU
**************************************/

public class Teste_Functions{
    public static void main(String[] args){
        // Criando um CPU
        Cpu cpu = new Cpu();
        cpu.loadProgram("prog2.txt");
        cpu.runningProgram();
        System.out.println("PC: " + cpu.getPc());
        cpu.testMemory();




    }
}