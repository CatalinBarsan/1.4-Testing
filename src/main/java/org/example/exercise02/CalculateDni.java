package org.example.exercise02;

public class CalculateDni {

    private static final char[] LETTERS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};

    public static char calculateDniLetter(int number) {
        if (number < 0 || number >= 100000000) {
            throw new IllegalArgumentException("DNI number must be between 0 and 99999999.");
        }
        return LETTERS[number % 23];
    }
}

