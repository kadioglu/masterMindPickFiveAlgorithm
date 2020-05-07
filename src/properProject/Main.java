package properProject;
//

import comp127graphics.CanvasWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Testing
public class Main {

    private static int turn = 0;

    public static void main(String args[]) throws IOException {
        CanvasWindow canvas = new CanvasWindow("MasterMind", 1000, 800);

        int size = 100;
        Board board = new Board(size,canvas);
        board.nextRow = 0;

        CodeMaker maker = new CodeMaker();
        Boolean answer = false;
        CodeBreaker breaker = answer ? new HumanSolver(): new SolverAlgorithm();

        maker.setAnswer();
        Key response = null;

        do {
            System.out.println("========Turn " + ++turn + "========");
            Code guess = breaker.guess();


            List<Color> myColors = guess.makeColorList();
            board.makeNewRow(size,canvas,turn,myColors);
            canvas.draw();

            myColors.clear();

            response = maker.verify(guess);
            System.out.println("Response: " + response);
            breaker.receiveKey(response);
        } while (!response.isCorrect());

        System.out.println();
        System.out.println("========Winner========");
        System.out.println("Answer: " + maker.getAnswer());
        System.out.println("Turns: " + turn);
        System.out.println("You won!");

    }
}
