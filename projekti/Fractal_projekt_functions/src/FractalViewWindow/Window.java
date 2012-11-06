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
    
    public Window(Complex_Number center,double zoom,Set set,int width,int heigth,
            int xPositionIntial,int yPositionInitial,Color setMainColor,Color backround,
            Color highLigthColor)
    {
        this.heigth = heigth;
        this.name = set.getName();
        this.width = width;
        this.drawSet = new DrawSet(setMainColor,backround,set,this.width,this.heigth,center,zoom,
                highLigthColor);
    }
    
    public JFrame getWindow()
    {
        return this.window;
    }
    
    @Override
    public void run()
    {
        this.window = new JFrame(this.name);
        this.window.setPreferredSize(new Dimension(this.width,this.heigth));
        
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.getContentPane().add(this.drawSet);
        this.window.pack();
        this.window.setVisible(true);
    }
}
