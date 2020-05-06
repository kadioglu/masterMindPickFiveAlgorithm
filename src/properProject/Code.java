package properProject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class that creates a Code object that is used to keep information on a generated or human-made code
 */

public class Code {

    private static final Random RANDOM = new Random();
    private static int codeRadix = 6;
    private static int codeLength = 4;
    private Key wordKey = new Key(0,0,0);
    public final int[] pegs;
    public final int codePoint;


    /**
     * 3 constructors.
     * The first is for making random code
     * The second is for allowing a new code to be made from a combination of numbers
     * The third is for making a code from a string when the Scanner reads the next line of human input
     */

    public Code() {
        codePoint = RANDOM.nextInt(codeRange());
        pegs = toPegs(codePoint);
    }

    public Code(int codePoint) {
        this.codePoint = codePoint;
        this.pegs = toPegs(codePoint);
    }

    public Code(String code) {
        char[] p = code.toCharArray();
        this.pegs = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            this.pegs[i] = Character.digit(p[i], 10);
        }
        this.codePoint = toCodePoint(this.pegs);
    }

    /**
     * Helper function to get information on the range of the code
     */

    private static int codeRange() {
        return (int) Math.pow(codeRadix, codeLength);
    }

    /**
     * Helper function to get information on the length of the code
     */

    public static int getCodeLength() {
        return codeLength;
    }

    /**
     * Function to get information on the range of the code
     */

    public static Set<Code> getRange() {
        Set<Code> universe = new HashSet<>();
        for (int i = 0; i < codeRange(); i++) {
            universe.add(new Code(i));
        }
        return universe;
    }

    /**
     * Checks if a code is valid which should be a string of 4 numbers without spaces and only from
     * 0 to 5 for each number
     * @param input  The code input string
     */

    public static boolean isValid(String input) {
        if (input.length() != codeLength) {
            return false;
        }
        char[] ch = input.toCharArray();
        for (char i : ch) {
            if (Character.isDigit(i)) {
                if (Character.digit(i, 10) >= codeRadix) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Changes an array of integers to a single integer
     * @param pegs  The array of integers as input
     */

    private int toCodePoint(int[] pegs) {
        int q = 0;
        for (int i = 0; i < pegs.length; i++) {
            if (pegs[i] != 0) {
                q += pegs[i] * Math.pow(10, i);
            }
        }
        return q;
    }

    /**
     * Changes an input string of 4 integers to an array of integers
     * @param codePoint the input string of 4 integers
     */

    private int[] toPegs(int codePoint) {
        int[] output = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            output[i] = codePoint % codeRadix;
            codePoint /= codeRadix;
        }
        return output;
    }


    /**
     * Creates orbs for the actual results of the system based on the correct code
     * @param other the other correct code to be compared against
     */

    public Key getKey(Code other) {
        int[] a = Arrays.copyOf(pegs, pegs.length);
        int[] b = Arrays.copyOf(other.pegs, other.pegs.length);
        int black = 0;
        int white = 0;
        int none = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                black++;
                a[i] = -1;
                b[i] = -2;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    white++;
                    b[j] = -2;
                    break;
                }
            }
        }
        none = codeLength - black - white;
        return new Key(black, white, none);
    }

    /**
     * Function that changes the code to a String of Colors from numbers
     */

    @Override
    public String toString() {

        String stringOutput = "";
        for (int i = 0; i < pegs.length; i++) {
            stringOutput += wordKey.toWord(pegs[i]) + " ";
        }
        return stringOutput;
    }
}
