package finalProject;

import comp127graphics.*;

import java.awt.Color;
import java.util.*;

import static comp127graphics.FontStyle.BOLD;

@SuppressWarnings("WeakerAccess")
public class Game {
    private static final Color
            BLACK = new Color(0x000000),
            WHITE = new Color(0xFFFFFF),
            PURPLE = new Color(0x9934ff),
            RED = new Color(0xFF3334),
            BLUE =new Color(0x33ccfe),
            GREEN =  new Color(0x34ff32),
            YELLOW =new Color(0xFFDE30),
            GREY = new Color(0x777777),
            ORANGE =new Color(0xF45F11);


    public static double nextRow;
    public static double spacing = 30;
    private static List<Color> userColors = new ArrayList<>();
    private static List<Color> resultColors = new ArrayList<>();
    private static List<GraphicsGroup> myRows = new ArrayList<>();
    private static List<Color> emptyOrbs = List.of(WHITE,WHITE,WHITE,WHITE);

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("MasterMind", 1000, 800);

        int size = 100;

        for (int i=1;i<=10;i++) {
            GraphicsGroup Row = Board.createRow(size, i, emptyOrbs,emptyOrbs);
            Row.setPosition(50, 0 + nextRow);
            nextRow += 30 + spacing;
            myRows.add(Row);
            canvas.add(Row);
        }

        nextRow = 0;

        canvas.setBackground(WHITE);
        canvas.draw();

        Instructions.printInstructions();
        GenerateCode.generateRandomCode();
        System.out.println("Generated Code:" + GenerateCode.generatedCode);

        for (int i=1; i <= 10; i++){

            Mastermind.runGame();

            /*
            * Color Converter For Strings to Color Objects
             */

            //                String currentColor = Mastermind.removeLastChar(Mastermind.userCode.get(i)).toLowerCase();

            for (String chosenColor : Mastermind.userCode) {
                String currentColor = Mastermind.removeLastChar(chosenColor).toLowerCase();
                System.out.println(currentColor);
                switch (currentColor) {
                    case ("red"):
                        userColors.add(RED);
                        break;
                    case ("blue"):
                        userColors.add(BLUE);
                        break;
                    case ("green"):
                        userColors.add(GREEN);
                        break;
                    case ("orange"):
                        userColors.add(ORANGE);
                        break;
                    case ("yellow"):
                        userColors.add(YELLOW);
                        break;
                    case ("purple"):
                        userColors.add(PURPLE);
                        break;
                }
            }

            for (String resultingColor : Mastermind.resultCode) {
                String result = resultingColor;
                System.out.println(resultingColor);
                switch (result) {
                    case ("Black"):
                        resultColors.add(BLACK);
                        break;
                    case ("White"):
                        resultColors.add(WHITE);
                        break;
                    case ("Null"):
                        resultColors.add(GREY);
                        break;
                }
            }

            System.out.println(userColors);
            System.out.println(resultColors);

            GraphicsGroup Row = Board.createRow(size, i, userColors, resultColors);
            Row.setPosition(50, 0 + nextRow);
            nextRow += 30 + spacing;
            myRows.add(Row);
            canvas.add(Row);
            canvas.draw();

            if (Mastermind.userCode == Mastermind.resultCode){
                System.out.println("Congrats You have Won!");
            }
            else if(i == 10 ){
                System.out.println("This is your last Try");
            }
            else {
                System.out.println("Try Again!");
            }
            Mastermind.userCode.clear();
            Mastermind.resultCode.clear();
            userColors.clear();
            resultColors.clear();
        }
    }

}

