package system.memory;

/**
ACESSO Á MEMÓRIA(EM CONSTRUÇÃO)
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
*/

public class MemoryAccess {
    private MemoryManager manager;

    public MemoryAccess(Memory mem) {
        this.manager = new MemoryManager(mem);
    }

    public MemoryManager getManager(){return manager;}
    
   public static void main(String[] args){
     // ÁREA DE TESTES UNITÁRIOS DA CLASSE
     System.out.println("🆗 MEMORY ACCESS COMPILANDO!");
	}  
}
