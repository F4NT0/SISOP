/**************************************
* TESTE DAS FUNÇÕES DE ASSEMBLY DA CPU
**************************************/

public class Teste_Functions{
    public static void main(String[] args){
        // Criando um CPU
        Cpu cpu = new Cpu();
        cpu.loadProgram("prog.txt");
        System.out.println("Rodando Programa");
        cpu.runningProgram();
        System.out.println("PC: " + cpu.getPc());




    }
}