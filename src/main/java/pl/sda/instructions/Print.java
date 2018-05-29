package pl.sda.instructions;

public class Print implements Instruction {
    @Override
    public boolean isApplicable(String cmd) {
        return cmd.startsWith("PRINT ");
    }

    @Override
    public void execute(String cmd) {
        System.out.println(cmd.replaceFirst("PRINT ", ""));
    }
}
