package system.in_out.reader;

/**
--------------------------------------------------------------------------
CRIADOR DOS OBJETOS FUNÇÕES QUE VEM DO ARQUIVO TEXTO
Criadores: Gabriel Fanto Stundner,Lucas Leal,Luiz Guerra,Matheus Ferreira
-------------------------------------------------------------------------
 */

public class FunctionObjects {
    private String opcode ;
    private String rs;
    private String rc;
    private String rd;
    private Integer k;
    private Integer a;

    public FunctionObjects() {
        this.opcode = "";
        this.rs = "";
        this.rc = "";
        this.rd = "";
        this.k = null;
        this.a = null;
    }

    public String getOpcode() {return opcode;}
    public Integer getK() {return k;}
    public String getRs() {return rs;}
    public String getRc() {return rc;}
    public String getRd(){return rd;}
    public Integer getA(){return a;}
    public void setOpcode(String opcode) {this.opcode = opcode;}
    public void setRs(String rs) {this.rs = rs;}
    public void setRc(String rc) {this.rc = rc;}
    public void setRd(String rd){this.rd = rd;}
    public void setK(Integer k) {this.k = k;}
    public void setA(Integer a){this.a = a;}

    public static void main(String[] args){
        // ÁREA DE TESTES UNITÁRIOS DA CLASSE
        System.out.println("🆗 FUNCTION OBJECTS COMPILANDO!");
    }
}