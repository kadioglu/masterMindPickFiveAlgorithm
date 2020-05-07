package properProject;
//
import comp127graphics.Ellipse;

/**
 * Implements the Orb interface and creates a graphics object that is an ellipse
 */
public class SmallOrb implements Orb{
    private static ColorManager colorKey = new ColorManager();
    public double size;
    public Ellipse outputOrb;

    public SmallOrb(double size){
        this.size = size;
        makeOrb(size * 0.2);
    }
    /**
     * Creates orbs for the results that the user can put as well as the actual results of the system
     * @param size  The width of the implied ellipse from which the smile’s arc is cut.
     */
    @Override
    public void makeOrb(double size){
        Ellipse orb = new Ellipse(0,0,size,size);
        orb.setFillColor(colorKey.toColor(9));
        orb.setStrokeColor(colorKey.toColor(8));
        orb.setStrokeWidth(2);
        outputOrb = orb;
    }
}

