package properProject;

import java.util.Scanner;
//
public class Game {
    private static Scanner scanner;
    Instructions instructions = new Instructions();
    public static void main(String[] args) {
       runGame();
    }

    public static void runGame(){
        System.out.println("Do you want to play or do you want the computer to play? true/false");
        Boolean answer = false;
        do {
            CodeMaker maker = new CodeMaker();
            CodeBreaker breaker = answer ? new HumanSolver(): new SolverAlgorithm();
            maker.setAnswer();
            int turn = 0;
            Key response = null;
            do {
                System.out.println();
                System.out.println("========Turn " + ++turn + "========");
                Code guess = breaker.guess();
                response = maker.verify(guess);
                System.out.println("Response: " + response);
                breaker.receiveKey(response);
            } while (!response.isCorrect());
            System.out.println();
            System.out.println("========Winner========");
            System.out.println("Answer: " + maker.getAnswer());
            System.out.println("Turns: " + turn);
            System.out.println("You won!");
        } while(false);
    }
}
