/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
 */
public class RGB {
    private final int red;
    private final int green;
    private int blue;
    
    public RGB(int red,int green,int blue)
    {
        this.blue = blue;
        this.green = green;
        this.red = red;
    }
    
    public int getRed()
    {
        return this.red;
    }
    
    public int getGreen()
    {
        return this.green;
    }
    
    public int getBlue()
    {
        return this.blue;
    }
}
