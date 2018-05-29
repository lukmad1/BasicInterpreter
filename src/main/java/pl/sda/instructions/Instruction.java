package pl.sda.instructions;

public interface Instruction {
    boolean isApplicable(String cmd);

    void execute(String cmd);

}
