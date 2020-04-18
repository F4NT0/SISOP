import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemoryManager {

    private List<Partition> partitions;
    private final int partition_limit;

    public MemoryManager(int limit) {
        this.partitions = new ArrayList<>();
        this.partition_limit = limit;
    }


    public int getLimit() {return this.partition_limit;}
    public List<Partition> getPartitions() {return this.partitions;}

    public void addPartition(int register_base, int register_limit, int program_size, int size) {
        Partition p = new Partition(register_base, register_limit, program_size, size);
        partitions.add(p);
    }


    public void realocate(List <Funcao> program, Partition p) {
        for(Funcao f : program) {
            switch(f.getOpcode()) {
                case "JMP": f.setK(p.getRB() + f.getK());break;
                // case "JMPI": f.setRs(p.get); criar metodo para verificar se index esta dentro do programa
                // case "JMPIG":
                // case "JMPIL":
                // case "JMPIE":
                // case "LDD": f.getA()
            }
        }
    }
    
    // public int findNewIndex(int oldIndex) {

    // }


    public void validPos(int pos, List <Funcao> program, Partition p)  {
        if(!(pos <= program.size())) {
            throw new IllegalAccessError("Acesso de posição fora do programa.");
        } else {
            pos = pos + p.getRB();
        }
    }

    // public void changeIndex(int index, Funcao f, Partition p) {
    //     if(validIndex(index, p)) {

    //     }
    // }

    // public void validIndex(int index, List <Funcao> program, Partition p) {
    //     if(!(index <= ))
    // }

    private void clean(Partition p, Memory m) {
        for(int i = p.getRB(); i <= p.getRL() - 1; i++) {
            if(!(m.getObject(i).equals(null))) {
                m.setValue(null, i);
            }
        }
    }
}