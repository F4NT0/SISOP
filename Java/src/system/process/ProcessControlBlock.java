package system.process;

public class ProcessControlBlock {
    
    private final Integer id;
    private Integer programCounter;
    private ProgramState programState;
    private ContextData contextData;
    //private int partitionID;

    // Construtores
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
     * Salva o Program Counter vindo do Control Unit
     * @param pc
     * @throws IllegalArgumentException
     */
    public void setProgramCounter(Integer pc) throws IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("Cannot set negative program counter");
        }
        this.programCounter = pc;
    }

    /**
     * Define os valores das posições dos Registradores do Control Unit
     * @param contextData
     */
    public void setContextData(ContextData contextData) {this.contextData = contextData;}

    /**
     * Define o Estado do Programa, onde NEW é recém adicionado,
     * READY pronto para rodar,RUNNING é rodando, BLOCKED é bloqueado
     * e EXIT é finalizado
     * @param programState
     */
    public void setProgramState(ProgramState programState) {this.programState = programState;}

    //public void setPartitionID(int id) {this.partitionID = id;}

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
		System.out.println("🆗 PROCESS CONTROL BLOCK COMPILANDO!");
    } 

}