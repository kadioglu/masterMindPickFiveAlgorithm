package projectTest;


import comp127graphics.*;

import java.awt.Color;
import java.util.*;

import static comp127graphics.FontStyle.BOLD;

@SuppressWarnings("WeakerAccess")
public class Board {
    private static final Color
            ACTIVE_PURPLE = new Color(0xae4bc2),
            DIMMED_PURPLE = new Color(0x472f4e);

    public static double nextPosition,nextRow;
    public static double spacing = 30;

    /**
     * Creates a Row As a graphics group for user answers
     *
     * @param size The overall width and height of the row.
     * @param rowNumber
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createRow(double size, int rowNumber, List<Color> colorList, List<Color> resultList) {
        GraphicsGroup group = new GraphicsGroup();
        List<GraphicsObject> answerOrbList = new ArrayList<>();
        List<GraphicsObject> resultOrbList = new ArrayList<>();

        String innerText =  rowNumber + "";
        GraphicsText text = new GraphicsText(innerText,0,size * 1.3);
        text.setFillColor(ACTIVE_PURPLE);
        text.setFontStyle(BOLD);
        group.add(text);

        for (int i=0;i<4;i++)
        {
            Ellipse smallOrb = resultOrb(size * 0.2);
            smallOrb.setFillColor(resultList.get(i));
            resultOrbList.add(smallOrb);
        }

        for (int i=0;i<4;i++) {
            Ellipse largeOrb = answerOrb(size * 0.5);
            largeOrb.setFillColor(colorList.get(i));
            answerOrbList.add(largeOrb);
        }

        nextPosition = 50;

        for (GraphicsObject member: answerOrbList) {
            member.setPosition(nextPosition, size );
            nextPosition += spacing + size * 1;
            group.add(member);
        }

        nextPosition = 550;

        for (GraphicsObject member: resultOrbList) {
            member.setPosition(nextPosition, size * 1.2);
            nextPosition += spacing + size * 0.05;
            group.add(member);
        }

        return group;
    }


    /**
     * Creates orbs for the results that the user can put as well as the actual results of the system
     * @param size  The width of the implied ellipse from which the smile’s arc is cut.
     */

    private static Ellipse answerOrb(double size){
        Ellipse orb = new Ellipse(0,0,size,size);
        orb.setStrokeColor(DIMMED_PURPLE);
        orb.setStrokeWidth(3);
        return orb;
    }

    private static Ellipse resultOrb(double size){
        Ellipse orb = new Ellipse(0,0,size,size);
        orb.setFillColor(DIMMED_PURPLE);
        orb.setStrokeColor(DIMMED_PURPLE);
        orb.setStrokeWidth(1);
        return orb;
    }




}
