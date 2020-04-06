/*****************************
 * TESTE DE FUNÇÕES DA MEMÓRIA
 *****************************/
import java.util.ArrayList;
import java.util.List;

 public class Teste_Memory {
    public static void main(String[] args){
        //Teste de Inicialização da Memória
        Memory memory = new Memory();
        

        // Teste da Função setProgram(precisa de ObjectCreator)
        ArrayList<Funcao> funcoes = new ArrayList<Funcao>(); //vetor com as Funcoes lidas do arquivo
        ObjectCreator programa = new ObjectCreator(); // Inicializando o ObjectCreator de Teste(SHELL)
        programa.readAndCreateFunctions("prog.txt"); //lendo e gravando o programa
        funcoes = programa.getFuncoes(); //salvando o vetor de objetos lidos do programa 

        // for(int i = 0 ; i < funcoes.size() ; i++){
        //     System.out.println("Linha " + i + "= OPCODE: " + funcoes.get(i).getOpcode());
        //     System.out.println("Linha " + i + "= A: " + funcoes.get(i).getA());
        //     System.out.println("Linha " + i + "= K: " + funcoes.get(i).getK());
        //     System.out.println("Linha " + i + "= Rc: " + funcoes.get(i).getRc());
        //     System.out.println("Linha " + i + "= Rd: " + funcoes.get(i).getRd());
        //     System.out.println("Linha " + i + "= Rs: " + funcoes.get(i).getRs());
        // }

        //Teste de salvamento do programa na memória
            memory.setProgram(funcoes.size(), funcoes);
            List<Object> testeMemoria = memory.array(); //pegando a memoria para ver
        for(int i = 0 ; i < testeMemoria.size() ; i++){
            System.out.println("Pos " + i + " : " + testeMemoria.get(i));
        }


    }
}