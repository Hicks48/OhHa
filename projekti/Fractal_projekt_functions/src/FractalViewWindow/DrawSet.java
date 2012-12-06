
package FractalViewWindow;

/**
 * Draws Set.
 * @author Henri Korpela
 */
import MyMath.Complex_Number;
import MySet.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class DrawSet extends JPanel{
    private RGB setMainColor;
    private Set set;
    private int width;
    private int heigth;
    private Complex_Number center;
    private double zoom;
    private Coloring coloring;
    private boolean ready;
    /**
     * Creates new DrawSet.
     * @param setMainColor Color which is used to color pixels whose
     * complex-number belongs to set.
     * @param backround Color which is used to color pixels whose
     * complex-number doesn't belongs to set.
     * @param set Set that is drawn.
     * @param width Width of the screen.
     * @param heigth Height of the screen.
     * @param center Complex-number that at the center of the screen.
     * @param zoom Value that tells how much picture is zoomed.
     * @param secondaryMain Color that sets color approaches
     * amount defined by used coloring algorithm.
     * @param coloringAlgorithm Tells which coloring algorithm is used.
     * @param RGBValueCheck Tells is RGB value checking enabled or not.
     */
    public DrawSet(RGB setMainColor,RGB backround,Set set,int width,int heigth,
            Complex_Number center,double zoom,RGB secondaryMain,int coloringAlgorithm,
            boolean RGBValueCheck)
    {
        Color backroundColor = new Color(backround.getRed(),backround.getGreen(),backround.getBlue());
        super.setBackground(backroundColor);
        this.setMainColor = setMainColor;
        this.set = set;
        this.heigth = heigth;
        this.width = width;
        this.center = center;
        this.zoom = zoom;
        this.ready = false;
        this.coloring = new Coloring(secondaryMain,setMainColor,coloringAlgorithm,
                set.getAccurancy(),backroundColor,RGBValueCheck);
    }
    /**
     * Colors pixel in coordinates x and y using given graphics object.
     * @param x x-coordinate of the pixel.
     * @param y y-coordinate of the pixel.
     * @param graphics Graphics object that draws on the screen.
     */
    private void putPixel(int x,int y,Graphics graphics)
    {
        graphics.fillRect(x, y,1,1);
    }
    /**
     * Draws set.
     * Goes through each pixel on the screen and checks whether
     * complex-number corresponding it's coordinates belongs
     * or doesn't belong to the set. After defining this colors
     * pixels based on coloring algorithm, membership
     * and colors.
     * @param graphics Graphics object that draws on the screen.
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {
        Color setMainColor = new Color(this.setMainColor.getRed(),this.setMainColor.getGreen(),
                this.setMainColor.getBlue());
        super.paintComponent(graphics);
        graphics.setColor(setMainColor);
        for(int y = 0;y < this.heigth;y ++)
        {
            for(int x = 0;x < this.width;x ++)
            {
                int escapes = this.set.belongsToSet(Window_Calculations.pixel(this.center,this.zoom, x, y,
                        this.heigth,this.width));
                Complex_Number[] update = this.set.updateValues();
                this.coloring.updateValues(escapes,update[1],update[0]);
                if(escapes == 0)
                {
                    this.putPixel(x,y,graphics);
                }
                else
                {
                    this.coloring.color(graphics);
                    this.putPixel(x,y,graphics);
                    graphics.setColor(setMainColor);
                }
            }
        }
        this.ready = true;
    }
    /**
     * Tells whether drawing of the set
     * is done or not.
     * @return true if drawing is done and false if isn't.
     */
    public boolean getReady()
    {
        return this.ready;
    }
}
