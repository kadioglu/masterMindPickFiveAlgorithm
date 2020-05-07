package properProject;
//

import comp127graphics.CanvasWindow;

/**
 * Main CLass used to run the program
 */

public class Main {

    /**
     * Main method that makes a new canvas, banner and board and game manager
     */

    public static void main(String args[]) {
        CanvasWindow canvas = new CanvasWindow("MasterMind", 1000, 800);

        int size = 100;
        Banner banner = new Banner();
        Board board = new Board(size,canvas);
        board.nextRow = 0;

        canvas.add(banner);
        canvas.draw();

        GameManager gameManager = new GameManager(canvas,banner,board,size);

    }
}
