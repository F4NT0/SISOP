package system.memory;

/**
--------------------------------------------------------------------------
CRIADOR DE PARTIÇÕES NA MEMÓRIA
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
-------------------------------------------------------------------------
 */

public class Partition {
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