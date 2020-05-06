package properProject;

import java.util.Scanner;

/**
 * Class that makes a CodeMaker object to build the code to be guessed against
 */

public class CodeMaker {

        private Code answer;
        private Scanner scanner;


    /**
     * Empty constructor that we will call methods off of
     */

        public CodeMaker() {
        }


    /**
     * Method to set the maker's random code to the answer
     */

    public void setAnswer() {
        answer = new Code();
        System.out.println("Enter secret code: ");
    }


    /**
     * Class that gets the code from the maker
     */

    public Code getAnswer() {
        return answer;
    }

    /**
     * Verifies that the code by the maker is the same as the original correct code
     * @param guess  The guess by the maker
     */

    public Key verify(Code guess) {
        return answer.getKey(guess);
    }

    }

