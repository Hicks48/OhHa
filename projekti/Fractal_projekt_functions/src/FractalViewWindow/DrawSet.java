/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
 */
import MyMath.Complex_Number;
import MySet.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class DrawSet extends JPanel{
    private Color setMainColor;
    private Set set;
    private int width;
    private int heigth;
    private Complex_Number center;
    private double zoom;
    private Color highLigthColor;
    
    public DrawSet(Color setMainColor,Color backround,Set set,int width,int heigth,
            Complex_Number center,double zoom,Color highLigthColor)
    {
        super.setBackground(backround);
        this.setMainColor = setMainColor;
        this.set = set;
        this.heigth = heigth;
        this.width = width;
        this.center = center;
        this.zoom = zoom;
        this.highLigthColor = highLigthColor;
    }
    
    private void putPixel(int x,int y,Graphics graphics)
    {
        graphics.fillRect(x, y,1,1);
    }
    
    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        graphics.setColor(this.setMainColor);
        for(int y = 0;y < this.heigth;y ++)
        {
            for(int x = 0;x < this.width;x ++)
            {
                int escapes = this.set.belongsToSet(Window_Calculations.pixel(this.center,this.zoom, x, y,
                        this.heigth,this.width));
                if(escapes == 0)
                {
                    putPixel(x,y,graphics);
                }
            }
        }
    }
}
