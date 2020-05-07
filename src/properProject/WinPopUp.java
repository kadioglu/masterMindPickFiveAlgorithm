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

    @Override
    public Rectangle makeBack() {
        Rectangle background = new Rectangle(350,350,200,50);
        background.setFillColor(super.WHITE);
        background.setStrokeWidth(10);
        return background;
    }

    @Override
    public List<Point> makePoly() {
        return null;
    }

    @Override
    public void configureText(GraphicsGroup group) {
        text.setFontStyle(FontStyle.BOLD);
        group.add(text);
    }

    public void setText(String words) {
        text.setText(words);
    }



}
