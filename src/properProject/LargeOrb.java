package properProject;

import comp127graphics.Ellipse;
//
public class LargeOrb implements Orb{
    private static Key colorKey;
    public double size;
    public Ellipse outputOrb;

    public LargeOrb(double size){
        this.size = size;
        makeOrb(size);
    }

    /**
     * Creates orbs for the results that the user can put as well as the actual results of the system
     * @param size  The width of the implied ellipse from which the smile’s arc is cut.
     */
    @Override
    public void makeOrb(double size) {
        Ellipse orb = new Ellipse(0,0,size,size);
        orb.setStrokeColor(colorKey.toColor(7));
        orb.setStrokeWidth(1);
        outputOrb = orb;
    }

}

///