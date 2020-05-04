package projectTest;

import java.util.*;

public class Mastermind {

    /**
     * Setup Variables to Hold the total number of colors from the Generated code
     * */
    public static int genReds, genBlues, genGreens, genPurples, genYellows, genOranges, current, total;

    /**
     * Setup Variables to Hold the total number of colors
     * from the users code which were correct positionally (completely correct)
     * and by color so we can assign black pegs
     * */
    public static int userReds, userBlues, userGreens, userPurples, userYellows, userOranges;

    /**
     * Setup Variables to Hold the total number of colors
     * from the users code were only correct by color and (partially correct)
     * handle duplicates since we only care about color
     * and will be assigned white pegs
     * */
    public static int whReds, whBlues, whGreens, whPurples, whYellows, whOranges, totalWhites;


    /**
     * Make an empty list to hold the user's code as well as the result code
     * that contains the white and black balls as answers to the system
     */

    public static List<String> userCode = new ArrayList<>();
    public static List<String> resultCode = new ArrayList<>();

    /**
     * Removes the Last Character of a String
     * @param s The input string
     */
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }



    /**
     * Main Method
     */


    public static void runGame(){

        /**
         * Create Scanner and Give instructions
         */

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        /**
         * Ask user for their colors and insert them into the user code list
         */

        for(int i=1; i<5; i++){
            System.out.println("Please Select your number " + i + " color");
            String userColor = scanner.nextLine();  // Read user input
            userCode.add(userColor + i);
        }

        System.out.println("User Code:" + userCode);

        /**
         * Count number of each type of ball by color in the generated code
         */

        for (String g : GenerateCode.generatedCode){
            switch(g){
                case("red"):
                    genReds ++;
                    break;
                case("blue"):
                    genBlues ++;
                    break;
                case("green"):
                    genGreens ++;
                    break;
                case("orange"):
                    genOranges ++;
                    break;
                case("yellow"):
                    genYellows ++;
                    break;
                case("purple"):
                    genPurples ++;
                    break;
            }
        }

        /**
         * Find out the number of black balls and add them to the result code. The
         * black balls are determined by looking at the position of each ball in the user
         * code and checking if the corresponding position in the generated code is correct
         * During this, update the number of each type of ball the user guessed completely correctly
         */

        for (String u : userCode){
            int indexOfU = userCode.indexOf(u);
            u =  removeLastChar(u);
            String g = GenerateCode.generatedCode.get(indexOfU);

            if ( u.equals(g)){
                resultCode.add("Black");

                switch(u){
                    case("red"):
                        userReds ++;
                        current = userReds;
                        total = genReds;
                        break;
                    case("blue"):
                        userBlues ++;
                        current = userBlues;
                        total = genBlues;
                        break;
                    case("green"):
                        userGreens ++;
                        current = userGreens;
                        total = userGreens;
                        break;
                    case("orange"):
                        userOranges ++;
                        current = userOranges;
                        total = userOranges;
                        break;
                    case("yellow"):
                        userYellows ++;
                        current = userYellows;
                        total = genYellows;
                        break;
                    case("purple"):
                        userPurples ++;
                        current = userPurples;
                        total = genPurples;
                        break;
                }
            }
            else {
                ;
            }
        }

        /**
         * Using the number of already correctly assigned balls of each color, then determine how many
         * are left partially correct and assign them a white ball. add this to the list. of the result code
         */

        for (String u : userCode){

            int indexOfU = userCode.indexOf(u);
            u =  removeLastChar(u);
            String g = GenerateCode.generatedCode.get(indexOfU);
            int indexOfG = GenerateCode.generatedCode.indexOf(g);

            System.out.println("u:" + u);
            System.out.println("g:" + g);
            System.out.println("uindex:" + indexOfU);
            System.out.println("gindex:" + indexOfG);

            System.out.println("current:" + current);
            System.out.println("total:" + total);

            switch(u){
                case("red"):
                    totalWhites = whReds;
                    current = userReds;
                    total = genReds;
                    break;
                case("blue"):
                    totalWhites = whBlues;
                    current = userBlues;
                    total = genBlues;
                    break;
                case("green"):
                    totalWhites = whGreens;
                    current = userGreens;
                    total = userGreens;
                    break;
                case("orange"):
                    totalWhites = whOranges;
                    current = userOranges;
                    total = userOranges;
                    break;
                case("yellow"):
                    totalWhites = whYellows;
                    current = userYellows;
                    total = genYellows;
                    break;
                case("purple"):
                    totalWhites = whPurples;
                    current = userPurples;
                    total = genPurples;
                    break;
            }

            if(GenerateCode.generatedCode.contains(u) && current == total){
                ;
            }
            else if (GenerateCode.generatedCode.contains(u) && totalWhites < total){
                resultCode.add("White");

                switch(u){
                    case("red"):
                        whReds++;
                        break;
                    case("blue"):
                        whBlues++;
                        break;
                    case("green"):
                        whGreens++;
                        break;
                    case("orange"):
                        whOranges++;
                        break;
                    case("yellow"):
                        whYellows++;
                        break;
                    case("purple"):
                        whPurples++;
                        break;
                }
            }
            else{
                resultCode.add("Null");

            }

        }

        /**
         * Print the result code
         */

        System.out.println("result Code:" + resultCode);

    }










}
