/**************************
 * TESTE DAS FUNÇÕES DA CPU
 **************************/

public class Teste_CPU{
    public static void main(String[] args){
        // Funções que não necessitam da Memória
        Cpu cpu = new Cpu();
        
        // ----------------- GETTERS INICIAIS ------------
        // System.out.println("GETTERS INICIAIS");
        // System.out.println("R0: " + cpu.getR0());
        // System.out.println("R1: " + cpu.getR1());
        // System.out.println("R2: " + cpu.getR2());
        // System.out.println("R3: " + cpu.getR3());
        // System.out.println("R4: " + cpu.getR4());
        // System.out.println("R5: " + cpu.getR5());
        // System.out.println("R6: " + cpu.getR6());
        // System.out.println("R7: " + cpu.getR7());
        // System.out.println("PC: " + cpu.getPc());

        /**
         * Teste para ver se está sendo armazenado o registrador na memória
         */
        // cpu.setRegValue(1, "R1");
        // System.out.println("Posição salva do R1: " + cpu.getR1());
        // cpu.testMemory();

        /**
         * Teste para ver se o programa está sendo armazenado na memória
         */
        // cpu.loadProgram("prog.txt");
        // cpu.testMemory();

        /**
         * Teste para salvar um Registrador em um local especifico
         */
        // ObjectRegister newTest = new ObjectRegister();
        // int pos = 3;
        // cpu.setRegValuePosition(newTest, pos);
        // cpu.testMemory();

        /**
         * Teste da Função de pegar o objeto do registrador
         */
        // cpu.setRegValue(1, "R1");
        // System.out.println("Posição salva do R1: " + cpu.getR1());
        // ObjectRegister testeObjeto = cpu.getValue("R1");
        // System.out.println("Registrador: " + testeObjeto.getRegister());
        // System.out.println("Valor: " + testeObjeto.getValue());

        /**
         * Teste da Função que retorna um valor completo somente pela posição
         */
        // cpu.setRegValue(35, "R7");
        // System.out.println("Posição salva do R7: " + cpu.getR7());
        // ObjectRegister pegarObjeto = cpu.getValueDirect(cpu.getR7());
        // System.out.println("Registrador: " + pegarObjeto.getRegister());
        // System.out.println("Valor: " + pegarObjeto.getValue());

        /**
         * Teste de Função de Atualização de um Registrador
         */
        // cpu.setRegValue(35, "R7"); //antigo objeto
        // ObjectRegister auxiliar = cpu.getValue("R7");
        // System.out.println("Registrador Antigo: " + auxiliar.getRegister());
        // System.out.println("Valor Antigo: " + auxiliar.getValue());
        // auxiliar.setRegister("R7");
        // auxiliar.setValue('C');
        // cpu.updateRegister(auxiliar);
        // //ObjectRegister auxiliar2 = cpu.getValueDirect(0);
        // ObjectRegister auxiliar2 = cpu.getValue("R7");
        // System.out.println("Registrador Novo: " + auxiliar2.getRegister());
        // System.err.println("Valor: " + auxiliar2.getValue());

    }
}