import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemoryManager {

    private List<Partition> partitions;
    private final int partition_limit;

    public MemoryManager(int limit) {
        this.partition_limit = limit;
        this.partitions = new ArrayList<>(partition_limit);
    }


    public int getLimit() {return this.partition_limit;}
    public List<Partition> getPartitions() {return this.partitions;}

    public void addPartition(int register_base, int register_limit) {
        for(Partition p : partitions) {
            if(register_base >= p.getRB() || register_base <= p.getRL()) {
                throw new InvalidParameterException("Valores passados já são usados em outra partição.");
            }
        }
        Partition p = new Partition(register_base, register_limit);
        partitions.add(p);
    }

    //Precisa arrumar as classes de criar objetos para funcionar
    public void realocate(Process p, Partition pa, Cpu c) {
        for(Funcao f : p.getFunctions()) {
            switch(f.getOpcode()) {
                case "JMP": f.setK(x(f.getK(),p.getFunctions(),pa));
                case "LDD": f.setA(y(f.getA(),p.getFunctions(),pa));
                case "STD": f.setA(y(f.getA(),p.getFunctions(),pa));
            }
        }
        malloc(p, c.getMemory(), pa);
    }
    
    // public int findNewIndex(int oldIndex) {

    // }

    //Caso 1: Valor é uma referencia para dentro do programa    
    public int x(int pos, List <Funcao> program, Partition p)  {
        int pc = program.size() + p .getRB() + 1;
        if(!(pos > pc)) {
            throw new IllegalAccessError("Acesso de posição fora do programa.");
        } else {
            return pos = pos + p.getRB() + 1;
        }
    }

    //Caso 2: Valor é uma referencia para alguma posição da memoria
    public int y(int pos, List <Funcao> program, Partition p) {
        int pc = program.size() + p.getRB() + 1;
        if(!(pos > pc && pos < p.getRL())) {
            return pos = pc + 1;
        }
        return pos;
    }

    private void cleanPartiton(Partition p, Memory m) {
        for(int i = p.getRB(); i <= p.getRL() - 1; i++) {
            if(!(m.getObject(i).equals(null))) {
                m.setValue(null, i);
            }
        }
    }

    public void malloc(Process p, Memory m, Partition pa) {
        m.setValue(p.getPCB(), pa.getRB());
        for(int i = 0; i < p.getFunctions().size(); i++) {
            m.add(p.getFunctions().get(i), pa.getRB() + 1 + i);
            i++;
        }
        pa.setPartitionLock();
    }

    public Partition getProcessPartition(int identifier, Memory m) {
        // Partition result;
        for(Partition p : partitions) {
            ProcessControlBlock pcb =  (ProcessControlBlock) m.getObject(p.getRB());
            if(pcb.getID() == identifier) 
                return p;
            
        }
        return null;
    }
}