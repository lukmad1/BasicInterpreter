package pl.sda.memory;


public class ProgramMemory extends Memory {

    private static ProgramMemory instance;
    private Integer programCounter;

    private ProgramMemory() {
    }

    public static ProgramMemory getInstance() {
        if (instance == null) {
            instance = new ProgramMemory();
        }
        return instance;
    }

    public Integer getProgramCounter() {
        return this.programCounter;
    }

    public Integer setProgramCounter(Integer programCounter) {
        return this.programCounter = programCounter;
    }

    public Integer incrementProgramCounter() {
        return ++this.programCounter;
    }


}
