final class CPU {

    private Memory memory;
    private Integer programCounter = 0;
//    private Funcao r0, r1, r2, r3, r4, r5, r6, r7; // registers

    public CPU () {

    }

    public void readInstructions (String [] programa) {
        for (String s : programa) {
            programCounter++;
//            verificar program counter
//            separar comando de r1 r2 k
//            realizar comando
//            verificar program counter
        }
    }

}