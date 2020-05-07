package properProject;

import comp127graphics.Ellipse;


/**
 * Class that is an Orb and makes a large orb Graphics Object to be placed in a row
 */

public class LargeOrb implements Orb{
    private static ColorManager colorKey = new ColorManager();
    public double size;
    public Ellipse outputOrb;

    public LargeOrb(double size){
        this.size = size;
        makeOrb(size * 0.5);
    }

    /**
     * Creates orbs for the results that the user can put as well as the actual results of the system
     * @param size  The width of the implied ellipse from which the smile’s arc is cut.
     */
    @Override
    public void makeOrb(double size) {
        Ellipse orb = new Ellipse(0,0,size,size);
        orb.setStrokeColor(colorKey.toColor(8));
        orb.setStrokeWidth(4);
        outputOrb = orb;
    }

}
