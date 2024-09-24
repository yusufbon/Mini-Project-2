package edu.grinnell.csc207;

/**
 * This class manages a set of registers to store BigFraction values.
 * The registers are identified by the characters 'a' through 'z'.
 */
public class BFRegisterSet {

    private BigFraction[] registers;

    /**
     * Constructor to initialize the registers with 26 slots,
     * corresponding to registers 'a' through 'z'.
     */
    public BFRegisterSet() {
        registers = new BigFraction[26];
        // Initialize all registers to 0/1 by default
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new BigFraction(0, 1);
        }
    }

    /**
     * Stores the given BigFraction value in the specified register.
     * @param register The character representing the register ('a' through 'z').
     * @param val The BigFraction value to store in the register.
     * @throws IllegalArgumentException if the register is not between 'a' and 'z'.
     */
    public void store(char register, BigFraction val) {
        int index = getRegisterIndex(register);
        registers[index] = val;
    }

    /**
     * Retrieves the BigFraction value stored in the specified register.
     * Returns 0/1 if the register is not initialized.
     * @param register The character representing the register ('a' through 'z').
     * @return The BigFraction value stored in the register.
     * @throws IllegalArgumentException if the register is not between 'a' and 'z'.
     */
    public BigFraction get(char register) {
        int index = getRegisterIndex(register);
        return registers[index];
    }

    /**
     * Converts the register character ('a' to 'z') into an array index.
     * @param register The register character.
     * @return The corresponding array index.
     * @throws IllegalArgumentException if the register is not between 'a' and 'z'.
     */
    private int getRegisterIndex(char register) {
        if (register < 'a' || register > 'z') {
            throw new IllegalArgumentException("Register must be a letter between 'a' and 'z'.");
        }
        return register - 'a';
    }
}
