package projectTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class KnuthAlgorithm {


    public class DonaldKnuth implements BreakCode {

        private Pegs response = null;
        private Code guess = null;

        private final List<Code> impossible = new LinkedList<>();
        private final Set<Code> possible;

        public DonaldKnuth() {
            possible = Code.getRange();
        }

        public void receiveKey(Pegs peg) {
            response = peg;
            Iterator<Code> iterator = possible.iterator();
            while (iterator.hasNext()) {
                Code i = iterator.next();
                if (!guess.getKey(i).equals(response)) {
                    impossible.add(i);
                    iterator.remove();
                }
            }
        }


        public Code guess() {
            int minimumEliminated = -1;
            Code bestGuess = null;
            List<Code> unused = new LinkedList<>(possible);
            unused.addAll(impossible);
            for (Code a : unused) {
                int[][] minMaxTable = new int[Code.getCodeLength() + 1][Code.getCodeLength() + 1];
                for (Code b : possible) {
                    Pegs abKey = a.getKey(b);
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
}
