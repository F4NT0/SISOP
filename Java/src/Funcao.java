/**************************************
 * FUNÇÕES PaRa OS OBJETOS DaS FUNÇÕES
 *************************************/

public class Funcao {
    private String opcode ;
    private String rs;
    private String rc;
    private String rd;
    private Integer k;
    private Integer a;

    public Funcao() {
        this.opcode = "";
        this.rs = "";
        this.rc = "";
        this.rd = "";
        this.k = null;
        this.a = null;
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
    public Integer getK() {
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
    public Integer getA(){
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
    public void setK(Integer k) {
        this.k = k;
    }

    /**
     * @param a the a to set
     */
    public void setA(Integer a){
        this.a = a;
    }
}