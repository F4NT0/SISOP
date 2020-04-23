import java.util.ArrayList;
import java.util.List;

public class Partition {

    private int rb;
    private int rl;
    // private int program_size;
    private int size;
    private boolean free;

    public Partition(int rb, int rl) {
        this.rb = rb;
        this.rl = rl;
        // this.program_size = program_size;
        this.free = true;
        this.size = rl - rb;
    }

    public int getRB() {
        return this.rb;
    }

    public void setRB(int rb) {
        this.rb = rb;
    }

    public int getRL() {
        return this.rl;
    }

    public void setRL(int rl) {
        this.rl = rl;
    }

    public int getSize() {return this.size;}

    public void setPartitionLock() {this.free = false;}
    public void setPartitionUnlock() {this.free = true;}

    public boolean isAvailable() {return this.free ? true : false;}

    // public int getProgramSize() {return this.program_size;}

    public void malloc(Process p, Memory m) {
        int pos = 0;
        for(int i = rb; i <= p.getProgram().size(); i++) {
            m.add(p.getProgram().get(pos), i);
            pos++;
        }
        setPartitionLock();
    }
}