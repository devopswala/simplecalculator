package com.cal;

public class SimpleCalculator {

    // Example methods for addition and subtraction
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    // Main method - Entry point of the application
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        // Example usage of the calculator
        int sum = calculator.add(5, 3);
        int difference = calculator.subtract(5, 3);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}
