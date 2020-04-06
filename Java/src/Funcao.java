/**************************************
 * FUNÇÕES PaRa OS OBJETOS DaS FUNÇÕES
 *************************************/

public class Funcao {
    private String opcode ;
    private String rs;
    private String rc;
    private String rd;
    private int k;
    private int a;

    public Funcao() {
        this.opcode = "";
        this.rs = "";
        this.rc = "";
        this.rd = "";
        this.k = -1;
        this.a = -1;
    }

   

    /**
     * @return the opcode
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @return the Register Source
     */
    public String getRs() {
        return rs;
    }

    /**
     * @return the Register Comparable
     */
    public String getRc() {
        return rc;
    }

    /**
     * @return the Register Destiny
     */
    public String getRd(){
        return rd;
    }

    /**
     * @return the Position from an array
     */
    public int getA(){
        return a;
    }


    /**
     * @param opcode the opcode to set
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(String rs) {
        this.rs = rs;
    }

    /**
     * @param rc the rc to set
     */
    public void setRc(String rc) {
        this.rc = rc;
    }

    /**
     * @param rd the rd
     */
    public void setRd(String rd){
        this.rd = rd;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a){
        this.a = a;
    }
}