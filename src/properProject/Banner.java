package properProject;

import comp127graphics.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

import static comp127graphics.FontStyle.BOLD;

public class Banner extends GraphicsGroup{

    private String humanPath = ("images/human.png");
    private String computerPath = ("images/robot.png");

    private ColorManager colorKey = new ColorManager();
    private Instructions instructions = new Instructions();

    public Banner()  {

        Image human = new Image(200,400,humanPath);
        Image computer = new Image(400,400,computerPath);

        human.setMaxHeight(80);
        computer.setMaxHeight(80);

        GraphicsGroup banner = this;

        Path path = new Path(pointGenerator());
        path.setFillColor(colorKey.toColor(8));
        path.setStrokeWidth(20);
        banner.add(path);
        banner.add(human);
        banner.add(computer);



        var wrapper = new Object(){ double ordinal = 40; };

        String str = instructions.humanManual();

        Stream<String> lines = str.lines();
        lines.forEach(out -> {
            GraphicsText text = new GraphicsText(out,20,wrapper.ordinal);
            text.setFontStyle(BOLD);
            banner.add(text);
            wrapper.ordinal+= 15;
        });

        banner.setPosition(120,120);

    }

    private List<Point> pointGenerator(){

        Point point1 = new Point(0,0);
        Point point2 = new Point(750,0);
        Point point3 = new Point(750,450);
        Point point4 = new Point(650,500);
        Point point5 = new Point(100,500);
        Point point6 = new Point(0,400);
        Point point7 = new Point(0,0);

        List<Point> pathPoints = List.of(point1,point2,point3,point4,point5,point6,point7);

        return pathPoints;
    };
}
