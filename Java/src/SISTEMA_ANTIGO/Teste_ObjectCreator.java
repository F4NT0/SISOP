/****************************************
 * ARQUIVO DE TESTE DA LEITURA DO ARQUIVO
 *****************************************/

import java.util.ArrayList;

public class Teste_ObjectCreator {
    public static void main(String[] args){
        ArrayList<Funcao> funcoes = new ArrayList<Funcao>(); //vetor com as Funcoes lidas do arquivo
        ObjectCreator programa = new ObjectCreator(); // Inicializando o ObjectCreator de Teste(SHELL)
        programa.readAndCreateFunctions("prog.txt"); //lendo e gravando o programa
        funcoes = programa.getFuncoes(); //salvando o vetor de objetos lidos do programa

        for(int i = 0 ; i < funcoes.size() ; i++){
            System.out.println("Linha " + i + "= OPCODE: " + funcoes.get(i).getOpcode());
            System.out.println("Linha " + i + "= A: " + funcoes.get(i).getA());
            System.out.println("Linha " + i + "= K: " + funcoes.get(i).getK());
            System.out.println("Linha " + i + "= Rc: " + funcoes.get(i).getRc());
            System.out.println("Linha " + i + "= Rd: " + funcoes.get(i).getRd());
            System.out.println("Linha " + i + "= Rs: " + funcoes.get(i).getRs());
        }
    }
}