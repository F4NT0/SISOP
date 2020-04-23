
public class ProcessControlBlock {

    private enum State {
        NOT_RUNNING,
        RUNNING
    }

    private class ContextData {
        Integer R0,R1,R2,R3,R4,R5,R6,R7;

        public ContextData() {
            this.R0 = 0;
            this.R1 = 0;
            this.R2 = 0;
            this.R3 = 0;
            this.R4 = 0;
            this.R5 = 0;
            this.R6 = 0;
            this.R7 = 0;
        }
        //Get
        public int getR0() { return this.R0;}
        public int getR1() { return this.R1;}
        public int getR2() { return this.R2;}
        public int getR3() { return this.R3;}
        public int getR4() { return this.R4;}
        public int getR5() { return this.R5;}
        public int getR6() { return this.R6;}
        public int getR7() { return this.R7;}
        //Set
        public void setR0(int r) {this.R0 = r;}
        public void setR1(int r) {this.R1 = r;}
        public void setR2(int r) {this.R2 = r;}
        public void setR3(int r) {this.R3 = r;}
        public void setR4(int r) {this.R4 = r;}
        public void setR5(int r) {this.R5 = r;}
        public void setR6(int r) {this.R6 = r;}
        public void setR7(int r) {this.R7 = r;}
    }

    private final int identifier;
    private State state;
    private int program_counter;
    private ContextData context;
    
    public ProcessControlBlock(int id, int program_counter) {
        this.identifier = id;
        this.state = State.NOT_RUNNING;
        this.program_counter = program_counter;
        this.context = new ContextData();
    }

    public int getID() {return this.identifier;}
    public int getPC() {return this.program_counter;}


    public void switchState() {
        if(state.equals(State.NOT_RUNNING))
            state = State.RUNNING;
        else
            state = State.NOT_RUNNING;
    }

}
