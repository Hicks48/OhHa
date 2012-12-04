
package FractalViewWindow;

/**
 * Presents RGB color value.
 * @author Henri Korpela
 */
public class RGB {
    private final int red;
    private final int green;
    private final int blue;
    /**
     * Creates RGB and sets it's values.
     * @param red Red RGB value.
     * @param green Green RGB value.
     * @param blue Blue RGB value.
     */
    public RGB(int red,int green,int blue)
    {
        this.blue = blue;
        this.green = green;
        this.red = red;
    }
    /**
     * @return RGB:s red value.
     */
    public int getRed()
    {
        return this.red;
    }
    /**
     * @return RGB:s green value.
     */
    public int getGreen()
    {
        return this.green;
    }
    /**
     * @return RGB:s blue value.
     */
    public int getBlue()
    {
        return this.blue;
    }
    /**
     * Checks whether this RGB:s values are valid or not.
     * @return true if values are valid and false if values aren't valid.
     */
    public boolean isValid()
    {
        if(this.red < 0 || this.blue < 0|| this.green < 0)
        {
            return false;
        }
        else if(this.red > 255 || this.green > 255 || this.blue > 255)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /**
     * Return a String that is used to save color.
     * Color values are separated from each other by
     * & marker.
     * @return String that is saved.
     */
    public String save()
    {
        return this.red + "&" + this.green + "&" + this.blue;
    }
    /**
     * @return RGB:s String presentation in a form R: red value
     * G: green value B: blue value.
     */
    @Override
    public String toString()
    {
        return "R: " + this.red + " G: " + this.green + " B: " + this.blue;
    }
}
