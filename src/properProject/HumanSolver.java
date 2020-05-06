package properProject;

import java.util.Scanner;


public class HumanSolver implements CodeBreaker{

    public Scanner scanner = new Scanner(System.in);

    public HumanSolver() {
    }

    @Override
    public void receiveKey(Key key) {
    }

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
