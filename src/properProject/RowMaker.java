package properProject;

import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.GraphicsText;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static comp127graphics.FontStyle.BOLD;

/**
 * Class used to make a row object for the GUI
 */

public class RowMaker {
    private static ColorManager colorKey = new ColorManager();
    public static double nextPosition;
    public static double spacing = 30;

    public RowMaker(){
    }

    /**
     * Creates a Row As a graphics group for user answers
     *
     * @param size The overall width and height of the row.
     * @param rowNumber
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createRow(double size, int rowNumber, java.util.List<Color> colorList, java.util.List<Color> resultList) {
        GraphicsGroup group = new GraphicsGroup();
        java.util.List<GraphicsObject> answerOrbList = new ArrayList<>();
        List<GraphicsObject> resultOrbList = new ArrayList<>();

        String innerText =  rowNumber + " ";
        GraphicsText text = new GraphicsText(innerText,0,size * 1.3);
        text.setFillColor(colorKey.toColor(10));
        text.setFontStyle(BOLD);
        group.add(text);

        for (int i=0;i<4;i++)
        {
            SmallOrb smallOrb = new SmallOrb(size);
            smallOrb.outputOrb.setFillColor(resultList.get(i));
            resultOrbList.add(smallOrb.outputOrb);
        }

        for (int i=0;i<4;i++) {
            LargeOrb largeOrb = new LargeOrb(size);
            largeOrb.outputOrb.setFillColor(resultList.get(i));
            answerOrbList.add(largeOrb.outputOrb);
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
}
