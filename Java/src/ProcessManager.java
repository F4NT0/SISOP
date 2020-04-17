import java.util.LinkedList;
import java.util.Queue;

public class ProcessManager {

    private Queue <Process> queue;
    private Process currentProcess;
    private static Integer MAX_PC_DIVISOR = 10;

    public ProcessManager() {
        this.queue = new LinkedList<>();
    }

    public Process getNextProcess () {
        return queue.remove();
    }

    

    public Boolean isEmpty () {
        return queue.isEmpty() || currentProcess == null;
    }



//    get free/occupied partition
//    compare
//    stop
//    memory method contact

}
