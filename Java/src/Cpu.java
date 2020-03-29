class Cpu {
    private final int tamMemoria = 1024;
    private int[] memoria = new int[tamMemoria];
    private int progCount = 0;

    private int R1, R2, R3, R4, R5, R6, R7;
    //ou
    private int[] registradores =  new int[8];

    public Cpu() {
        
    }
}