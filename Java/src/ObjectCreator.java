/**********************************
 * LEITOR DE ARQUIVOS PARA OBJETOS
**********************************/

// Imports Externos
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectCreator {

    // Variáveis Globais

    private static BufferedReader buffer;

    private static ArrayList<Funcao> funcoes = new ArrayList<Funcao>();

    // Criador dos Objetos
    public void readAndCreateFunctions(String path) {
        setup(path);
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

    
    // Setup do caminho
    public void setup(String path) {
        Reader reader = new Reader();
        buffer = reader.setupFilePath(path);
    }

    // Para chamar o Arraylist externamente
    public ArrayList<Funcao> getFuncoes(){
        return funcoes;
    }
}