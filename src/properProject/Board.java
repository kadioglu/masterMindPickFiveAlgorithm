package properProject;

import comp127graphics.*;
import java.awt.Color;
import java.util.*;

/**
 * Class that creates a board object that holds the color code and position of colors.
 */
public class Board {

    private static ColorManager colorKey = new ColorManager();

    public static double nextRow;
    public static double spacing = 30;

    public RowMaker row;
    public Color DIMMED_PURPLE = colorKey.toColor(11);
    public List<GraphicsGroup> myRows = new ArrayList<>();
    public List<Color> emptyOrbs = List.of(DIMMED_PURPLE,DIMMED_PURPLE,DIMMED_PURPLE,DIMMED_PURPLE);

    public Board(double size, CanvasWindow canvas){

        for (int i=1;i<=10;i++) {
            GraphicsGroup myRow = row.createRow(size, i, emptyOrbs,emptyOrbs);
            myRow.setPosition(50, 0 + nextRow);
            nextRow += 30 + spacing;
            myRows.add(myRow);
            canvas.add(myRow);
            canvas.setBackground(DIMMED_PURPLE);
        }

    }

    public void makeNewRow(double size, CanvasWindow canvas, int i, List<Color> newAnswers, List<Color> newResults){
        GraphicsGroup myRow = row.createRow(size, i, newAnswers,newResults);
        myRow.setPosition(50, 0 + nextRow);
        canvas.add(myRow);
        nextRow += 30 + spacing;
        canvas.draw();

    }



}
