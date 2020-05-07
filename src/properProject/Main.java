package properProject;
//

import comp127graphics.CanvasWindow;

public class Main {

    private static int turn = 0;

    public static void main(String args[]) {
        CanvasWindow canvas = new CanvasWindow("MasterMind", 1000, 800);

        int size = 100;
        Banner banner = new Banner();
        Board board = new Board(size,canvas,banner);
        board.nextRow = 0;

        canvas.add(banner);
        canvas.draw();

        GameManager gameManager = new GameManager(canvas,banner,board,size);

    }
}
