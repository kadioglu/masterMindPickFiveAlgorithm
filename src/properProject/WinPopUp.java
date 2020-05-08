package properProject;

import comp127graphics.*;

import java.util.List;


public class WinPopUp extends Popup{

    String words;
    private GraphicsText text = new GraphicsText(words,380,380);

    public WinPopUp(String words){
        this.words = words;
        this.add(makeBack());
        setText(words);
        configureText(this);
    }

    /**
     * Function that makes a background that is a rectangle
     * @return Rectangle the rectangle GraphicsObject
     */

    @Override
    public Rectangle makeBack() {
        Rectangle background = new Rectangle(350,350,200,50);
        background.setFillColor(WHITE);
        background.setStrokeWidth(10);
        background.setStrokeColor(BLUE);
        return background;
    }

    /**
     * Function that makes a path of points to be used to make a backgroudn as a Path object
     * @return List<Point> a list of points graphics objects
     */

    @Override
    public List<Point> makePoly() {
        return null;
    }

    //

    /**
     * Function that takes a text and adds it to a graphics group after configuring it
     * @param group the graphics group to have text added to
     */

    @Override
    public void configureText(GraphicsGroup group) {
        text.setFontStyle(FontStyle.BOLD);
        group.add(text);
    }

    /**
     * Function that sets the text of a GraphicsText object
     * @param words the String of words
     */

    public void setText(String words) {
        text.setText(words);
    }



}
