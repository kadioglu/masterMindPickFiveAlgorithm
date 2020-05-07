package properProject;

import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.List;

public abstract class Popup extends GraphicsGroup {

    private ColorManager colorKey = new ColorManager();
    protected Color WHITE = colorKey.toColor(8);

    public abstract Rectangle makeBack();
    public abstract List<Point> makePoly();
    public abstract void configureText(GraphicsGroup group);
    public abstract void setText(String words);

    }
