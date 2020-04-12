/**************************************
* TESTE DAS FUNÇÕES DE ASSEMBLY DA CPU
**************************************/

public class Teste_Functions{
    public static void main(String[] args){
        // Criando um CPU
        Cpu cpu = new Cpu();

        // ---------- Teste de Leitura --------------
        // cpu.loadProgram("prog2.txt");
        // System.out.println("PC: " + cpu.getPc());
        // System.out.println("Size: " + cpu.getProgramSize());
        // cpu.runningProgram(cpu.getProgramSize());
        // System.out.println("PC: " + cpu.getPc());
        // cpu.testMemory();

        // ----------- Teste do JMP ---------------
            // Funcao testeJMP = new Funcao();
            // testeJMP.setOpcode("JMP");
            // testeJMP.setK(2);
            // Integer valuePc = cpu.getPc();
            // System.out.println("PC [ANTES] : " + valuePc);
            // cpu.runningFunctions(testeJMP);
            // Integer newPc = cpu.getPc();
            // System.out.println("PC [DEPOIS] : " + newPc);
        
        //---------- Teste do JMPI e LDI ----------------
            
            // LDI
            // Funcao testeLDI = new Funcao();
            // testeLDI.setOpcode("LDI");
            // testeLDI.setK(7); //defini o valor de R1 como 7
            // testeLDI.setRd("R1");
            // cpu.runningFunctions(testeLDI);
            // Integer valuePc = cpu.getPc();
            // System.out.println("Teste do LDI \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc + "\n");
            // cpu.testMemory();   

            // JMPI
            // Funcao testeJMPI = new Funcao();
            // testeJMPI.setOpcode("JMPI");
            // testeJMPI.setRs("R1");
            // cpu.runningFunctions(testeJMPI);
            // Integer valuePC = cpu.getPc();
            // System.out.println("Teste do JMPI \n");
            // System.out.println("Valor de PC [JMPI]: " + valuePC + "\n");

        //---------- Teste de JMPIG ------------------

            // Primeiro Registrador
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(2);
            // testeRs.setRd("R1");
            // cpu.runningFunctions(testeRs);
            // Integer valuePc1 = cpu.getPc();
            // System.out.println("Rc: \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc1 + "\n");
            // cpu.testMemory(); 

            // Segundo Registrador
            // Funcao testeRc = new Funcao();
            // testeRc.setOpcode("LDI");
            // testeRc.setK(7); //Já que R1 > 0, pc = 7
            // testeRc.setRd("R2");
            // cpu.runningFunctions(testeRc);
            // Integer valuePc2 = cpu.getPc();
            // System.out.println("Teste do LDI \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc2 + "\n");
            // cpu.testMemory();
            
            // JMPIG
            // Funcao testeJMPIG = new Funcao();
            // testeJMPIG.setOpcode("JMPIG");
            // testeJMPIG.setRs("R1");
            // testeJMPIG.setRc("R2");
            // cpu.runningFunctions(testeJMPIG);
            // Integer valuePc3 = cpu.getPc();
            // System.out.println("Valor de PC [APÓS JMPIG]: " + valuePc3 + "\n");
        
        //---------- Teste de JMPIL ------------------
            // Primeiro Registrador
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(-1);
            // testeRs.setRd("R1");
            // cpu.runningFunctions(testeRs);
            // Integer valuePc1 = cpu.getPc();
            // System.out.println("Rc: \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc1 + "\n");
            // cpu.testMemory(); 

            // Segundo Registrador
            // Funcao testeRc = new Funcao();
            // testeRc.setOpcode("LDI");
            // testeRc.setK(7); //Já que R1 < 0, pc = 7
            // testeRc.setRd("R2");
            // cpu.runningFunctions(testeRc);
            // Integer valuePc2 = cpu.getPc();
            // System.out.println("Teste do LDI \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc2 + "\n");
            // cpu.testMemory();

            // JMPIL
            // Funcao testeJMPIL = new Funcao();
            // testeJMPIL.setOpcode("JMPIL");
            // testeJMPIL.setRs("R1");
            // testeJMPIL.setRc("R2");
            // cpu.runningFunctions(testeJMPIL);
            // Integer valuePc3 = cpu.getPc();
            // System.out.println("Valor de PC [APÓS JMPIL]: " + valuePc3 + "\n");


        //----------- Teste de JMPIE --------------------

            // Primeiro Registrador
            Funcao testeRs = new Funcao();
            testeRs.setOpcode("LDI");
            testeRs.setK(0);
            testeRs.setRd("R1");
            cpu.runningFunctions(testeRs);
            Integer valuePc1 = cpu.getPc();
            System.out.println("Rc: \n");
            System.out.println("Valor de PC [APÓS LDI]: " + valuePc1 + "\n");
            cpu.testMemory(); 

            // Segundo Registrador
            Funcao testeRc = new Funcao();
            testeRc.setOpcode("LDI");
            testeRc.setK(7); //Já que R1 = 0, pc = 7
            testeRc.setRd("R2");
            cpu.runningFunctions(testeRc);
            Integer valuePc2 = cpu.getPc();
            System.out.println("Teste do LDI \n");
            System.out.println("Valor de PC [APÓS LDI]: " + valuePc2 + "\n");
            cpu.testMemory();

            // JMPIL
            Funcao testeJMPIE = new Funcao();
            testeJMPIE.setOpcode("JMPIE");
            testeJMPIE.setRs("R1");
            testeJMPIE.setRc("R2");
            cpu.runningFunctions(testeJMPIE);
            Integer valuePc3 = cpu.getPc();
            System.out.println("Valor de PC [APÓS JMPIE]: " + valuePc3 + "\n");

    }
}