package properProject;

import java.util.Scanner;


/**
 * Solver that allows a human to input Code. Child of CodeBreaker Interface
 */

public class HumanSolver implements CodeBreaker{

    public Scanner scanner = new Scanner(System.in);


    /**
     * Empty Constructor to call methods off of
     */

    public HumanSolver() {
    }


    /**
     * Function that makes the key and to be used for the solver. Empty here
     * @param key  the key object
     */

    @Override
    public void receiveKey(Key key) {
    }

    /**
     * Function that gets user scanner input and turns it into a code object
     * @return Returns a code object
     */

    @Override
    public Code guess() {
        String input;
        do {
            System.out.println("Enter secret code: ");
            input = scanner.nextLine();
        } while (!Code.isValid(input));
        return new Code(input);
    }
}
