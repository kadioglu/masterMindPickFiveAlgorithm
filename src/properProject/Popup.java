package properProject;

import comp127graphics.GraphicsGroup;
import comp127graphics.Rectangle;
import comp127graphics.GraphicsText;



import java.awt.*;

public abstract class Popup extends GraphicsGroup {

    private ColorManager colorKey = new ColorManager();
    protected Color WHITE = colorKey.toColor(8);
    protected Color ORANGE = colorKey.toColor(3);

    public abstract Rectangle makeBack();
    public abstract GraphicsText makeText(String words);
    public abstract void setText(String words);

    }
