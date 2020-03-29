/**************************************
 * FUNÇÕES PARA OS OBJETOS DAS FUNÇÕES
 *************************************/

public class Funcao {
    private String OPCODE ;
    private int R1;
    private int R2;
    private int k;

    public Funcao() {
        this.OPCODE = "";
        this.R2 = 0;
        this.R1 = 0;
        this.k = 0;
    }

   

    /**
     * @return the oPCODE
     */
    public String getOPCODE() {
        return OPCODE;
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @return the r1
     */
    public int getR1() {
        return R1;
    }

    /**
     * @return the r2
     */
    public int getR2() {
        return R2;
    }


    /**
     * @param oPCODE the oPCODE to set
     */
    public void setOPCODE(String oPCODE) {
        this.OPCODE = oPCODE;
    }

    /**
     * @param r1 the r1 to set
     */
    public void setR1(int r1) {
        R1 = r1;
    }

    /**
     * @param r2 the r2 to set
     */
    public void setR2(int r2) {
        R2 = r2;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
}