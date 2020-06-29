package system.process;

public class ProcessControlBlock {
    
    private final Integer id;
    private Integer programCounter;
    private ProgramState programState;
    private ContextData contextData;
    private int partitionID;

    public ProcessControlBlock (Integer id) {
        this.id = id;
        this.programCounter = 0;
        this.programState = ProgramState.NEW;
        this.contextData = new ContextData();
    }

    public ProcessControlBlock (Integer id, ContextData contextData) {
        this.id = id;
        this.programCounter = 0;
        this.programState = ProgramState.NEW;
        this.contextData = contextData;
    }

    public Integer getId() {return id;}

    public Integer getProgramCounter() {return programCounter;}

    public ProgramState getProgramState() {return programState;}

    public ContextData getContextData() {return contextData;}

    /**
     * Salva o PC vindo do Status do Processo
     * @param pc
     * @throws IllegalArgumentException
     */
    public void setProgramCounter(Integer pc) throws IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("Cannot set negative program counter");
        }
        this.programCounter = pc;
    }

    public void setContextData(ContextData contextData) {this.contextData = contextData;}

    public void setProgramState(ProgramState programState) {this.programState = programState;}

    public void setPartitionID(int id) {this.partitionID = id;}

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 PROCESS CONTROL BLOCK COMPILANDO!");
    } 

}