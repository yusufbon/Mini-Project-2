package edu.grinnell.csc207;

import java.math.BigInteger;

/**
 * From the lab!
 * Handles operations with large numerator and denominator values.
 * Fractions can be simplified or left in non-simplified form.
 * Provides operations to add, subtract, multiply, or divide.
 *
 * @author Samuel A. Rebelsky
 * @author Bonsen Yusuf
 */
public class BigFraction {
    private BigInteger num;
    private BigInteger denom;

    /**
     * Constructor that takes a numerator and denominator and constructs a fraction.
     * Automatically simplifies the fraction.
     *
     * @param numerator the numerator of the fraction.
     * @param denominator the denominator of the fraction.
     * @throws ArithmeticException if the denominator is zero.
     */
    public BigFraction(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        this.num = numerator;
        this.denom = denominator;
        simplify();
    }

    /**
     * Constructor that takes integer values for the numerator and denominator.
     *
     * @param numerator the numerator as an integer.
     * @param denominator the denominator as an integer.
     */
    public BigFraction(int numerator, int denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    /**
     * Simplifies the fraction
     */
    private void simplify() {
        BigInteger gcd = num.gcd(denom);
        num = num.divide(gcd);
        denom = denom.divide(gcd);
        if (denom.compareTo(BigInteger.ZERO) < 0) {
            num = num.negate();
            denom = denom.negate();
        }
    }

    /**
     * Returns the fraction as a double.
     *
     * @return the fraction in double form.
     */
    public double doubleValue() {
        return num.doubleValue() / denom.doubleValue();
    }

    /**
     * Adds another fraction to this fraction.
     *
     * @param other the fraction to add.
     * @return the resulting fraction after adding
     */
    public BigFraction add(BigFraction other) {
        BigInteger numerator = this.num.multiply(other.denom).add(other.num.multiply(this.denom));
        BigInteger denominator = this.denom.multiply(other.denom);
        return new BigFraction(numerator, denominator);
    }

    /**
     * Subtracts another fraction from this fraction.
     *
     * @param other the fraction to subtract.
     * @return the resulting fraction 
     */
    public BigFraction subtract(BigFraction other) {
        BigInteger numerator = this.num.multiply(other.denom).subtract(other.num.multiply(this.denom));
        BigInteger denominator = this.denom.multiply(other.denom);
        return new BigFraction(numerator, denominator);
    }

    /**
     * Multiplies this fraction with another fraction.
     *
     * @param other the fraction to multiply with.
     * @return the resulting fraction 
     */
    public BigFraction multiply(BigFraction other) {
        BigInteger numerator = this.num.multiply(other.num);
        BigInteger denominator = this.denom.multiply(other.denom);
        return new BigFraction(numerator, denominator);
    }

    /**
     * Divides this fraction by another fraction.
     *
     * @param other the fraction to divide by.
     * @return the resulting fraction after dividing
     * @throws ArithmeticException if trying to divide by zero.
     */
    public BigFraction divide(BigFraction other) {
        if (other.num.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("No division by zero.");
        }
        BigInteger numerator = this.num.multiply(other.denom);
        BigInteger denominator = this.denom.multiply(other.num);
        return new BigFraction(numerator, denominator);
    }

    /**
     * Returns the string representation of the fraction.
     *
     * @return the string form of the fraction.
     */
    @Override
    public String toString() {
        if (denom.equals(BigInteger.ONE)) {
            return num.toString();
        }
        return num + "/" + denom;
    }

    public BigFraction(String fraction) {
        String[] parts = fraction.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid fraction format");
        }
        this.num = new BigInteger(parts[0]);
        this.denom = new BigInteger(parts[1]);
        // Ensure the fraction is simplified
        simplify();
    }
}
