package properProject;

import java.awt.Color;
import java.util.*;

public class ColorManager {

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


    public ColorManager(){
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

    /**
     * Function that querries the ColorMap to get a Color object based on an integer Key
     * @param ref  the key for the Hash Map
     * @return myColor the value returned from the Hash Map
     */

    public Color toColor(int ref){

        return ColorMap.get(ref);
    }


    /**
     * Function that querries the WordMap to get a String Object that
     * defines a specific color based on an integer Key
     * @param ref  the key for the Hash Map
     * @return myColor the value returned from the Hash Map
     */

    public String toWord(int ref){

        return WordMap.get(ref);
    }
}
