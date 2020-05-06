package properProject;

import java.util.*;

public class SolverAlgorithm implements CodeBreaker {

    private Key response = null;
    private Code guess = null;

    private final List<Code> impossible = new LinkedList<>();
    private final Set<Code> possible;

    public SolverAlgorithm() {
        possible = Code.getRange();
    }


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
