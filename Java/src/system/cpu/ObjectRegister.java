package system.cpu;

public class ObjectRegister{
	private String register;
	private Object value;
	public ObjectRegister(){this.register = "";this.value = 0;}
	public String getRegister(){return register;}
	public Object getValue(){return value;}
	public void setRegister(String reg){register = reg;}
	public void setValue(Object value){this.value = value;}
}