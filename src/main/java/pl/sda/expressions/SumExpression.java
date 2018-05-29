package pl.sda.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumExpression extends ExpressionDecorator {
    private final String SUM_REGEXP = "(\\d+)( ?\\+ ?)(\\d+)";

    public SumExpression(Expression expression) {
        super(expression);
    }


    @Override
    public String evaluate(String cmd) {
        Pattern pattern = Pattern.compile(SUM_REGEXP);
        Matcher matcher = pattern.matcher(cmd);
        if (matcher.find()) {
            String value = "" + (Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3)));
            cmd = cmd.replaceFirst(SUM_REGEXP, value);
        }


        return cmd;
    }
}
