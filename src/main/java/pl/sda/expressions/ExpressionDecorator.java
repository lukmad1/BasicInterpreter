package pl.sda.expressions;

public abstract class ExpressionDecorator implements Expression {
    private Expression expression;

    public ExpressionDecorator(Expression expression) {
        this.expression = expression;
    }
}
