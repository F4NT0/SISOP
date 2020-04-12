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
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(0);
            // testeRs.setRd("R1");
            // cpu.runningFunctions(testeRs);
            // Integer valuePc1 = cpu.getPc();
            // System.out.println("Rc: \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc1 + "\n");
            // cpu.testMemory(); 

            // Segundo Registrador
            // Funcao testeRc = new Funcao();
            // testeRc.setOpcode("LDI");
            // testeRc.setK(7); //Já que R1 = 0, pc = 7
            // testeRc.setRd("R2");
            // cpu.runningFunctions(testeRc);
            // Integer valuePc2 = cpu.getPc();
            // System.out.println("Teste do LDI \n");
            // System.out.println("Valor de PC [APÓS LDI]: " + valuePc2 + "\n");
            // cpu.testMemory();

            // JMPIL
            // Funcao testeJMPIE = new Funcao();
            // testeJMPIE.setOpcode("JMPIE");
            // testeJMPIE.setRs("R1");
            // testeJMPIE.setRc("R2");
            // cpu.runningFunctions(testeJMPIE);
            // Integer valuePc3 = cpu.getPc();
            // System.out.println("Valor de PC [APÓS JMPIE]: " + valuePc3 + "\n");


        //--------------- Teste de ADDI -------------------
            // Registrador
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(4); //valor que vai ser somado
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);
            // System.out.println("Valor do Registrador: " + testeRd.getK());

            // ADDI
            // Funcao testeADDI = new Funcao();
            // testeADDI.setOpcode("ADDI");
            // testeADDI.setK(4); // Para somar 
            // testeADDI.setRd("R1");
            // cpu.runningFunctions(testeADDI);
            // ObjectRegister getRd = cpu.getValue("R1");
            // System.out.println("Novo valor no Registrador: " + getRd.getValue());

        
        //-------------- Teste de SUBI ----------------------
            // Registrador
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(4); //valor que vai ser subtraido
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);
            // System.out.println("Valor do Registrador: " + testeRd.getK());

            // SUBI
            // Funcao testeSUBI = new Funcao();
            // testeSUBI.setOpcode("SUBI");
            // testeSUBI.setK(3); // Para subtrair 
            // testeSUBI.setRd("R1");
            // cpu.runningFunctions(testeSUBI);
            // ObjectRegister getRd = cpu.getValue("R1");
            // System.out.println("Novo valor no Registrador: " + getRd.getValue());

        //------------- Teste de LDD e STD -----------------
            // // Registrador para STD
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(50);
            // testeRs.setRd("R1");
            // cpu.runningFunctions(testeRs);
            // System.out.println("LDI: \n");
            // // cpu.testMemory();

            // // Valor Adicionado na memória(STD)
            // Funcao testeSTD = new Funcao();
            // testeSTD.setOpcode("STD");
            // testeSTD.setA(4); //pos 4 de memória
            // testeSTD.setRs("R1");
            // cpu.runningFunctions(testeSTD);
            // System.out.println("STD: \n");
            // // cpu.testMemory();

            // // Teste do LDD
            // Funcao testeLDD = new Funcao();
            // testeLDD.setOpcode("LDD");
            // testeLDD.setA(4);
            // testeLDD.setRd("R2");
            // cpu.runningFunctions(testeLDD);
            // System.out.println("LDD: \n");
            // cpu.testMemory();
            // ObjectRegister getR2 = cpu.getValue("R2");
            // System.out.println("Register: " + getR2.getRegister());
            // System.out.println("Value: " + getR2.getValue());


        //------------ Teste de ADD -----------------
            // Primeiro Registrador
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(4); //valor vai ser somado
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);
            // System.out.println("Valor Antigo do R1: " + testeRd.getK());
            
            // Segundo Registrador
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(4);
            // testeRs.setRd("R2");
            // cpu.runningFunctions(testeRs);

            // ADD
            // Funcao testeADD = new Funcao();
            // testeADD.setOpcode("ADD");
            // testeADD.setRd("R1");
            // testeADD.setRs("R2");
            // cpu.runningFunctions(testeADD);

            // Testando
            // ObjectRegister getR1 = cpu.getValue("R1");
            // System.out.println("Valor novo do R1: " + getR1.getValue());

        //-------------- Teste de SUB -----------------------
            // // Primeiro Registrador
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(6); //valor vai ser somado
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);
            // System.out.println("Valor Antigo do R1: " + testeRd.getK());
            
            // // Segundo Registrador
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(4);
            // testeRs.setRd("R2");
            // cpu.runningFunctions(testeRs);

            // // SUB
            // Funcao testeSUB = new Funcao();
            // testeSUB.setOpcode("SUB");
            // testeSUB.setRd("R1");
            // testeSUB.setRs("R2");
            // cpu.runningFunctions(testeSUB);

            // //Testando
            // ObjectRegister getR1 = cpu.getValue("R1");
            // System.out.println("Valor novo do R1: " + getR1.getValue());

        //----------------- Teste de MULT --------------------
            // Primeiro Registrador
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(6); //valor vai ser somado
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);
            // System.out.println("Valor Antigo do R1: " + testeRd.getK());
            
            // Segundo Registrador
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(4);
            // testeRs.setRd("R2");
            // cpu.runningFunctions(testeRs);

            // SUB
            // Funcao testeMULT = new Funcao();
            // testeMULT.setOpcode("MULT");
            // testeMULT.setRd("R1");
            // testeMULT.setRs("R2");
            // cpu.runningFunctions(testeMULT);

            // Testando
            // ObjectRegister getR1 = cpu.getValue("R1");
            // System.out.println("Valor novo do R1: " + getR1.getValue());

        //----------- Teste de LDX -----------------
            // Registrador para STD
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(50);
            // testeRs.setRd("R1");
            // cpu.runningFunctions(testeRs);
            // System.out.println("LDI: \n");
            // cpu.testMemory();

            // Registrador para LDX
            // Funcao testeRsLDX = new Funcao();
            // testeRsLDX.setOpcode("LDI");
            // testeRsLDX.setK(4); //onde está o valor no vetor
            // testeRsLDX.setRd("R2");
            // cpu.runningFunctions(testeRsLDX);

            // Valor Adicionado na memória(STD)
            // Funcao testeSTD = new Funcao();
            // testeSTD.setOpcode("STD");
            // testeSTD.setA(4); //para onde vai o valor
            // testeSTD.setRs("R1");
            // cpu.runningFunctions(testeSTD);
            // System.out.println("STD: \n");
            // cpu.testMemory();

            // LDX
            // Funcao testeLDX = new Funcao();
            // testeLDX.setOpcode("LDX");
            // testeLDX.setRs("R2");
            // testeLDX.setRd("R3"); // o novo registrador que vai ser criado
            // cpu.runningFunctions(testeLDX);

            // Testando
            // System.out.println("\n");
            // cpu.testMemory();
            // ObjectRegister testR3 = cpu.getValue("R3");
            // System.out.println("Registrador: " + testR3.getRegister());
            // System.out.println("Value: " + testR3.getValue());

        //--------------- Teste de STX ----------------------
            // // Primeiro Registrador(para posição no vetor)
            // Funcao testeRd = new Funcao();
            // testeRd.setOpcode("LDI");
            // testeRd.setK(5); // posição para onde vai o valor
            // testeRd.setRd("R1");
            // cpu.runningFunctions(testeRd);

            // // Segundo Registrador(daonde o valor vai ser tirado)
            // Funcao testeRs = new Funcao();
            // testeRs.setOpcode("LDI");
            // testeRs.setK(200); // valor que vai ser pego
            // testeRs.setRd("R2");
            // cpu.runningFunctions(testeRs);

            // // STX
            // Funcao testeSTX = new Funcao();
            // testeSTX.setOpcode("STX");
            // testeSTX.setRd("R1");
            // testeSTX.setRs("R2");
            // cpu.runningFunctions(testeSTX);
            // cpu.testMemory();







    }
}