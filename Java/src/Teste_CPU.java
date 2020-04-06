/**************************
 * TESTE DAS FUNÇÕES DA CPU
 **************************/

public class Teste_CPU{
    public static void main(String[] args){
        // Funções que não necessitam da Memória
        Cpu cpu = new Cpu();
        
        // ----------------- GETTERS INICIAIS ------------
        System.out.println("GETTERS INICIAIS");
        System.out.println("R0: " + cpu.getR0());
        System.out.println("R1: " + cpu.getR1());
        System.out.println("R2: " + cpu.getR2());
        System.out.println("R3: " + cpu.getR3());
        System.out.println("R4: " + cpu.getR4());
        System.out.println("R5: " + cpu.getR5());
        System.out.println("R6: " + cpu.getR6());
        System.out.println("R7: " + cpu.getR7());
        System.out.println("PC: " + cpu.getPc());

        

        

    }
}