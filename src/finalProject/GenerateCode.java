package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateCode {

    /**
     * Setup generated Code List
     */

    public static List<String> generatedCode = new ArrayList<>();

    /**
     * List of Permitted Colors
     */

    public static List<String> permittedColors = List.of("red","blue","green","yellow","purple","orange");

    public static void generateRandomCode(){
        /**
         * Make a generated code using for loop and adding permitted colors randomly
         */
        for(int i = 0; i<4 ; i++){
            generatedCode.add(randomChoice(permittedColors));
        };
    }

    /**
     * Gets the Random Choice of a Color from a List of Permitted colors
     * @param permittedColors The list of colors used in the game
     */
    public static String randomChoice(List<String> permittedColors) {
        List<String> givenList = permittedColors;
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));

        return randomElement;
    };
}
