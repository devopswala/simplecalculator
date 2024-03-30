package com.cal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.com.cal.SimpleCalculator;

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

    @Test
    public void add_ShouldReturnSum_WhenBothPositive() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void add_ShouldReturnSum_WhenOneNegative() {
        assertEquals(1, calculator.add(2, -1));
    }

}
