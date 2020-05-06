package properProject;

import java.util.*;

/**
 * Class that is used to make a Computer Solver that is a child of the CodeBreaker Interface
 */

public class SolverAlgorithm implements CodeBreaker {

    private Key response = null;
    private Code guess = null;

    private final List<Code> impossible = new LinkedList<>();
    private final Set<Code> possible;

    /**
     * Constructor that gets the range of a code and converts it into a set
     */

    public SolverAlgorithm() {
        possible = Code.getRange();
    }

    /**
     * Function that recieves a key and checks what codes are possible or not based on the five
     * guess algorithm
     * @param key the key to be checked against
     */

    @Override
    public void receiveKey(Key key) {
        response = key;
        Iterator<Code> iterator = possible.iterator();
        while (iterator.hasNext()) {
            Code i = iterator.next();
            if (!guess.getKey(i).equals(response)) {
                impossible.add(i);
                iterator.remove();
            }
        }
    }

    /**
     * Function that guesses the next code based on the possible and impossible codes and
     * a minimax algorithm
     * @return Code returns a code object that is the next most likely code to win the game
     * or will help win the game soon
     */

    @Override
    public Code guess() {
        int minimumEliminated = -1;
        Code bestGuess = null;
        List<Code> unused = new LinkedList<>(possible);
        unused.addAll(impossible);
        for (Code a : unused) {
            int[][] minMaxTable = new int[Code.getCodeLength() + 1][Code.getCodeLength() + 1];
            for (Code b : possible) {
                Key abKey = a.getKey(b);
                minMaxTable[abKey.getBlack()][abKey.getWhite()]++;
            }
            int mostHits = -1;
            for (int[] row : minMaxTable) {
                for (int i : row) {
                    mostHits = Integer.max(i, mostHits);
                }
            }
            int score = possible.size() - mostHits;
            if (score > minimumEliminated) {
                minimumEliminated = score;
                bestGuess = a;
            }
        }
        guess = bestGuess;
        System.out.println("Enter secret code: " + guess);
        return bestGuess;
    }

}
