/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Panel;
import FractalViewWindow.RGB;
import FractalViewWindow.Window;
import MySet.Set;
import MyMath.Complex_Number;
/**
 *
 * @author henrikorpela
 */
public class InsertedWindowProperties {
    private RGB setMainColor;
    private RGB backroundColor;
    private RGB secondaryColor;
    private int coloringAlgorithm;
    private Complex_Number center;
    private int heigth;
    private int width;
    private double zoom;
    private boolean RGBValueCheck;
    
    public InsertedWindowProperties()
    {
        this.setMainColor = null;
        this.backroundColor = null;
        this.secondaryColor = null;
        this.coloringAlgorithm = -1;
        this.center = null;
        this.heigth = -1;
        this.width = -1;
        this.zoom = -1.0;
        this.RGBValueCheck = false;
    }
    
    private Complex_Number contructCenter(String center)
    {
        return null;
    }
    
    private boolean checkRGB(int red,int green,int blue)
    {
        if(red < 0)
        {
            return false;
        }
        if(green < 0)
        {
            return false;
        }
        if(blue < 0)
        {
            return false;
        }
        return true;
    }
    
    public Window createWindow(Set set)
    {
        return new Window(this.center,this.zoom,set,this.width,this.heigth,this.setMainColor,
                this.backroundColor,this.secondaryColor,this.coloringAlgorithm,this.RGBValueCheck);
    }
    
    public void clear()
    {
        this.setMainColor = null;
        this.backroundColor = null;
        this.secondaryColor = null;
        this.coloringAlgorithm = -1;
        this.heigth = -1;
        this.width = -1;
        this.zoom = -1.0;
    }
    
    public void setRGBValueCheck(boolean RGBValueCheck)
    {
        this.RGBValueCheck = RGBValueCheck;
    }
    
    public boolean setCenter(String center)
    {
        Complex_Number toBeChecked = this.contructCenter(center);
        if(center == null)
        {
            return false;
        }
        this.center = toBeChecked;
        return true;
    }
    
    public void setColoringAlgorithm(int coloringAlgorithm)
    {
        this.coloringAlgorithm = coloringAlgorithm;
    }
    
    public boolean setHeigth(int heigth)
    {
        if(heigth <= 0)
        {
            return false;
        }
        this.heigth = heigth;
        return true;
    }
    
    public boolean setWidth(int width)
    {
        if(width <= 0)
        {
            return false;
        }
        this.width = width;
        return true;
    }
    
    public boolean setZoom(double zoom)
    {
        if(zoom <= 0)
        {
            return false;
        }
        this.zoom = zoom;
        return true;
    }
    
    public boolean setMainColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.setMainColor = new RGB(red,green,blue);
        return true;
    }
    
    public boolean secondaryColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.secondaryColor = new RGB(red,green,blue);
        return true;
    }
    
    public boolean backroundColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.backroundColor = new RGB(red,green,blue);
        return true;
    }
}
