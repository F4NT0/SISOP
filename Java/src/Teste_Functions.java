/**************************************
* TESTE DAS FUNÇÕES DE ASSEMBLY DA CPU
**************************************/

public class Teste_Functions{
    public static void main(String[] args){
        // Criando um CPU
        Cpu cpu = new Cpu();
        cpu.loadProgram("prog2.txt");
        System.out.println("PC: " + cpu.getPc());
        System.out.println("Size: " + cpu.getProgramSize());
        cpu.runningProgram(cpu.getProgramSize());
        System.out.println("PC: " + cpu.getPc());
        cpu.testMemory();




    }
}