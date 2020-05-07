package properProject;

import java.util.Scanner;

/**
 * Class that creates a main function and runs the Mastermind game
 */
public class Game {
    private static Scanner scanner;

    private static Instructions instructions = new Instructions();

    public static void main(String[] args) {
       runGame();
    }
    private static int turn = 0;

    /**
     *
     */
    public static void runGame(){
        System.out.println("Do you want to play or do you want the computer to play? me/computer");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Boolean answer = false;
        if (userInput.equals("me")){
            answer = true;
        } else {
            answer = false;
        }
        do {
            CodeMaker maker = new CodeMaker();
            CodeBreaker breaker = answer ? new HumanSolver(): new SolverAlgorithm();
            if (answer == true){
                System.out.println(instructions.humanManual());
            } else{
                System.out.println(instructions.computerManual());

            }
            maker.setAnswer();
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
        } while(false); //Changed this because we meant to add something but left it out
    }
}
