package test.java.com.cal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleCalculatorTest {

    @Test
    public void testAdd() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(1, calculator.subtract(3, 2));
    }
}
