
/*****************************
 * TESTE DE FUNÇÕES DA MEMÓRIA
 *****************************/
import java.util.ArrayList;
//import java.util.List;

 public class Teste_Memory {
    public static void main(String[] args){
        //Teste de Inicialização da Memória
        Memory memory = new Memory();
        

        /**
         * Teste da Função setProgram(precisa de ObjectCreator)
         */
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

        /**
         * Teste de salvamento do programa na memória
         */
        memory.setProgram(funcoes.size(), funcoes);
        //List<Object> testeMemoria = memory.array(); //pegando a memoria para ver
        //for(int i = 0 ; i < testeMemoria.size() ; i++){
            //System.out.println("Pos " + i + " : " + testeMemoria.get(i));
            // Como pegar o dado da Memória
            // Funcao teste = (Funcao) testeMemoria.get(i);
            // System.out.println(teste.getOpcode());
        //}
        
        /*
         * Testando para adicionar um Registrador na memória
         */
       
        ObjectRegister registradorTeste = new ObjectRegister();
        registradorTeste.setRegister("R1");
        registradorTeste.setValue(1);
        memory.addRegister(registradorTeste); //add o objeto de registrador
        //List<Object> testeMemDoRegistrador = memory.array();
        // for(int i = 0 ; i < testeMemDoRegistrador.size() ; i++){
        //     System.out.println("Pos " + i + " : " + testeMemoria.get(i));
        // }

        /**
         * Função para adicionar um registrador em uma posição especifica
         */
        ObjectRegister registrador2 = new ObjectRegister();
        registrador2.setRegister("R2");
        registrador2.setValue(2);
        int pos = 15;
        memory.setRegisterOnPosition(pos, registrador2);
        // List<Object> testeMem2 = memory.array();
        // for(int i = 0 ; i < testeMem2.size() ; i++){
        //     System.out.println("Pos " + i + " : " + testeMem2.get(i));
        // }

        /**
         * Teste da Função que procura e retorna a pos de um registrador
         */
        // int position = memory.findRegister(registrador2);
        // int position2 = memory.findRegister(registradorTeste);
        // System.out.println("Posição de R1: " + position2);
        // System.out.println("Posição de R2: " + position);

        /**
         * Teste de Função para retornar um Objeto de uma Posição
         */
        // ObjectRegister regDaPos = memory.getValue(14); // R1
        // System.out.println("Qual o Registrador: " + regDaPos.getRegister());
        // System.out.println("Valor no Registrador: " + regDaPos.getValue());

        /**
         * Teste de Update de um registrador
         */
        ObjectRegister objectValue = new ObjectRegister();
        objectValue.setRegister("R3");
        objectValue.setValue(3);
        memory.updateRegister(objectValue);
        // List<Object> novoNaMemoria = memory.array();
        // for(int i = 0 ; i < novoNaMemoria.size() ; i++){System.out.println("Pos " + i + ": " + novoNaMemoria.get(i));}
        // ObjectRegister exemploSalvo = memory.getValue(16);
        // System.out.println("Registrador: " + exemploSalvo.getRegister());
        // System.out.println("Valor: " + exemploSalvo.getValue());
        
        // Alterando um Registrador já existente
        // System.out.println("Tipo anterior do Registrador: " + registrador2.getRegister());
        // System.out.println("Seu Valor: " + registrador2.getValue());
        // registrador2.setRegister("R4");
        // registrador2.setValue(4);
        // memory.updateRegister(registrador2); //salvo na pos 15
        // ObjectRegister pegandoRegistrador = memory.getValue(15);
        // System.out.println("Registrador Agora: " + pegandoRegistrador.getRegister());
        // System.out.println("Valor Agora: " + pegandoRegistrador.getValue());

        /**
         * Teste da Função de Remover de uma posição
         */
        // Irei testar de remover o novo registrador na pos 16
        //List<Object> removeTeste = memory.array();
        //for(int i = 0 ; i < removeTeste.size() ; i++){System.out.println("Pos " + i + ": " + removeTeste.get(i));}
        //memory.remove(16);
        //for(int i = 0 ; i < removeTeste.size() ; i++){System.out.println("Pos " + i + ": " + removeTeste.get(i));}
        
        /**
         * Teste da Função de Remover um Objeto
         */
        //Vamos remover o novo objeto(objectValue)
        //List<Object> removeTeste = memory.array();
        //for(int i = 0 ; i < removeTeste.size() ; i++){System.out.println("Pos " + i + ": " + removeTeste.get(i));}
        //memory.remove(objectValue); //esta na pos 16
        //for(int i = 0 ; i < removeTeste.size() ; i++){System.out.println("Pos " + i + ": " + removeTeste.get(i));}
        



    }
}