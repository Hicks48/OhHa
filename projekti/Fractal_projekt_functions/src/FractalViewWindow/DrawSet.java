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
    private RGB setMainColor;
    private Set set;
    private int width;
    private int heigth;
    private Complex_Number center;
    private double zoom;
    private Coloring coloring;
    
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
        this.coloring = new Coloring(secondaryMain,setMainColor,coloringAlgorithm,
                set.getAccurancy(),backroundColor,RGBValueCheck);
    }
    
    private void putPixel(int x,int y,Graphics graphics)
    {
        graphics.fillRect(x, y,1,1);
    }
    
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
    }
}
