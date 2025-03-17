import model.Calculator;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        int result = Calculator.add(1, 2);
        assertEquals(3, result);
    }


    @Test
    public void testEvaluate() {
        String expression = "3 * 2 - 1 + 7 / 2";
        int result = Calculator.evaluate(expression);
        assertEquals(6, result);
    }
}
