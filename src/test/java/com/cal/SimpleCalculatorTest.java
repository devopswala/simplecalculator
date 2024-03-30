package com.cal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleCalculatorTest {

    private SimpleCalculator calculator = new SimpleCalculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }
}
