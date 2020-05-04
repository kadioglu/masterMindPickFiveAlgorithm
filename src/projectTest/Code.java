package projectTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Code {

    private static final Random RANDOM = new Random();
    private static int codeRadix = 6;
    private static int codeLength = 4;
    private final int[] pegs;

    public Code(int[] pegs) {
        this.pegs = pegs;
    }

    private static int codeRange() {
        return (int) Math.pow(codeRadix, codeLength);
    }

    public static int getCodeLength() {
        return codeLength;
    }

    public static Set<Code> getRange() {
        Set<Code> universe = new HashSet<>();
        for (int i = 0; i < codeRange(); i++) {
        }
        return universe;
    }

    public Pegs getKey(Code other) {
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
        return new Pegs(black, white, none);
    }

}


