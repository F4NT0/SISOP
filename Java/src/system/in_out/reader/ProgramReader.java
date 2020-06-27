package system.in_out.reader;

// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Reader{
    private String FILE_PATH = "";
    public BufferedReader setupFilePath(String filename) {
        try {
            File currentDirFile = new File("");
            String separator = System.getProperty("file.separator");
          
            FILE_PATH = currentDirFile.getAbsolutePath()+separator+"programas" +separator + filename;

            System.out.println("Arquivo Lido: " + FILE_PATH);

            FileReader filereader = new FileReader(FILE_PATH);
            BufferedReader buffer = new BufferedReader(filereader);
            return buffer;
        } catch (FileNotFoundException e) {
            System.out.println("Erro na leitura do arquivo");
        }
        return null;
    }
}

public class ProgramReader{

    private static BufferedReader buffer;
    private static ArrayList<FunctionObjects> funcoes = new ArrayList<FunctionObjects>();

    public void setup(String path) {
        Reader reader = new Reader();
        buffer = reader.setupFilePath(path);
    }

    public ArrayList<FunctionObjects> getFuncoes(){return funcoes;}
    public Integer getProgramSize(){return funcoes.size();}

    public boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void eraseOldReading(){
        for(int i = 0 ; i < funcoes.size() ; i++){
            funcoes.removeAll(funcoes);
        }
    }
   
    public void readAndCreateFunctions(String path) {
        setup(path);
        try {
            eraseOldReading();
            while (true) {
                String line = buffer.readLine();
                if (line != null) {
                    
                    String split[] = line.split(" ");

                     // cria objeto FunctionObjects
                         FunctionObjects f = new FunctionObjects();

                    if(split[0].equals("STOP")){
                        String stop = split[0];
                        f.setOpcode(stop);
                        funcoes.add(f);
                        continue;
                    }
                     
                    // Atribui o OPCODE (split[0]) ao Objeto
                    if (split[0].length() != 0) {
                        f.setOpcode(split[0]);
                    }

                    // JMP
                    if( (split[0].equals("JMP")) && (isNumeric(split[1]))){
                        Integer valueK = Integer.parseInt(String.valueOf(split[1]));
                        f.setA(valueK);
                    }


                    // JMPI
                    if((split[0].equals("JMPI")) && (split[1].charAt(0) == 'R') && (split[2] == null)){
                        f.setRs(split[1]);
                    }

                    // Atribui o Rs e Rc ao Objeto (JMPIG JMPIL JMPIE)
                    if ((split[0].substring(0, 3).equals("JMP")) &&(split[1].charAt(0) == 'R') && (split[2].charAt(0) == 'R')){
                        f.setRs(split[1]);
                            f.setRc(split[2]);  
                        f.setRc(split[2]);  
                            f.setRc(split[2]);  
                        f.setRc(split[2]);  
                            f.setRc(split[2]);  
                    }

                    // STD
                    if((split[0].equals("STD")) && (split[1].charAt(0) == '[') && (split[2].charAt(0) == 'R')){
                        f.setRs(split[2]);
                        Integer valueA = Integer.parseInt(String.valueOf(split[1].substring(1, 3)));
                        f.setA(valueA);
                    }

                    // LDD
                    if((split[0].equals("LDD")) &&(split[1].charAt(0) == 'R') && (split[2].charAt(0) == '[')){
                        f.setRd(split[1]);
                        Integer valueA = Integer.parseInt(String.valueOf(split[2].substring(1, 3)));
                        f.setA(valueA);
                    }


                    // Atribui o k ao Objeto
                    if(isNumeric(split[2])){
                        Integer valueK = Integer.parseInt(String.valueOf(split[2]));
                        f.setK(valueK);
                    }

                    // // Atribui o Rd e o k ao Objeto (ADDI SUBI ANDI ORI LDI )
                    if((split[1].charAt(0) == 'R') && (isNumeric(split[2]))){
                        f.setRd(split[1]);
                        Integer valueK = Integer.parseInt(String.valueOf(split[2]));
                        f.setK(valueK);
                    }

                    // // Atribui o Rd se ele for uma posição do Vetor (LDX STX)
                    if(split[0].equals("STX")){
                        f.setRd(split[1].substring(1,3));
                        f.setRs(split[2]);
                    }

                    if((split[0].equals("LDX")) && (split[2].charAt(0) == '[') && (split[2].charAt(1) == 'R')){
                        f.setRd(split[1]);
                        f.setRs(split[2].substring(1,2));
                    }

                    // // Atribui o Rd Rs se as Funções forem (ADD SUB MULT AND OR)
                    if((split[0].equals("ADD")) || (split[0].equals("SUB")| (split[0].equals("MULT")) || (split[0].equals("AND")) || (split[0].equals("OR")))){
                        f.setRd(split[1]);
                        f.setRs(split[2]);
                    }


                    // Para testar os valores salvos
                    // System.out.println("OPCODE: " +  f.getOpcode());
                    // System.out.println("K: " + f.getK());
                    // System.out.println("A: " +  f.getA());
                    // System.out.println("Rs: " + f.getRs());
                    // System.out.println("Rc: " + f.getRc());
                    // System.out.println("Rd: " + f.getRd());

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

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 PROGRAM READER COMPILANDO!");
        //ArrayList<FunctionObjects> funcoes = new ArrayList<FunctionObjects>(); //vetor com as Funcoes lidas do arquivo
        //ProgramReader programa = new ProgramReader(); // Inicializando o ProgramReader de Teste(SHELL)
        //programa.readAndCreateFunctions("prog.txt"); //lendo e gravando o programa
        //funcoes = programa.getFuncoes(); //salvando o vetor de objetos lidos do program

        //for(int i = 0 ; i < funcoes.size() ; i++){
        //  System.out.println("Linha " + i + "= OPCODE: " + funcoes.get(i).getOpcode());
        //   System.out.println("Linha " + i + "= A: " + funcoes.get(i).getA());
        //   System.out.println("Linha " + i + "= K: " + funcoes.get(i).getK());
        //   System.out.println("Linha " + i + "= Rc: " + funcoes.get(i).getRc());
        //   System.out.println("Linha " + i + "= Rd: " + funcoes.get(i).getRd());
        //   System.out.println("Linha " + i + "= Rs: " + funcoes.get(i).getRs());
        //}
    }

}