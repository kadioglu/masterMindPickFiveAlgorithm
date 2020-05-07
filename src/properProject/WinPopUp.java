package properProject;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsText;
import comp127graphics.Rectangle;

public class WinPopUp extends Popup{

    private CanvasWindow canvas;
    private GraphicsText text = new GraphicsText();

    public WinPopUp(String words, CanvasWindow canvas){
        this.canvas = canvas;
        this.add(text);
        this.add(makeText(words));
    }

    @Override
    public Rectangle makeBack() {
        Rectangle background = new Rectangle(canvas.getWidth()/2,canvas.getHeight()/2,200,300);
        background.setFillColor(super.WHITE);
        background.setStrokeWidth(4);
        return background;
    }

    @Override
    public GraphicsText makeText(String words) {
        text.setFillColor(super.ORANGE);
        return text;
    }

    public void setText(String words){
        text.setText(words);
    }



}
