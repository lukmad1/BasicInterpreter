package pl.sda.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumExpression extends MathExpression {
    private final String SUM_REGEXP = "(\\d+)( ?\\+ ?)(\\d+)";

    public SumExpression(Expression expression) {
        super(expression);
        setREGEXP(SUM_REGEXP);
    }

    @Override
    protected String handeledSign() {
        return " ?\\+ ?";
    }

    @Override
    protected String calculate(String left, String right) {
        return "" + (Integer.parseInt(left) + Integer.parseInt(right));
    }
}
