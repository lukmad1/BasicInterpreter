package pl.sda.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubExpression extends MathExpression {
    private final String SUB_REGEXP = "(\\d+)( ?- ?)(\\d+)";

    public SubExpression(Expression expression) {
        super(expression);
        setREGEXP(SUB_REGEXP);
    }

    @Override
    protected String handeledSign() {
        return " ?- ?";
    }

    @Override
    protected String calculate(String left, String right) {
        return "" + (Integer.parseInt(left) - Integer.parseInt(right));
    }
}
