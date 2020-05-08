package properProject;

import comp127graphics.*;
import java.util.*;
import java.util.stream.Stream;

import static comp127graphics.FontStyle.BOLD;

/**
 * Popup banner that is a child of popup class. Used to display instructions
 */

public class Banner extends Popup{

    private String humanPath = ("images/human.png");
    private String computerPath = ("images/robot.png");

    private String words;

    /**
     * Empty constructor that makes a Banner object
     */
    public Banner()  {

        Instructions instructions = new Instructions();
        this.words = instructions.humanManual();

        GraphicsGroup banner = this;

        Image human = new Image(200,400,humanPath);
        Image computer = new Image(400,400,computerPath);

        human.setMaxHeight(80);
        computer.setMaxHeight(80);

        Path path = new Path(makePoly());
        path.setFillColor(WHITE);
        path.setStrokeColor(BLUE);
        path.setStrokeWidth(20);
        banner.add(path);
        banner.add(human);
        banner.add(computer);

        configureText(banner);

        banner.setPosition(120,120);

    }

    /**
     * Makes a polygon path as a List of Points
     * @return List of points to be used to generate a Graphics path object
     */

    @Override
    public List<Point> makePoly(){

        Point point1 = new Point(0,0);
        Point point2 = new Point(750,0);
        Point point3 = new Point(750,450);
        Point point4 = new Point(650,500);
        Point point5 = new Point(100,500);
        Point point6 = new Point(0,400);
        Point point7 = new Point(0,0);

        return List.of(point1,point2,point3,point4,point5,point6,point7);
    }

    /**
     * Function to make a rectangle for the backround. Not used here
     */

    @Override
    public Rectangle makeBack() {
        return null;
    }

    /**
     * Function to make a stream of GraphicsText objects to be added to banner
     * @param group  The group that the lines are added to
     */

    @Override
    public void configureText(GraphicsGroup group) {
        var wrapper = new Object(){ double ordinal = 40; };

        Stream<String> lines = words.lines();
        lines.forEach(out -> {
            GraphicsText text = new GraphicsText(out,20,wrapper.ordinal);
            text.setFontStyle(BOLD);
            group.add(text);
            wrapper.ordinal+= 15;
        });
    }

    /**
     * Function that sets the text of a specific GraphicsText object
     */

    @Override
    public void setText(String words) {
    }
}
