package system.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import system.process.Process;
import system.process.ProgramState;

    /*
        TODO: set, get, delete
        Fazer com que tu pegue, mude, delete algo de uma paginação
        Isso vai ser usado? Se sim, implementar
        Talvez não seja necessário no primeiro momento, mas necessário mais pra frente. Não implementar se não for necessário
    */

public class MemoryManager {

    private class Partition {
        private int id;
        private int registerBase;
        private int registerLimit;
        private boolean available;
        private int size;
        public Partition(int id, int registerBase, int registerLimit) {
            this.id = id;
            this.registerBase = registerBase;
            this.registerLimit = registerLimit;
            this.size = registerLimit - registerBase;
            this.available = true;
        }

        public int getRegisterBase() {return this.registerBase;}
        public int getRegisterLimit() {return this.registerLimit;}
        public boolean isAvailable() {return this.available;}
        public void lockPartition() {this.available = false;}
        public int getSize() {return this.size;}
        public int getID() {return this.id;}
    }


    private Memory memory;
    private List<Partition> partitions;

    public MemoryManager() {
        memory = new Memory();
        this.partitions = new LinkedList<>();
    }

    /**
     * Verifica se a Partição está disponivel
     * @param p
     * @return boolean
     */
    public boolean isPartitionAvailable(Partition p) {
        return p.isAvailable();
    }
    
    /**
     * Adiciona uma Partição
     * @param id
     * @param registerBase
     * @param registerLimit
     */
    public void addPartition(int id, int registerBase, int registerLimit) {
        Partition p = new Partition(id,registerBase,registerLimit);
        this.partitions.add(p);
    }

    //Provavelmente vai precisar ser mudado esse método
    public Partition findPartition(int id) throws IllegalArgumentException {
        for(Partition p : partitions) {
            if(p.getID() == id)
                return p;
        }
        throw new IllegalArgumentException("Essa partição não existe.");
    }

    // public Partition findBestPartition(Process p) {
    //     Partition aux = partitions.get(0);
    //     // int best = aux.getSize() - p.getFunctions().size();
    //     for(Partition pa : partitions) {
    //         // if( (pa.getSize() - p.getFunctions().size()) < best) {
    //             // best = pa.getSize() - p.getFunctions().size();
    //             // aux = pa;
    //         // }
    //     }
    //     return aux;
    // }
    

    public boolean selectPartition(Process p) {
        for(Partition pa : partitions) {
            if(pa.isAvailable()) {
                malloc(pa, p);
                return true;
            }            
        }
        return false;
    }

    public void malloc(Partition pa, Process p) {
        for(int i = 0; i < p.getFunctions().size() ; i++) {
            memory.setIndexElement(pa.getRegisterBase() + i, p.getFunctions().get(i));
        }
        pa.lockPartition();
        p.getPCB().setProgramState(ProgramState.READY);
        p.getPCB().setPartitionID(pa.getID());
    }

    //Falta printar resultado do programa.
    public void deleteProgram(Partition pa) {
        for(int i = pa.getRegisterBase(); i <= pa.getRegisterLimit() - 1; i++) {
            if(!(memory.getFromIndex(i).equals(null))) 
                memory.setIndexElement(i, null);
        }
    }

    private Integer append(Object object) throws OutOfMemoryError {
        for (Integer i = 0; i < memory.size(); i++) {
            if (memory.getFromIndex(i) == null) {
                memory.setIndexElement(i, object);
                return i;
            }
        }
        throw new OutOfMemoryError("Memory is full");
    }

    // Esses próximos métodos provavelmente não vão ser usados assim.
    // CONSIDERAR O TODO NO INÍCIO DESSE ARQUIVO!

    // private Object set(Integer index, Object object) {
    //     return memory.setIndexElement(index, object);
    // }

    // private Object getFromIndex(Integer index) {
    //     return memory.getFromIndex(index);
    // }

    // private Object deleteIndex(Integer index) {
    //     return memory.deleteIndex(index);
    // }

    

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 MEMORY MANAGER COMPILANDO!");
    } 
    
}
