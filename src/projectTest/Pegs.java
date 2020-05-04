package projectTest;

public class Pegs {

        private final int black;
        private final int white;
        private final int none;

        public Pegs(int black, int white, int none) {
            this.black = black;
            this.white = white;
            this.none = none;
        }

        public boolean isCorrect() {
            return white == 0 && none == 0;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 13 * hash + this.black;
            hash = 13 * hash + this.white;
            hash = 13 * hash + this.none;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pegs other = (Pegs) obj;
            if (this.black != other.black) {
                return false;
            }
            if (this.white != other.white) {
                return false;
            }
            if (this.none != other.none) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "black=" + black + ", white=" + white + ", none=" + none;
        }

        public int getBlack() {
            return black;
        }

        public int getWhite() {
            return white;
        }

        public int getNone() {
            return none;
        }


}
