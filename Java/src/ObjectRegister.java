public class ObjectRegister{
    private String register;
    private Object value;

    public ObjectRegister(){
        this.register = "";
        this.value = 0;
    }

    //--------------------- Getters ---------------------
    public String getRegister(){return register;}
    public Object getValue(){return value;}

    //--------------------- Setters ----------------------
    public void setRegister(String register){this.register = register;}
    public void setValue(Object value){this.value = value;}
}