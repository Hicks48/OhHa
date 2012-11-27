
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
     * 
     * @param center
     * @param zoom
     * @param set
     * @param width
     * @param heigth
     * @param setMainColor
     * @param backround
     * @param secondaryMain
     * @param coloringAlgorithm
     * @param RGBValueCheck 
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
     * 
     * @return 
     */
    public JFrame getWindow()
    {
        return this.window;
    }
    /**
     * 
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
