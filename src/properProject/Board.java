package properProject;

import comp127graphics.*;
import java.awt.Color;
import java.util.*;

/**
 * Class that creates a board object that holds the overall rows and manages row production.
 */
public class Board {

    private static ColorManager colorKey = new ColorManager();

    public static double nextRow;
    public static double spacing = 30;

    public RowMaker row;
    public Color DIMMED_PURPLE = colorKey.toColor(11);
    public List<GraphicsGroup> myRows = new ArrayList<>();
    public List<Color> emptyOrbs = List.of(DIMMED_PURPLE,DIMMED_PURPLE,DIMMED_PURPLE,DIMMED_PURPLE);


    /**
     * Constructor that Builds board
     * @param size  The size of rows in the board
     * @param canvas the canvas window to draw rows on
     */

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

    /**
     * Makes a new row that will contain specific orbs from the player answer and results
     * @param size  Size of the row
     * @param canvas canvas window to add row to
     * @i count number for the row
     * @param newAnswers List of colors from the player answers
     * @newResults List of colors from the player's results (which answers were right)
     */

    public void makeNewRow(double size, CanvasWindow canvas, int i, List<Color> newAnswers, List<Color> newResults){
        GraphicsGroup myRow = row.createRow(size, i, newAnswers,newResults);
        myRow.setPosition(50, 0 + nextRow);
        canvas.add(myRow);
        nextRow += 30 + spacing;
        canvas.draw();

    }



}
