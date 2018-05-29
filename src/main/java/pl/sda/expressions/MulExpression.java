package pl.sda.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MulExpression extends ExpressionDecorator{
    private final String SUB_REGEXP = "(\\d+)( ?\\* ?)(\\d+)";

    public MulExpression(Expression expression) {
        super(expression);
    }


    @Override
    public String evaluate(String cmd) {
        Pattern pattern = Pattern.compile(SUB_REGEXP);
        Matcher matcher = pattern.matcher(cmd);
        if (matcher.find()) {
            String value = "" + (Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(3)));
            cmd = cmd.replaceFirst(SUB_REGEXP, value);
        }
        return cmd;
    }
}


