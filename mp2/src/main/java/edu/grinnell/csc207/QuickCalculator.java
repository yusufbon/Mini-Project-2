
package edu.grinnell.csc207;

import java.io.PrintWriter;

/**
 * QuickCalculator provides a way to quickly evaluate expressions from the command line.
 * Supports arithmetic operations and register storage.
 *
 * @author Bonsen Yusuf
 */
public class QuickCalculator {

  /**
   * Main method for QuickCalculator.
   *
   * This method reads arithmetic expressions from command-line arguments,
   * processes them using a fraction calculator, and prints the results.
   *
   * @param args command-line arguments containing expressions to evaluate.
   *             Each argument should be a valid arithmetic expression
   *             involving fractions and operators (+, -, *, /).
   */
  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet registers = new BFRegisterSet();
    PrintWriter pen = new PrintWriter(System.out, true);

    for (String expression : args) {
      try {
        processInput(expression, calculator, registers);
        pen.println(expression + " -> " + calculator.get());
      } catch (Exception e) {
        pen.println("Error processing: " + expression + " - " + e.getMessage());
      } // catch
    } // for
  } // main(String[] args)

  /**
   * Processes a command-line argument for quick evaluation.
   *
   * @param input      the input expression.
   * @param calculator the calculator to perform operations.
   * @param registers  the register set for storing fractions.
   */
  private static void processInput(String input, BFCalculator calculator,
                                   BFRegisterSet registers) {
    // Split the input into components
    String[] components = input.split(" ");
    for (String component : components) {
      if (component.matches("\\d+/\\d+")) { // Check if the component is a fraction
        calculator.add(new BigFraction(component)); // Add fraction to calculator
      } else if (component.equals("-")) { // Handle subtraction
        calculator.subtract(calculator.get()); // Subtract current value
      } else if (component.equals("*")) { // Handle multiplication
        calculator.multiply(calculator.get()); // Multiply current value
      } else if (component.equals("/")) { // Handle division
        calculator.divide(calculator.get()); // Divide current value
      } else if (component.matches("R[0-9]+")) { // Check if component is a register
        char register = (char) ('a' + Integer.parseInt(component.substring(1)) - 1);
        BigFraction value = registers.get(register); // Get value from registers
        if (value != null) {
          calculator.add(value); // Add register value to calculator
        } else {
          throw new IllegalArgumentException("Register " + register + " is empty.");
        } // else
      } else {
        throw new IllegalArgumentException("Invalid input: " + component);
      } // else
    } // for
  } // processInput(String input, BFCalculator calculator, BFRegisterSet registers)
} // QuickCalculator
