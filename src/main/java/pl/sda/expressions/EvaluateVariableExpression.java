package pl.sda.expressions;

import pl.sda.memory.DataMemory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluateVariableExpression implements Expression {

    private DataMemory dataMemory;

    public EvaluateVariableExpression(DataMemory dataMemory) {
        this.dataMemory = dataMemory;
    }

    @Override
    public String evaluate(String cmd) {

        Pattern pattern = Pattern.compile("(\\$)(\\w+)");
        Matcher matcher = pattern.matcher(cmd);
        if (matcher.find()) {
            String value = dataMemory.get(matcher.group(2));
            cmd = cmd.replaceAll("\\$\\w+", value);
        }
        return cmd;
    }
}
