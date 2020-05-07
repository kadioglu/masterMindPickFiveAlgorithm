package properProject;

import comp127graphics.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


/**
 * Controls the entire game and contains the main graphics elements in the game
 */

public class GameManager {


    /**
     * Create some new audio clips for future use
     */

    AudioClip music = null;
    AudioClip ping = null;
    AudioClip pong = null;

    /**
     * GameManager constructor
     * @param canvas The canvas window to add objects to
     * @param banner the new banner of instructions to display
     * @param board a board object containing the rows in the game
     * @param size the sizes to be used by the board object to make new rows of specific size
     */

    public GameManager(CanvasWindow canvas, Banner banner, Board board, int size){
        loadSounds();
        ping.play();

        canvas.onClick( e -> {

            Point currentPosition = e.getPosition();
           GraphicsObject currentObject= canvas.getElementAt(currentPosition);


           if(currentObject != null){
               System.out.println(currentObject);
               if(currentObject.toString().equals("Image at position (400.0, 400.0) with file images/robot.png")){
                   ping.play();
                   Boolean answer = false;
                   canvas.remove(banner);
                   canvas.draw();
                   handleClick(canvas,answer,board,size);

               }
               else if(currentObject.toString().equals("Image at position (200.0, 400.0) with file images/human.png")){
                   ping.play();
                   Boolean answer = true;
                   canvas.remove(banner);
                   canvas.draw();
                   handleClick(canvas,answer,board,size);

               }
           }
        });
    }

    /**
     * Function that handles the user's clicking the human and robot images on the banner
     * It also starts the game based on the users click event position
     * @param canvas The canvas window to add objects to
     * @param answer a boolean stating wether the player wants to play or not
     * @param board a board object containing the rows in the game
     * @param size the sizes to be used by the board object to make new rows of specific size
     */

    private void handleClick(CanvasWindow canvas, Boolean answer, Board board, int size){

        var wrapper = new Object(){ int turn = 0; };
        Instructions instructions = new Instructions();

        if (answer == false){
            System.out.println(instructions.computerManual());
        }

        CodeMaker maker = new CodeMaker();
        CodeBreaker breaker = answer ? new HumanSolver(): new SolverAlgorithm();

        maker.setAnswer();
        Key response = null;

        do {
            System.out.println("========Turn " + ++wrapper.turn + "========");
            Code guess = breaker.guess();
            response = maker.verify(guess);
            System.out.println("Response: " + response);
            breaker.receiveKey(response);

            java.util.List<Color> resultColors = response.toColor();
            List<Color> myColors = guess.makeColorList();
            board.makeNewRow(size,canvas,wrapper.turn,myColors,resultColors);
            canvas.draw();
            myColors.clear();

            ping.play();

            if(wrapper.turn > 9){
                break;
            }

        } while (!response.isCorrect());
        WinPopUp win = new WinPopUp("");

        if (response.isCorrect()) {
            win.setText("You Win (◕‿◕✿)");
            canvas.add(win);
            canvas.draw();
            System.out.println();
            System.out.println("========Winner========");
            System.out.println("Answer: " + maker.getAnswer());
            System.out.println("Turns: " + wrapper.turn);
            System.out.println("You won! (◕‿◕✿)");
            ping.play();

        } else{
            win.setText("You Lose (ಠ╭╮ಠ)");
            canvas.add(win);
            canvas.draw();
            System.out.println();
            System.out.println("========Loser========");
            System.out.println("Answer: " + maker.getAnswer());
            System.out.println("Turns: " + wrapper.turn);
            System.out.println("You Lost! (ಠ╭╮ಠ)");
            pong.play();

        }

    }

    public void loadSounds()
    {

        try
        {
            URL musicURL = new URL(  "https://cdn.glitch.com/002aac9a-9210-496a-b725-bbb12ba7f4e9%2Fbensound-smallguitar%20(1).wav?v=1587531089488");
            URL pingURL = new URL( "https://cdn.glitch.com/002aac9a-9210-496a-b725-bbb12ba7f4e9%2F446111__justinvoke__success-jingle%20(1).wav?v=1587531080755");
            URL pongURL = new URL( "https://cdn.glitch.com/002aac9a-9210-496a-b725-bbb12ba7f4e9%2FElectronic_Chime-KevanGC-495939803.wav?v=1587001930682");

            music = Applet.newAudioClip(musicURL);
            ping = Applet.newAudioClip(pingURL);
            pong = Applet.newAudioClip(pongURL);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

}
