// package src;

/**********************************
 * LEITOR DE ARQUIVOS PARA OBJETOS
**********************************/

// Imports Externos
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


// Imports Internos

public class Main {

    // Variáveis Globais

    private static BufferedReader buffer;

    private static String PATH = "prog.txt";

    private static ArrayList<Funcao> funcoes = new ArrayList<Funcao>();

    // Criador dos Objetos
    public static void readAndCreateFunctions(String path) {
        setup();
        try {
            //File myObj = new File(path);
            while (true) {
                String line = buffer.readLine();
                if (line != null) {
                    String split[] = line.split(" ");
                    System.out.println(split.length);

                    // cria objeto Funcao
                    Funcao f = new Funcao();


                    // atribui o OPCODE (split[0]) ao objeto
                    if (split[0].length() != 0) {
                        f.setOPCODE(split[0]);
                    }

                    //adiciona o OBJETO na lista de FUNCOES
                    funcoes.add(f);

                    // if(split[1].length() != 0){
                    // f.setR1(Integer.parseInt(split[1]));
                    // }

                    // if(split[2].length() != 0){
                    // f.setR2(Integer.parseInt(split[2]));
                    // }

                } else {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Main
    public static void main(String[] args) {
        readAndCreateFunctions(PATH);

        System.out.println(funcoes.size());

        for (Funcao funcao : funcoes) {
            System.out.println(funcao);
        }
    }

    public static void setup() {
        Reader reader = new Reader();
        buffer = reader.setupFilePath(PATH);
    }   
}