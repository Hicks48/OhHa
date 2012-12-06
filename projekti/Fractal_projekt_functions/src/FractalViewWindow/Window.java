
package FractalViewWindow;

/**
 * Creates screen which set is drawn.
 * @author Henri Korpela
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.WindowConstants;
import MySet.*;
import MyMath.Complex_Number;

public class Window implements Runnable{
    private int width;
    private int heigth;
    private String name;
    private DrawSet drawSet;
    private JFrame window;
    /**
     * Creates new window.
     * @param center Complex-number that is at the center of the window.
     * @param zoom Value of zoom of the window.
     * @param set Set that is drawn on the window.
     * @param width Width of the window.
     * @param heigth Height of the window.
     * @param setMainColor Color that the set is colored with.
     * @param backround Color that is used as windows background color. 
     * @param secondaryMain Secondary color for the set. Secondary color
     * is the color that main color approaches amount defined 
     * by coloring algorithm.
     * @param coloringAlgorithm Integer value that defines which 
     * coloring algorithm is used.
     * @param RGBValueCheck Boolean value that defines whether
     * RGB value check is used or not.
     */
    public Window(Complex_Number center,double zoom,Set set,int width,int heigth,
            RGB setMainColor,RGB backround,
            RGB secondaryMain,int coloringAlgorithm,boolean RGBValueCheck)
    {
        this.heigth = heigth;
        this.name = set.getName();
        this.width = width;
        this.drawSet = new DrawSet(setMainColor,backround,set,this.width,this.heigth,center,zoom,
                secondaryMain,coloringAlgorithm,RGBValueCheck);
    }
    /**
     * Return DrawSet of this window.
     * @return DrawSet of this window.
     */
    public DrawSet isReady()
    {
        return this.drawSet;
    }
    /**
     * Return this windows JFrame.
     * @return this JFrame.
     */
    public JFrame getWindow()
    {
        return this.window;
    }
    /**
     * Runs window and keeps it visible.
     */
    @Override
    public void run()
    {
        this.window = new JFrame(this.name);
        this.window.setPreferredSize(new Dimension(this.width,this.heigth));
        
        this.window.getContentPane().add(this.drawSet);
        this.window.pack();
        this.window.setVisible(true);
    }
}
