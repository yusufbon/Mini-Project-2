package edu.grinnell.csc207;



//import edu.grinnell.csc207.util.*;


import edu.grinnell.csc207.BigFraction;

/**
 * QuickCalculator provides a way to quickly evaluate expressions from the command line.
 * Supports arithmetic operations and register storage.
 *
 * @author Bonsen
 */
public class QuickCalculator {
    public static void main(String[] args) {
        BFCalculator calculator = new BFCalculator();
        BFRegisterSet registers = new BFRegisterSet();

        for (String expression : args) {
            try {
                processInput(expression, calculator, registers);
                System.out.println(expression + " -> " + calculator.get());
            } catch (Exception e) {
                System.out.println("Error processing: " + expression + " - " + e.getMessage());
            }
        }
    }

    /**
     * Processes a command-line argument for quick evaluation.
     *
     * @param input the input expression.
     * @param calculator the calculator to perform operations.
     * @param registers the register set for storing fractions.
     */
    private static void processInput(String input, BFCalculator calculator, BFRegisterSet registers) {
        // Split the input into components
        String[] tokens = input.split(" ");
       
        for (String token : tokens) {
            if (token.matches("\\d+/\\d+")) { // Check if token is a fraction
                calculator.add(new BigFraction(token)); // Add fraction to calculator
            } else if (token.equals("+")) { // Handle addition
                // Addition is handled automatically in the calculator
            } else if (token.equals("-")) { // Handle subtraction
                calculator.subtract(calculator.get()); // Subtract current value
            } else if (token.equals("*")) { // Handle multiplication
                calculator.multiply(calculator.get()); // Multiply current value
            } else if (token.equals("/")) { // Handle division
                calculator.divide(calculator.get()); // Divide current value
            } else if (token.matches("R[0-9]+")) { // Check if token is a register (e.g., R1)
                char register = (char) ('a' + Integer.parseInt(token.substring(1)) - 1); // Convert R1 to 'a'
                BigFraction value = registers.get(register); // Get value from registers
                if (value != null) {
                    calculator.add(value); // Add register value to calculator
                } else {
                    throw new IllegalArgumentException("Register " + register + " is empty.");
                }
            } else {
                throw new IllegalArgumentException("Invalid input: " + token);
            }
        }
    }
}