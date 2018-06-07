package pl.sda.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MathExpression implements Expression {
    private Expression expression;
    private String REGEXP;

    public MathExpression(Expression expression) {
        this.expression = expression;
    }

    public void setREGEXP(String REGEXP) {
        this.REGEXP = REGEXP;
    }

    public String evaluate(String cmd) {
        cmd = expression.evaluate(cmd);
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(cmd);

        while (matcher.find() && matcher.group(2).matches(handeledSign())) {
            cmd = matcher.replaceFirst(calculate(matcher.group(1), matcher.group(3)));
            matcher = pattern.matcher(cmd);
        }

        return cmd;
    }

    protected abstract String handeledSign();

    protected abstract String calculate(String left, String right);


}
