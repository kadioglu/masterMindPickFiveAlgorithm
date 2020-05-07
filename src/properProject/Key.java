package properProject;

import java.awt.Color;
import java.util.*;
import java.util.ArrayList;


/**
 * Function that makes a Key object to  be used
 * to convert between code and color and code and text for the main program
 */

public class Key {

    private final int black;
    private final int white;
    private final int none;

    /**
     * Constructor that makes a key object based on guess results
     * @param black  number of black peg results
     * @param white  number of white peg results
     * @param none   number of wrong peg results
     */

    public Key(int black, int white, int none){
        this.black = black;
        this.white = white;
        this.none = none;
    }





    /**
     * Function that checks if a guess is correct
     * @return boolean that is true if the final answer is correct i.e all 4 black pegs
     */

    public boolean isCorrect() {
        return white == 0 && none == 0;
    }


    /**
     * Function that checks if one key is similar to another key
     * @param obj the key to be checked against
     * @return boolean true if the two keys are similar
     */

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
        final Key other = (Key) obj;
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


    /**
     * Function that returns the key's parameters as a string object
     * @return String the key's parameters in a sentence
     */

    @Override
    public String toString() {
        return "black=" + black + ", white=" + white + ", none=" + none;
    }


    /**
     * Function that returns the key's parameters as a Color object List
     * @return Color List of the key
     */

    public List<Color> toColor(){
        ColorManager colorKey = new ColorManager();
        List<Color> colorList = new ArrayList<>();
        for (int i = 0; i < black; i++) {
            colorList.add(colorKey.toColor(7));
        }
        for (int i = 0; i < white; i++) {
            colorList.add(colorKey.toColor(8));
        }
        for (int i = 0; i < none; i++) {
            colorList.add(colorKey.toColor(11));
        }
        return colorList;
    }

    /**
     * Function that returns the value of the black variable
     * @return int the value of the black variable
     */

    public int getBlack() {
        return black;
    }

    /**
     * Function that returns the value of the white variable
     * @return int the value of the white variable
     */

    public int getWhite() {
        return white;
    }

    /**
     * Function that returns the value of the none variable
     * @return int the value of the none variable
     */

    public int getNone() {
        return none;
    }
}
