package pl.sda.instructions;

import pl.sda.memory.ProgramMemory;

public class GoTo implements Instruction {

    private ProgramMemory programMemory;

    public GoTo(ProgramMemory programMemory) {
        this.programMemory = programMemory;
    }

    @Override
    public boolean isApplicable(String cmd) {
        return cmd.startsWith("GOTO ");
    }

    @Override
    public void execute(String cmd) {

        String jmpAdress = cmd.substring(cmd.indexOf(' ') + 1);
        int jmpIndex = programMemory.addresses().indexOf(jmpAdress);

        if (jmpIndex >= 0) {
            programMemory.setProgramCounter(jmpIndex);
        }

    }
}
