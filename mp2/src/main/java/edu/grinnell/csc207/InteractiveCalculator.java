package edu.grinnell.csc207;

//package edu.grinnell.csc207.main;

//import edu.grinnell.csc207.util.*;
import java.util.Scanner;
import edu.grinnell.csc207.BigFraction;

/**
 * InteractiveCalculator implements a simple REPL for performing fraction calculations.
 * Supports commands for addition, subtraction, multiplication, division, storing in registers, and quitting.
 *
 * @author Bonsen Yusuf
 */
public class InteractiveCalculator {
    public static void main(String[] args) {
        BFCalculator calculator = new BFCalculator();
        BFRegisterSet registers = new BFRegisterSet();
        Scanner scanner = new Scanner(System.in); // initialize scanner to read user input
       
        while (true) { // loops until user enters quit 
            System.out.print("> "); // prompts user input
            String input = scanner.nextLine().trim(); // get rid of excess spaces fro input

            if (input.equalsIgnoreCase("QUIT")) {
                break; // determines wheter or not to end the loop
            }

            try {
                processInput(input, calculator, registers); 
                System.out.println(calculator.get());
            }
        }
        scanner.close();
    }

    /**
     * Process's input by aking thr user's inpu as a string, along with th e calculator and register objects and performs operations on fractions.
     *
     * @param input the line of input.
     * @param calculator the calculator to perform operations.
     * @param registers the register set for storing fractions.
     */
    private static void processInput(String input, BFCalculator calculator, BFRegisterSet registers) {
        // Split the input into components
        String[] components = input.split(" ");
       
        // Variable to store the last used register for operations
        String lastRegister = null;
    
        for (String component : components) {
            if (component.matches("\\d+/\\d+")) {
                // If the token is a fraction, create a BigFraction and add it to the calculator
                calculator.add(new BigFraction(component));
            } else if (component.equalsIgnoreCase("+")) {
                // Perform addition
                calculator.add(calculator.get()); // Assuming the last result is added
            } else if (component.equalsIgnoreCase("-")) {
                // Perform subtraction
                calculator.subtract(calculator.get()); // Assuming the last result is subtracted
            } else if (component.equalsIgnoreCase("*")) {
                // Perform multiplication
                calculator.multiply(calculator.get()); // Assuming the last result is multiplied
            } else if (component.equalsIgnoreCase("/")) {
                // Perform division
                calculator.divide(calculator.get()); // Assuming the last result is divided
            } else {
                System.out.println("Unknown command: " + component);
            }
        }
    }
}