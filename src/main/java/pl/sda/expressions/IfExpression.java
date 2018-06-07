package pl.sda.expressions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfExpression implements Expression {
    private final String IF_REGEXP = "(IF )(\\w+)(( ?< ?)|( ?> ?)|( ?== ?)|( ?!= ?))(\\w+)( )";
    private Expression expression;

    public IfExpression(Expression expression) {
        this.expression = expression;
    }


    @Override
    public String evaluate(String cmd) {
        cmd = expression.evaluate(cmd);
        Pattern pattern = Pattern.compile(IF_REGEXP);
        Matcher matcher = pattern.matcher(cmd);

        if (matcher.find()) {
            String left = matcher.group(2);
            String middle = matcher.group(3);
            String right = matcher.group(8);
            middle = middle.replaceAll(" ", "");

            int leftValue = Integer.parseInt(left);
            int rightValue = Integer.parseInt(right);
            switch (middle) {
                case ">":
                    if (leftValue > rightValue) {
                        cmd = cmd.replaceFirst(IF_REGEXP, "");
                    }
                    break;
                case "<":
                    if (leftValue < rightValue) {
                        cmd = cmd.replaceFirst(IF_REGEXP, "");
                    }
                    break;
                case "==":
                    if (leftValue == rightValue) {
                        cmd = cmd.replaceFirst(IF_REGEXP, "");
                    }
                    break;
                case "!=":
                    if (leftValue != rightValue) {
                        cmd = cmd.replaceFirst(IF_REGEXP, "");
                    }
                    break;
                default:
                    break;
            }
        }


        return cmd;
    }
}
