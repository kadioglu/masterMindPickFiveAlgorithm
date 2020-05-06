package properProject;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Key {

    private final int black;
    private final int white;
    private final int none;

    public final Map<Integer, Color> ColorMap = new HashMap<>();
    public final Map<Integer, String> WordMap = new HashMap<>();

    private static final Color
            ACTIVE_PURPLE = new Color(0xae4bc2),
            DIMMED_PURPLE = new Color(0x472f4e),
            BLACK = new Color(0x000000),
            WHITE = new Color(0xFFFFFF),
            PURPLE = new Color(0x9934ff),
            RED = new Color(0xFF3334),
            BLUE =new Color(0x33ccfe),
            GREEN =  new Color(0x34ff32),
            YELLOW =new Color(0xFFDE30),
            GREY = new Color(0x777777),
            ORANGE =new Color(0xF45F11);


    public Key(int black, int white, int none){
        this.black = black;
        this.white = white;
        this.none = none;

        ColorMap.put(0, RED);
        ColorMap.put(1, ORANGE);
        ColorMap.put(2, YELLOW);
        ColorMap.put(3, GREEN);
        ColorMap.put(4, BLUE);
        ColorMap.put(5, PURPLE);

        WordMap.put(0, "RED");
        WordMap.put(1, "ORANGE");
        WordMap.put(2, "YELLOW");
        WordMap.put(3, "GREEN");
        WordMap.put(4, "BLUE");
        WordMap.put(5, "PURPLE");

        ColorMap.put(7, BLACK);
        ColorMap.put(8, WHITE);
        ColorMap.put(9, GREY);
        ColorMap.put(10, ACTIVE_PURPLE);
        ColorMap.put(11, DIMMED_PURPLE);

    }


    public Color toColor(int ref){

        Color myColor = ColorMap.get(ref);
        return myColor;
    }

    public String toWord(int ref){

        String myColor = WordMap.get(ref);
        return myColor;
    }

    public boolean isCorrect() {
        return white == 0 && none == 0;
    }

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
