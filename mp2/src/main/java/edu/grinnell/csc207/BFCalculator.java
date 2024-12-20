
package edu.grinnell.csc207;

/**
 * The calculator class that performs operations on BigFraction values.
 * The calculator stores the last computed value and allows operations such as
 * addition, subtraction, multiplication, and division. It also allows the result
 * to be reset to zero.
 *
 * @author Bonsen Yusuf
 */
public class BFCalculator {

  /**
   * The last computed value stored as a BigFraction.
   */
  private BigFraction lastValue; // lastValue

  /**
   * Constructs a new BFCalculator with an initial value set to 0.
   */
  public BFCalculator() { // BFCalculator()
    lastValue = new BigFraction(0, 1); // Initialize lastValue to 0/1
  } // BFCalculator()

  /**
   * Retrieves the last calculated value.
   *
   * @return the last computed fraction.
   */
  public BigFraction get() { // get
    return lastValue; // Return last computed value
  } // get

  /**
   * Adds a fraction to the last computed value.
   *
   * @param val the fraction being added.
   */
  public void add(BigFraction val) { // add
    lastValue = lastValue.add(val); // Add value to last computed value
  } // add

  /**
   * Subtracts a fraction from the last computed value.
   *
   * @param val the fraction to subtract.
   */
  public void subtract(BigFraction val) { // subtract
    lastValue = lastValue.subtract(val); // Subtract value from last computed value
  } // subtract

  /**
   * Multiplies the last computed value by a fraction.
   *
   * @param val the fraction to multiply by.
   */
  public void multiply(BigFraction val) { // multiply
    lastValue = lastValue.multiply(val); // Multiply last computed value by input value
  } // multiply

  /**
   * Divides the last computed value by a fraction.
   *
   * @param val the fraction to divide by.
   */
  public void divide(BigFraction val) { // divide
    lastValue = lastValue.divide(val); // Divide last computed value by input value
  } // divide

  /**
   * Clears the last computed value, resetting it to 0.
   */
  public void clear() { // clear
    lastValue = new BigFraction(0, 1); // Reset lastValue to 0/1
  } // clear
} // BFCalculator


