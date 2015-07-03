/**
 # 	XXX company                                CONFIDENTIAL

 #        RomanConverter.java file, has dependency file ExtIO.java
 #	** The file RomanNumeralConv (conversion between 1 and 3000) **
 #
 #       1. Converting integers to Roman Numerals
 #	2. Converting Roman Numerals to integers
 #
 #
 # Continuus Project:  XXX
 # full_name: RomanConverter.java
 #
 # %full_filespec:  %
 #
 # %date_created: Tue Aug 06 10:38:35 2013 %
 #
 # %created_by: Tejavath %
 #
 #
 # Document Code:  - (not valid)
 #
 # Copyright (c) : XXX company

 # Change History (latest version on top of the list):
 #
 #------------------------------------------------------------------------
 # Version:       %version%
 # Date modified: %date_modified%
 # Derived by:    %derived_by%
 # Status:        draft
 # Version notes: ?
 #------------------------------------------------------------------------
 **/

import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.lang.*;

/**
 * This program will convert Roman numerals to ordinary arabic numerals
 * and vice versa.  The user can enter a numerals of either type.  Arabic
 * numerals must be in the range from 1 to 3000 inclusive.  The user ends
 * the program by entering an empty line.
 */

public class RomanConverter {

    public static void main(String[] args) {

        /** External function putln(), put(),peek(),getlnInt(),getln() and getAnyChar() are called from ExtIO.java file **/

        while (true) {


        }  // end while

    }  // end main()

} // end class RomanConverter


/**
 * An object of type RomanNumeral is an integer between 1 and 3000.  It can
 * be constructed either from an integer or from a string that represents
 * a Roman numeral in this range.  The function toString() will return a
 * standardized Roman numeral representation of the number.  The function
 * toInt() will return the number as a value of type int.
 */

class RomanNumeral {

    private final int num;   // The number represented by this Roman numeral.

         /* The following arrays are used by the toString() function to construct
            the standard Roman numeral representation of the number.  For each i,
            the number numbers[i] is represented by the corresponding string, letters[i].
         */

    private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,
            50,   40,   10,    9,    5,    4,    1 };

    private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
            "L",  "XL",  "X",  "IX", "V",  "IV", "I" };

    /**
     * Constructor.  Creates the Roman number with the int value specified
     * by the parameter.  Throws a NumberFormatException if arabic is
     * not in the range 1 to 3000 inclusive.
     */
    public RomanNumeral(int arabic) {
        if (arabic < 1)
            throw new NumberFormatException("Value of RomanNumeral must be positive.");
        if (arabic > 3000)
            throw new NumberFormatException("Value of RomanNumeral must be 3000 or less.");
        num = arabic;
    }


    /*
     * Constructor.  Creates the Roman number with the given representation.
     * For example, RomanNumeral("xvi") is 16.  If the parameter is not a
     * legal Roman numeral, a NumberFormatException is thrown.  Both upper and
     * lower case letters are allowed.
     */
    public RomanNumeral(String roman) {

        if (roman.length() == 0)
            throw new NumberFormatException("An empty string does not define a Roman numeral.");

        roman = roman.toUpperCase();  // Convert to upper case letters.

        int i = 0;       // A position in the string, roman;
        int arabic = 0;  // Arabic numeral equivalent of the part of the string that has
        //    been converted so far.

        while (i < roman.length()) {

            char letter = roman.charAt(i);        // Letter at current position in string.
            int number = letterToNumber(letter);  // Numerical equivalent of letter.

            i++;  // Move on to next position in the string

            if (i == roman.length()) {
                // There is no letter in the string following the one we have just processed.
                // So just add the number corresponding to the single letter to arabic.
                arabic += number;
            }
            else {
                // Look at the next letter in the string.  If it has a larger Roman numeral
                // equivalent than number, then the two letters are counted together as
                // a Roman numeral with value (nextNumber - number).
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    // Combine the two letters to get one value, and move on to next position in string.
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    // Don't combine the letters.  Just add the value of the one letter onto the number.
                    arabic += number;
                }
            }

        }  // end while

        if (arabic > 3000)
            throw new NumberFormatException("Roman numeral must have value 3000 or less.");

        num = arabic;

    } // end constructor

    /**
     * Find the integer value of letter considered as a Roman numeral.  Throws
     * NumberFormatException if letter is not a legal Roman numeral.  The letter
     * must be upper case.
     */
    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   throw new NumberFormatException(
                    "Illegal character \"" + letter + "\" in Roman numeral");
        }
    }

    /**
     * Return the standard representation of this Roman numeral.
     */
    public String toString() {
        String roman = "";  // The roman numeral.
        int N = num;        // N represents the part of num that still has
        //   to be converted to Roman numeral representation.
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }

    /**
     * Return the value of this Roman numeral as an int.
     */
    public int toInt() {
        return num;
    }

} // end class RomanNumeral
