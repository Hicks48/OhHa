/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import MySet.*;

public class Window implements Runnable{
    private int width;
    private int heigth;
    private double center;
    private double zoom;
    private Set set;
    
    private JFrame window;
    
    public Window(double center,double zoom,Set set,int width,int heigth,int xPositionIntial,int yPositionInitial)
    {
        this.set = set;
        this.zoom = zoom;
        this.center = center;
        this.heigth = heigth;
        this.width = width;
    }
    
    public JFrame getWindow()
    {
        return this.window;
    }
    
    @Override
    public void run()
    {
        this.window = new JFrame(this.set.getName());
        this.window.setPreferredSize(new Dimension(this.width,this.heigth));
        
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.window.pack();
        this.window.setVisible(true);
    }
}
