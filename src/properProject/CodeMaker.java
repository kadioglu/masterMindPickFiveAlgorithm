package properProject;

import java.util.Scanner;

public class CodeMaker {

        private Code answer;
        private Scanner scanner;

        public CodeMaker() {
        }

    public void setAnswer() {
        answer = new Code();
        System.out.println("Enter secret code: ");
    }

    public Code getAnswer() {
        return answer;
    }

    public Key verify(Code guess) {
        return answer.getKey(guess);
    }

    }

