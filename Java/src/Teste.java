import java.util.ArrayList;

/**
 * ARQUIVO DE TESTE DA LEITURA DO ARQUIVO E AS FUNÇÕES
 */

 public class Teste{

    // Pegando o vetor de Objetos
    public ArrayList<Funcao> createObjects(){
        ObjectCreator objects = new ObjectCreator();
        objects.readAndCreateFunctions("prog.txt");
        return objects.getFuncoes(); 
    }

    public void print(ArrayList<Funcao> vetor){
        System.out.println("Imprimindo o Primeiro Objeto");
        System.out.println(vetor.get(1).getOpcode());
        System.out.println(vetor.get(1).getK());
        System.out.println(vetor.get(1).getRs());
        System.out.println(vetor.get(1).getRd());
        System.out.println(vetor.get(1).getRc());
    }

    public static void main(String[] args){
        // Criando o vetor vindo da leitura do arquivo
        ArrayList<Funcao> vetorArquivo = new ArrayList<>();
        Teste verify = new Teste();
        vetorArquivo = verify.createObjects();

        // Testando as Funções
        SystemFunctions testeFunc = new SystemFunctions();

        for(int i = 0 ; i < vetorArquivo.size() ; i++){
            if(vetorArquivo.get(i).getOpcode().equals("JMP")){
                testeFunc.execJMP(vetorArquivo.get(i).getOpcode(), vetorArquivo.get(i).getK());                
            }
            if(vetorArquivo.get(i).getOpcode().equals("JMPI")){
                testeFunc.execJMPI(vetorArquivo.get(i).getOpcode(),vetorArquivo.get(i).getRs());
            }
            
        }
        
    }
 }
