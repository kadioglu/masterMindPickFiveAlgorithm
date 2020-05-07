package properProject;

import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.List;

/**
 * Absract Class that is a Graphics Group and contains popup graphics groups
 */

public abstract class Popup extends GraphicsGroup {

    protected ColorManager colorKey = new ColorManager();
    protected Color WHITE = colorKey.toColor(7);
    protected Color BLACK = colorKey.toColor(8);
    protected Color GREY = colorKey.toColor(9);


    /**
     * Function that makes a background that is a rectangle
     * @return Rectangle the rectangle GraphicsObject
     */

    public abstract Rectangle makeBack();

    /**
     * Function that makes a path of points to be used to make a backgroudn as a Path object
     * @return List<Point> a list of points graphics objects
     */

    public abstract List<Point> makePoly();

    /**
     * Function that takes a text and adds it to a graphics group after configuring it
     * @param group the graphics group to have text added to
     */

    public abstract void configureText(GraphicsGroup group);

    /**
     * Function that sets the text of a GraphicsText object
     * @param words the String of words
     */

    public abstract void setText(String words);

    }
