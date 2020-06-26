package system.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    /*
        TODO: set, get, delete
        Fazer com que tu pegue, mude, delete algo de uma paginação
        Isso vai ser usado? Se sim, implementar
        Talvez não seja necessário no primeiro momento, mas necessário mais pra frente. Não implementar se não for necessário
    */

public class MemoryManager {

    private class Partition {
        private int id;
        private int rb;
        private int rl;
        private boolean available;
        private int size;
        public Partition(int id, int rb, int rl) {
            this.id = id;
            this.rb = rb;
            this.rl = rl;
            this.size = rl - rb;
            this.available = true;
        }

        public int getRB() {return this.rb;}
        public int getRL() {return this.rl;}
        public boolean isAvailable() {return this.available;}
        public void lockPartition() {this.available = false;}
        public int getSize() {return this.size;}
    }


    private Memory memory;
    private List<Partition> partitions;

    public MemoryManager() {
        memory = new Memory();
        this.partitions = new LinkedList<>();
    }

    public boolean isPartitionAvailable(Partition p) {
        return p.isAvailable();
    }
    
    public void addPartition(int id, int rb, int rl) {
        Partition p = new Partition(id,rb,rl);
        this.partitions.add(p);
    }

    //Provavelmente vai precisar ser mudado esse método
    public Partition findPartition(int registerBase) {
        for(Partition p : partitions) {
            if(p.getRB() == registerBase)
                return p;
        }
        throw new IllegalArgumentException("Essa partição não existe.");
    }

    public Partition findBestPartition(Process p) {
        Partition aux = partitions.get(0);
        // int best = aux.getSize() - p.getFunctions().size();
        for(Partition pa : partitions) {
            // if( (pa.getSize() - p.getFunctions().size()) < best) {
                // best = pa.getSize() - p.getFunctions().size();
                // aux = pa;
            // }
        }
        return aux;
    }

    public void selectPartition(Process p) {
        for(Partition pa : partitions) {
            if(pa.isAvailable()) 
                malloc(pa, p);
        }
    }

    public void malloc(Partition pa, Process p) {
        //Fazer método para achar a melhor partição para o processo
        // for(int i = 0; i < p.getFunctions(); i++) {
            // memory.setIndexElement(pa.getRB() + i, p.getFunctions().get(i));
        // }
        pa.lockPartition();
        // p.setProgramState(ProgramState.READY);
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
        System.out.println("╔══════════════════════╗");
		System.out.println("║MEMORY MANAGER RODANDO║");
		System.out.println("╚══════════════════════╝");
    } 
    
}
