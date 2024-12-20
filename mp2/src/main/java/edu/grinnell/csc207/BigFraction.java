
package edu.grinnell.csc207;

import java.math.BigInteger;

/**
 * Handles operations with large numerator and denominator values.
 * Fractions can be simplified or left in non-simplified form.
 * Provides operations to add, subtract, multiply, or divide fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Bonsen Yusuf
 */
public class BigFraction {

  /**
   * The numerator of the fraction.
   */
  private BigInteger num; // num

  /**
   * The denominator of the fraction.
   */
  private BigInteger denom; // denom

  /**
   * Constructor that takes a numerator and denominator and constructs a fraction.
   * Automatically simplifies the fraction.
   *
   * @param numerator the numerator of the fraction.
   * @param denominator the denominator of the fraction.
   * @throws ArithmeticException if the denominator is zero.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) { // BigFraction(BigInteger, BigInteger)
    if (denominator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Denominator cannot be zero.");
    } // if
    this.num = numerator;
    this.denom = denominator;
    simplify();
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Constructor that takes integer values for the numerator and denominator.
   *
   * @param numerator the numerator as an integer.
   * @param denominator the denominator as an integer.
   */
  public BigFraction(int numerator, int denominator) { // BigFraction(int, int)
    this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
  } // BigFraction(int, int)

  /**
   * Simplifies the fraction to its lowest terms.
   */
  private void simplify() { // simplify
    BigInteger gcd = num.gcd(denom);
    num = num.divide(gcd);
    denom = denom.divide(gcd);
    if (denom.compareTo(BigInteger.ZERO) < 0) {
      num = num.negate();
      denom = denom.negate();
    } // if
  } // simplify

  /**
   * Returns the fraction as a double.
   *
   * @return the fraction in double form.
   */
  public double doubleValue() { // doubleValue
    return num.doubleValue() / denom.doubleValue();
  } // doubleValue

  /**
   * Adds another fraction to this fraction.
   *
   * @param other the fraction to add.
   * @return the resulting fraction after adding.
   */
  public BigFraction add(BigFraction other) { // add
    BigInteger numerator = this.num.multiply(other.denom).add(other.num.multiply(this.denom));
    BigInteger denominator = this.denom.multiply(other.denom);
    return new BigFraction(numerator, denominator);
  } // add

  /**
   * Subtracts another fraction from this fraction.
   *
   * @param other the fraction to subtract.
   * @return the resulting fraction.
   */
  public BigFraction subtract(BigFraction other) { // subtract
    BigInteger numerator = this.num.multiply(other.denom).subtract(other.num.multiply(this.denom));
    BigInteger denominator = this.denom.multiply(other.denom);
    return new BigFraction(numerator, denominator);
  } // subtract

  /**
   * Multiplies this fraction with another fraction.
   *
   * @param other the fraction to multiply with.
   * @return the resulting fraction.
   */
  public BigFraction multiply(BigFraction other) { // multiply
    BigInteger numerator = this.num.multiply(other.num);
    BigInteger denominator = this.denom.multiply(other.denom);
    return new BigFraction(numerator, denominator);
  } // multiply

  /**
   * Divides this fraction by another fraction.
   *
   * @param other the fraction to divide by.
   * @return the resulting fraction after dividing.
   * @throws ArithmeticException if trying to divide by zero.
   */
  public BigFraction divide(BigFraction other) { // divide
    if (other.num.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("No division by zero.");
    } // if
    BigInteger numerator = this.num.multiply(other.denom);
    BigInteger denominator = this.denom.multiply(other.num);
    return new BigFraction(numerator, denominator);
  } // divide

  /**
   * Returns the string representation of the fraction.
   *
   * @return the string form of the fraction.
   */
  @Override
  public String toString() { // toString
    if (denom.equals(BigInteger.ONE)) {
      return num.toString();
    } // if
    return num + "/" + denom;
  } // toString

  /**
   * Constructor that takes a fraction in string format.
   * The string must be in the format "numerator/denominator".
   *
   * @param fraction the string representation of the fraction.
   * @throws IllegalArgumentException if the format is incorrect.
   */
  public BigFraction(String fraction) { // BigFraction(String)
    String[] parts = fraction.split("/");
    if (parts.length != 2) {
      throw new IllegalArgumentException("Invalid fraction format");
    } // if
    this.num = new BigInteger(parts[0]);
    this.denom = new BigInteger(parts[1]);
    simplify(); // Ensure the fraction is simplified
  } // BigFraction(String)
} // BigFraction

