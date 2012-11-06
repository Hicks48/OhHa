/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Coloring {
    
    private static Color hihgLigth(RGB rgp,int accuracy,int escape,int stepValue)
    {
        return new Color(0,0,0);
    }
    
    public static void higligthEdges(Color color,int escape,int accuracy,Graphics graphics)
    {
        RGB rgb;
        if(Color.GREEN.equals(color))
        {
            rgb = new RGB(0,150,0); // red green blue
        }
        else if(Color.ORANGE.equals(color))
        {
            rgb = new RGB(250,150,0);
        }
        else if(Color.RED.equals(color))
        {
            rgb = new RGB(150,0,0);
        }
        else if(Color.YELLOW.equals(color))
        {
            rgb = new RGB(150,150,0);
        }
        else
        {
            rgb = new RGB(0,0,150);
        }
        graphics.setColor(hihgLigth(rgb,accuracy,escape,0));
    }
}
