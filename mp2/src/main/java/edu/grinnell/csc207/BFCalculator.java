package edu.grinnell.csc207;

/**
 * The calculator class that performs operations on BigFraction values
 * The calculator stores the last computed value and allows operations such as addition, subtraction, multiplication, and division.
 * It also allows the result to be reset to zero.
 *
 * @author Bonsen Yusuf
 */
public class BFCalculator {
    private BigFraction lastValue;

    /*
     * Constructs a new BFCalculator with initial value set to 0.
     */
    public BFCalculator() {
        lastValue = new BigFraction(0, 1);
    }

    /**
     * Retrieves the last calculated value.
     *
     * @return the last computed fraction.
     */
    public BigFraction get() {
        return lastValue;
    }

    /**
     * Adds a fraction to the last computed value.
     *
     * @param val the fraction being added
     */
    public void add(BigFraction val) {
        lastValue = lastValue.add(val);
    }

    /**
     * Subtracts a fraction from the last computed value.
     *
     * @param val the fraction to subtract.
     */
    public void subtract(BigFraction val) {
        lastValue = lastValue.subtract(val);
    }

    /**
     * Multiplies the last computed value by a fraction.
     *
     * @param val the fraction to multiply by.
     */
    public void multiply(BigFraction val) {
        lastValue = lastValue.multiply(val);
    }

    /**
     * Divides the last computed value by a fraction.
     *
     * @param val the fraction to divide by.
     */
    public void divide(BigFraction val) {
        lastValue = lastValue.divide(val);
    }

    /**
     * Clears the last computed value, resetting it to 0.
     */
    public void clear() {
        lastValue = new BigFraction(0, 1);
    }
}
