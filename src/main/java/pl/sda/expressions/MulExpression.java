package pl.sda.expressions;


public class MulExpression extends MathExpression {
    private final String SUB_REGEXP = "(\\d+)( ?\\* ?)(\\d+)";

    public MulExpression(Expression expression) {
        super(expression);
        setREGEXP(SUB_REGEXP);
    }


    @Override
    protected String handeledSign() {
        return " ?\\* ?";
    }

    @Override
    protected String calculate(String left, String right) {
        return "" + (Integer.parseInt(left) * Integer.parseInt(right));
    }
}


