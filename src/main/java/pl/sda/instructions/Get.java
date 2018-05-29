package pl.sda.instructions;

import pl.sda.memory.DataMemory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Get implements Instruction {
    private DataMemory dataMemory;
    private final String GET_REGEXP = "(GET )(\\w+)";

    public Get(DataMemory dataMemory) {
        this.dataMemory = dataMemory;
    }


    @Override
    public boolean isApplicable(String cmd) {
        return cmd.matches(GET_REGEXP);
    }

    @Override
    public void execute(String cmd) {
        Pattern pattern = Pattern.compile(GET_REGEXP);
        Matcher matcher = pattern.matcher(cmd);

        if (matcher.find()) {
            System.out.println(this.dataMemory.get(matcher.group(2)));
        }
    }
}
