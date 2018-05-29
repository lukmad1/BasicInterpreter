package pl.sda.instructions;

import pl.sda.memory.DataMemory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Set implements Instruction {
    private DataMemory dataMemory;
    private final String SET_REGEXP = "(SET )(\\w+)( ?= ?)(\\w+)";
    public Set(DataMemory dataMemory) {
        this.dataMemory = dataMemory;
    }


    @Override
    public boolean isApplicable(String cmd) {
        return cmd.matches(SET_REGEXP);
    }

    @Override
    public void execute(String cmd) {
        Pattern pattern = Pattern.compile(SET_REGEXP);
        Matcher matcher = pattern.matcher(cmd);

        if (matcher.find()) {
            dataMemory.put(matcher.group(2), matcher.group(4));
        }
    }
}
