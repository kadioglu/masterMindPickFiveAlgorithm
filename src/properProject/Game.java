package properProject;

public class Game {

    public static void main(String[] args) {
        System.out.println("========Settings========");
        System.out.println();
        System.out.println("========Directions========");
        System.out.println("Enter a 4 digit number with each digit ranging from 0 to 5");
        do {
            CodeMaker maker = new CodeMaker();
            CodeBreaker breaker = new HumanSolver();
            System.out.println();
            maker.setAnswer();
            System.out.println("Answer: " + maker.getAnswer());
            System.out.println();
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
            System.out.println("You won!");
        } while(false);
    }


}
