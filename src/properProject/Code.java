package properProject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Code {
    private static final Random RANDOM = new Random();
    private static int codeRadix = 6;
    private static int codeLength = 4;

    public final int[] pegs;
    public final int codePoint;

    public Code() {
        codePoint = RANDOM.nextInt(codeRange());
        pegs = toPegs(codePoint);
    }

    public Code(int codePoint) {
        this.codePoint = codePoint;
        this.pegs = toPegs(codePoint);
    }

    private static int codeRange() {
        return (int) Math.pow(codeRadix, codeLength);
    }


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

    public Code(String code) {
        char[] p = code.toCharArray();
        this.pegs = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            this.pegs[i] = Character.digit(p[i], 10);
        }
        this.codePoint = toCodePoint(this.pegs);
    }

    private int toCodePoint(int[] pegs) {
        int q = 0;
        for (int i = 0; i < pegs.length; i++) {
            if (pegs[i] != 0) {
                q += pegs[i] * Math.pow(10, i);
            }
        }
        return q;
    }

    private int[] toPegs(int codePoint) {
        int[] output = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            output[i] = codePoint % codeRadix;
            codePoint /= codeRadix;
        }
        return output;
    }

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
}
