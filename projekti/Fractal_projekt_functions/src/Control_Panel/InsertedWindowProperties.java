
package Control_Panel;
import FractalViewWindow.RGB;
import FractalViewWindow.Window;
import MySet.Set;
import MyMath.Complex_Number;
import MyMath.Construction;
/**
 * Contains all information that is needed to
 * construct window.
 * @author Henri Korpela
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
    /**
     * Creates new InsertedWindowProperties
     * object and initializes all
     * properties with impossible values.
     */
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
    /**
     * Constructs complex-number that is at the center of the window
     * from given String.
     * @param center String containing information
     * that complex-number that is at the center of the window
     * is constructed from.
     * @return complex-number that is at the center of the window.
     */
    private Complex_Number contructCenter(String center)
    {
        try
        {
            Complex_Number centerNum = MyMath.Construction.construct(center);
            return centerNum;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    /**
     * Checks that given RGB values are valid.
     * @param red red RGB value.
     * @param green green RGB value.
     * @param blue blue RGB value.
     * @return true if values are valid
     * and false if values aren't valid.
     */
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
    /**
     * Crates new window that given set is drawn.
     * @param set set that is drawn on the window.
     * @return Created window.
     */
    public Window createWindow(Set set)
    {
        return new Window(this.center,this.zoom,set,this.width,this.heigth,this.setMainColor,
                this.backroundColor,this.secondaryColor,this.coloringAlgorithm,this.RGBValueCheck);
    }
    /**
     * Initializes all variables with
     * impossible values.
     */
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
    /**
     * Sets RGBValueCheck.
     * @param RGBValueCheck
     */
    public void setRGBValueCheck(boolean RGBValueCheck)
    {
        this.RGBValueCheck = RGBValueCheck;
    }
    /**
     * Sets complex-number that is at the
     * center of the window.
     * @param center
     * @return true if String containing information
     * for construction of the center is valid and
     * false if it wasn't.
     */
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
    /**
     * 
     * @param coloringAlgorithm 
     */
    public void setColoringAlgorithm(int coloringAlgorithm)
    {
        this.coloringAlgorithm = coloringAlgorithm;
    }
    /**
     * 
     * @param heigth
     * @return 
     */
    public boolean setHeigth(int heigth)
    {
        if(heigth <= 0)
        {
            return false;
        }
        this.heigth = heigth;
        return true;
    }
    /**
     * 
     * @param width
     * @return 
     */
    public boolean setWidth(int width)
    {
        if(width <= 0)
        {
            return false;
        }
        this.width = width;
        return true;
    }
    /**
     * 
     * @param zoom
     * @return 
     */
    public boolean setZoom(double zoom)
    {
        if(zoom <= 0)
        {
            return false;
        }
        this.zoom = zoom;
        return true;
    }
    /**
     * 
     * @param red
     * @param green
     * @param blue
     * @return 
     */
    public boolean setMainColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.setMainColor = new RGB(red,green,blue);
        return true;
    }
    /**
     * 
     * @param red
     * @param green
     * @param blue
     * @return 
     */
    public boolean secondaryColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.secondaryColor = new RGB(red,green,blue);
        return true;
    }
    /**
     * 
     * @param red
     * @param green
     * @param blue
     * @return 
     */
    public boolean backroundColor(int red,int green,int blue)
    {
        if(!this.checkRGB(red,green,blue))
        {
            return false;
        }
        this.backroundColor = new RGB(red,green,blue);
        return true;
    }
    /**
     * 
     * @return 
     */
    public String save()
    {
        String RGBValueCheck = "true";
        if(this.RGBValueCheck == false)
        {
            RGBValueCheck = "false";
        }
        return this.center.save() + ":" + this.width + ":" + this.heigth + ":" +
                this.zoom + ":" + this.setMainColor.save() + ":" + 
                this.secondaryColor.save() + ":" + this.backroundColor.save() +
                ":" + this.coloringAlgorithm + ":" + RGBValueCheck;
    }
}
