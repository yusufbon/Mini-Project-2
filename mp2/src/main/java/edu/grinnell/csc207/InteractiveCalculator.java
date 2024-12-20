
package edu.grinnell.csc207;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * InteractiveCalculator implements a simple REPL for performing fraction calculations.
 * Supports commands for addition, subtraction, multiplication, and division.
 *
 * @author Bonsen Yusuf
 */
public class InteractiveCalculator {

  /**
   * Main method for InteractiveCalculator.
   *
   * This method starts a REPL loop that continuously reads user input,
   * processes the input using a fraction calculator, and prints the results.
   *
   * @param args command-line arguments (not used).
   */
  public static void main(String[] args) { // main(String[] args)
    BFCalculator calculator = new BFCalculator(); // Initialize calculator
    BFRegisterSet registers = new BFRegisterSet(); // Initialize registers
    Scanner scanner = new Scanner(System.in); // Initialize scanner for user input
    PrintWriter pen = new PrintWriter(System.out, true); // Initialize PrintWriter

    while (true) { // while (true)
      pen.print("> "); // Prompt user input
      String input = scanner.nextLine().trim(); // Read user input

      if (input.equalsIgnoreCase("QUIT")) { // if input is "QUIT"
        break; // Exit the loop
      } // if

      try { // try block for input processing
        processInput(input, calculator, registers); // Process input
        pen.println(calculator.get()); // Print result
      } catch (Exception e) { // catch block for handling errors
        pen.println("Error processing input: " + e.getMessage()); // Print error message
      } // catch
    } // while
    scanner.close(); // Close the scanner
  } // main(String[] args)

  /**
   * Processes user input, performs operations using the calculator and registers.
   *
   * @param input the line of input from the user.
   * @param calculator the calculator to perform operations on fractions.
   * @param registers the register set for storing fractions.
   * @throws Exception if an unknown command is encountered.
   */
  private static void processInput(String input,
                                   BFCalculator calculator,
                                   BFRegisterSet registers) throws Exception { // processInput
    String[] components = input.split(" "); // Split input into components
    for (String component : components) { // for each component in input
      if (component.matches("\\d+/\\d+")) { // if component is a fraction
        calculator.add(new BigFraction(component)); // Add fraction to calculator
      } else if (component.equalsIgnoreCase("+")) { // if component is "+"
        calculator.add(calculator.get()); // Perform addition
      } else if (component.equalsIgnoreCase("-")) { // if component is "-"
        calculator.subtract(calculator.get()); // Perform subtraction
      } else if (component.equalsIgnoreCase("*")) { // if component is "*"
        calculator.multiply(calculator.get()); // Perform multiplication
      } else if (component.equalsIgnoreCase("/")) { // if component is "/"
        calculator.divide(calculator.get()); // Perform division
      } else {
        throw new Exception("Unknown command: " + component); // Throw error
      } // else
    } // for
  } // processInput
} // InteractiveCalculator
