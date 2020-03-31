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


    // ------------------ Função para ler e construir os Objetos --------------------------
    public void readAndCreateFunctions(String path) {
        setup(path);
        try {
            //File myObj = new File(path);
            while (true) {
                String line = buffer.readLine();
                if (line != null) {
                    String split[] = line.split(" ");

                    // cria objeto Funcao
                    Funcao f = new Funcao();


                    // Atribui o OPCODE (split[0]) ao Objeto
                    if (split[0].length() != 0) {
                        f.setOpcode(split[0]);
                    }

                    // Atribui o Rs e Rc ao Objeto (JMPIG JMPIL JMPIE)
                    if ((split[1].charAt(0) == 'R') && (split[2].charAt(0) == 'R')){
                        f.setRs(split[1]);
                        f.setRc(split[2]);  
                    }

                    // Atribui a Posição A ao Objeto (LDD STD)
                    if(split[1].charAt(0) == '['){
                        int valueA = Integer.parseInt(String.valueOf(split[1].charAt(1)));
                        f.setA(valueA);
                    }

                    if(split[2].charAt(0) == '['){
                        int valueA = Integer.parseInt(String.valueOf(split[2].charAt(1)));
                        f.setA(valueA);
                    }

                    // Atribui o k ao Objeto (JMP)
                    if(isNumeric(split[1])){
                        int valueK = Integer.parseInt(String.valueOf(split[1]));
                        f.setA(valueK);
                    }

                    // Atribui o k ao Objeto
                    if(isNumeric(split[2])){
                        int valueK = Integer.parseInt(String.valueOf(split[2]));
                        f.setK(valueK);
                    }

                    // Atribui o Rd e o k ao Objeto (ADDI SUBI ANDI ORI LDI )
                    if((split[1].charAt(0) == 'R') && (isNumeric(split[2]))){
                        f.setRd(split[1]);
                        int valueK = Integer.parseInt(String.valueOf(split[2]));
                        f.setK(valueK);
                    }

                    // Atribui o Rd se ele for uma posição do Vetor (LDX STX)
                    if((split[1].charAt(0) == '[') && (split[1].charAt(1) == 'R')){
                        f.setRd(split[1]);
                        f.setRs(split[2]);
                    }

                    if((split[2].charAt(0) == '[') && (split[2].charAt(1) == 'R')){
                        f.setRd(split[1]);
                        f.setRs(split[2]);
                    }

                    // Atribui o Rd Rs se as Funções forem (ADD SUB MULT AND OR)
                    if((split[0] == "AND") || (split[0] == "SUB") || (split[0] == "MULT") || (split[0] == "AND") || (split[0] == "OR")){
                        f.setRd(split[1]);
                        f.setRs(split[2]);
                    }



                    //adiciona o OBJETO na lista de FUNCOES
                    funcoes.add(f);


                } else {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    

    // ------------------------ Função para definir o arquivo --------------------------------
    public void setup(String path) {
        Reader reader = new Reader();
        buffer = reader.setupFilePath(path);
    }

    // ------------------------- Função para ler o ArrayList Externamente ---------------------
    public ArrayList<Funcao> getFuncoes(){
        return funcoes;
    }

    // ------------------------- Função para verificar se a String é um Numero -----------------
    public boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}