import expression.exceptions.TripleExpression;
import expression.exceptions.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        try {
            String testStr = "pow10 x * y";

            TripleExpression expression = parser.parse(testStr);
            System.err.println(expression.evaluate(10, 0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
