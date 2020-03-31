import java.nio.file.Files;
import java.nio.file.Paths;

public class Teste {
    public static void main(String[] args) {
        int[] memoria = new int [100];
        SystemFunctions sf = new SystemFunctions();
        // String FILE_PATCH = "programas\\prog.txt";
        int x = 0;
        // for(int i : memoria) {
        //     System.out.println(x + ": " + i);
        //     x++;
        // }
        System.out.println();
        try {
            while(true) {
                String line = Files.readAllLines(Paths.get("Java\\src\\programas\\prog.txt")).get(sf.getPC());
                if(line != null) {
                    String[] split = line.split(" ");


                    if(split[0].equals("STOP")) {
                        break;
                    }    
                    if(split.length == 2) {
                        sf.exec(split[0], split[1]);
                        // System.out.println("Linha: " + sf.getPC());
                    } else {    
                        sf.exec(split[0], split[1], split[2], memoria);
                        // System.out.println("Linha: " + sf.getPC());
                    }    
                    // System.out.println(sf.getPC());
                    // System.out.println("Entrou em loop");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        for(int i = 0; i <= 99; i++) {
            System.out.println(x + ": " + memoria[i]);
            x++;
        }
        System.out.println();
        System.out.println("Registradores: ");
        sf.getRegisterValues();
        // System.out.print("End");
    }

}