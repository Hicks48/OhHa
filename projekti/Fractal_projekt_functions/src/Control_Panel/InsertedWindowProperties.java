
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
        if(red < 0 || red > 255)
        {
            return false;
        }
        if(green < 0 || green > 255)
        {
            return false;
        }
        if(blue < 0 || blue > 255)
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
     * invalid values.
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
     * @param RGBValueCheck boolean that
     * tells whether RGBValueCheck is
     * enabled or not.
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
        Complex_Number toBeChecked;
        toBeChecked = this.contructCenter(center);       
        if(toBeChecked == null)
        {
            return false;
        }
        this.center = toBeChecked;
        return true;
    }
    /**
     * Sets coloring algorithm
     * that is used.
     * @param coloringAlgorithm coloring algorithm
     * that is set.
     */
    public void setColoringAlgorithm(int coloringAlgorithm)
    {
        this.coloringAlgorithm = coloringAlgorithm;
    }
    /**
     * Sets height of the window.
     * @param heigth height of the window
     * in pixels.
     * @return true if height is
     * valid and false if isn't.
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
     * Sets width of the window.
     * @param width width of the screen
     * in pixels.
     * @return true if width is valid
     * and false if isn't.
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
     * Sets zoom.
     * @param zoom windows zoom.
     * @return true if zoom value
     * is valid and false if isn't.
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
     * Set main color.
     * @param red Red RGB value.
     * @param green Green RGB value.
     * @param blue Blue RGB value.
     * @return true if main color values
     * are valid and false if aren't.
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
     * Sets secondary color.
     * @param red Red RGB value.
     * @param green Green RGB value.
     * @param blue Blue RGB value.
     * @return true if secondary color values
     * are valid and false if aren't.
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
     * Sets background color.
     * @param red Red RGB value.
     * @param green Green RGB value.
     * @param blue Blue RGB value.
     * @return true if background color values
     * are valid and false if aren't.
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
     * Return String that is used to save
     * window properties.
     * @return String that is saved.
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
