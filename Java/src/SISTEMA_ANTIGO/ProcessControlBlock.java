class ProcessControlBlock {

    class ContextData {

        private Integer r1, r2, r3, r4, r5, r6, r7, r8;

        public Integer getR1() {
            return r1;
        }
        public void setR1(Integer r1) {
            this.r1 = r1;
        }
        public Integer getR2() {
            return r2;
        }
        public void setR2(Integer r2) {
            this.r2 = r2;
        }
        public Integer getR3() {
            return r3;
        }
        public void setR3(Integer r3) {
            this.r3 = r3;
        }
        public Integer getR4() {
            return r4;
        }
        public void setR4(Integer r4) {
            this.r4 = r4;
        }
        public Integer getR5() {
            return r5;
        }
        public void setR5(Integer r5) {
            this.r5 = r5;
        }
        public Integer getR6() {
            return r6;
        }
        public void setR6(Integer r6) {
            this.r6 = r6;
        }
        public Integer getR7() {
            return r7;
        }
        public void setR7(Integer r7) {
            this.r7 = r7;
        }
        public Integer getR8() {
            return r8;
        }
        public void setR8(Integer r8) {
            this.r8 = r8;
        }
    }

    enum ProgramState {
        RUNNING, NOT_RUNNING, ENDED
    }

    private final Integer id;
    private Integer programCounter;
    private ProgramState programState;
    private ContextData contextData;

    public ProcessControlBlock (Integer id) {
        this.id = id;
        this.programState = ProgramState.NOT_RUNNING;
        this.programCounter = 0;
    }

    public Integer addStepToProgramCounter () {
        return ++this.programCounter;
    }

    public void setProgramCounter(Integer programCounter) {
        this.programCounter = programCounter;
    }
    public void setContextData(ContextData contextData) {
        this.contextData = contextData;
    }
    public void setProgramState(ProgramState programState) {
        this.programState = programState;
    }

    public Integer getId() {
        return id;
    }
    public Integer getProgramCounter() {
        return programCounter;
    }
    public ProgramState getProgramState() {
        return programState;
    }
    public ContextData getContextData() {
        return contextData;
    }

    public int getID() {return this.id;}

}
