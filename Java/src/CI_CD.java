
public class CI_CD {
    public static void main(String[] args){
        Cpu cpu = new Cpu();
        System.out.println("----------------------------");
        System.out.println("LEITURA DO PROGRAMA PROG.TXT");
        System.out.println("----------------------------");
        System.out.println("\n");
        cpu.loadProgram("prog.txt");
        System.out.println("PC: " + cpu.getPc());
        System.out.println("Size: " + cpu.getProgramSize());
        cpu.runningProgram(cpu.getProgramSize());
        System.out.println("PC: " + cpu.getPc());
        cpu.testMemory();
        System.out.println("VALORES ARMAZENADOS NOS REGISTRADORES");
        String finalValues = cpu.finalValues();
        System.out.println(finalValues);
        System.out.println("\n");
        System.out.println("----------------------------");
        System.out.println("LEITURA DO PROGRAMA PROG2.TXT");
        System.out.println("----------------------------");
        System.out.println("\n");
        cpu.loadProgram("prog2.txt");
        System.out.println("PC: " + cpu.getPc());
        System.out.println("Size: " + cpu.getProgramSize());
        cpu.runningProgram(cpu.getProgramSize());
        System.out.println("PC: " + cpu.getPc());
        cpu.testMemory();
        System.out.println("VALORES ARMAZENADOS NOS REGISTRADORES");
        String finalValues2 = cpu.finalValues();
        System.out.println(finalValues2);
        System.out.println("\n");
        System.out.println("----------------------------");
        System.out.println("LEITURA DO PROGRAMA TEST.TXT");
        System.out.println("----------------------------");
        System.out.println("\n");
        cpu.loadProgram("test.txt");
        System.out.println("PC: " + cpu.getPc());
        System.out.println("Size: " + cpu.getProgramSize());
        cpu.runningProgram(cpu.getProgramSize());
        System.out.println("PC: " + cpu.getPc());
        cpu.testMemory();
        System.out.println("VALORES ARMAZENADOS NOS REGISTRADORES");
        String finalValues3 = cpu.finalValues();
        System.out.println(finalValues3);
    }