
package FractalViewWindow;

/**
 * Defines color of pixel by using selected coloring algorithm.
 * @author Henri Korpela
 */
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Color;
import MyMath.Complex_Number;
public class Coloring {
    private RGB secondaryMain;
    private RGB setMainColor;
    private int algorithm;
    private Complex_Number escaped;
    private Complex_Number inside;
    private int escape;
    private int accurancy;
    private boolean RGBValueCheck;
    private Color backroundColor;
    /**
     * Creates new coloring.
     * @param secondaryMain Color that sets color approaches
     * amount defined by used coloring algorithm.
     * @param setMainColor Color which is used to color pixels whose
     * complex-number belongs to set.
     * @param algorithm Tells which coloring algorithm is used.
     * @param accurancy Tells how many iterations complex-planes
     * points orbit has to stay inside circle of radius two so that
     * it's said that it belongs to the set.
     * @param backroundColor Color which is used to color pixels whose
     * complex-number doesn't belongs to set.
     * @param RGBValueCheck Tells is RGB value checking enabled or not.
     */
    public Coloring(RGB secondaryMain,RGB setMainColor, int algorithm,
            int accurancy,Color backroundColor,boolean RGBValueCheck)
    {
        this.algorithm = algorithm;
        this.setMainColor = setMainColor;
        this.secondaryMain = secondaryMain;
        this.escaped = new Complex_Number(0,0);
        this.inside = new Complex_Number(0,0);
        this.accurancy = accurancy;
        this.escape = 0;
        this.backroundColor = backroundColor;
        this.RGBValueCheck = RGBValueCheck;
    }
    /**
     * Interprets current coloring algorithm and checks that initial conditions are propitious.
     * @param graphics Graphics object that draws on the screen.
     */
    public void color(Graphics graphics)
    {
        if(this.escape <= 1 && this.algorithm != 1)
        {
            return;
        }
        if((this.escaped == null || this.inside == null) && (this.algorithm == 2 || this.algorithm == 3))
        {
            return;
        }
        switch(this.algorithm)
        {
            case 0: graphics.setColor(this.backroundColor);
                    return;
            case 1: this.escapeCount(graphics);
                    return;
            case 2: this.angleCosin(graphics);
                    return;
            case 3: this.angleSin(graphics);
                    return;
        }
    }
    /**
     * Updates colorings values to given values.
     * @param escape tells how many iterations it took
     * for orbit to escape circle of radius two.
     * @param escaped First complex-number outside circle.
     * @param inside Last complex-number inside circle.
     */
    public void updateValues(int escape,Complex_Number escaped,Complex_Number inside)
    {
        this.escape = escape;
        this.inside = inside;
        this.escaped = escaped;
    }
    /**
     * Sets the graphics color to color that corresponds given RGB values.
     * If RGB value check is enabled it checks RGB values before trying to
     * set color. If Setting given RGB values fails it sets color to 
     * background color.
     * @param red Red RGB value.
     * @param green Green RGB value.
     * @param blue Blue RGB value.
     * @param graphics Graphics object thats color is set.
     */
    private void trySetColor(int red,int green,int blue,Graphics graphics)
    {
        try
        {
            if(this.RGBValueCheck)
            {
                RGB color = this.RGBValueCheckFunc(red,green,blue);
                Color colored = new Color(color.getRed(),color.getGreen(),color.getBlue());
                graphics.setColor(colored);
            }
            else
            {
                graphics.setColor(new Color(this.secondaryMain.getRed() + red,
                    this.secondaryMain.getGreen() + green,
                    this.secondaryMain.getBlue() + blue));
            }
        }
        catch(Exception e)
        {
            graphics.setColor(this.backroundColor);
            return;
        }
    }
    /**
     * Checks that RGB:s red, green and blue values are all within RGB limits.
     * @param red Pixels red RGB value.
     * @param green Pixels green RGB value.
     * @param blue Pixels blue RGB value.
     * @return RGB thats values that are inside RGB value limits.
     */
    private RGB RGBValueCheckFunc(int red,int green,int blue)
    {
        if(this.setMainColor.getRed() > red)
        {
            red = this.setMainColor.getRed() - red;
        }
        else
        {
            red = this.setMainColor.getRed() + red;
        }
        red = this.insideRGB(red);
        
        if(this.setMainColor.getBlue() > blue)
        {
            blue = this.setMainColor.getBlue() - blue;
        }
        else
        {
            blue = this.setMainColor.getBlue() + blue;
        }
        blue = this.insideRGB(blue);
        
        if(this.setMainColor.getGreen() > green)
        {
            green = this.setMainColor.getGreen() - green;
        }
        else
        {
            green = this.setMainColor.getGreen() + green;
        }
        green = this.insideRGB(green);
        return new RGB(red,green,blue);
    }
    /**
     * Checks that color value is inside RGB limits.
     * If color value isn't inside these values it sets
     * it inside limits so that if it exceeds the limit
     * color value is set 255 and if value is smaller than
     * zero it's set to zero.
     * @param color
     * @return Zero if color value is under zero. 255 if color
     * value is over 255 and color if color value is between 255 and zero.
     */
    private int insideRGB(int color)
    {
        if(color > 255)
        {
            return 255;
        }
        else if(color <= 0)
        {
            return 0;
        }
        else
        {
            return color;
        }
    }
    /**
     * Counts RGB values based on cos of the angle between escaped complex-number
     * and inside complex-number.
     * @param graphics Graphics object that draws on the screen.
     */
    private void angleCosin(Graphics graphics)
    {
        double cofficient = (Math.abs(this.escaped.getImaginaryPart() - this.inside.getImaginaryPart())
                / Math.abs(this.escaped.getRealPart() - this.inside.getRealPart()));
        int red = (int)(Math.abs(this.secondaryMain.getRed() - this.setMainColor.getRed())
                * cofficient);
        int green = (int)(Math.abs(this.secondaryMain.getGreen() - this.setMainColor.getGreen())
                * cofficient);
        int blue = (int)(Math.abs(this.secondaryMain.getBlue() - this.setMainColor.getBlue())
                * cofficient);
        this.trySetColor(red,green,blue,graphics);
    }
    /**
     * Counts RGB values based on sin of the angle between escaped complex-number
     * and inside complex-number.
     * @param graphics Graphics object that draws on the screen.
     */
    private void angleSin(Graphics graphics)
    {
        double coefficient = ((Math.sqrt(Math.pow(Math.abs(this.escaped.getImaginaryPart() - this.inside.getImaginaryPart()),2.0))
                + Math.pow(Math.abs(this.escaped.getRealPart() - this.inside.getRealPart()),2.0))
                / Math.abs(this.escaped.getImaginaryPart() - this.inside.getImaginaryPart()));
        int red = (int)(Math.abs(this.secondaryMain.getRed() - this.setMainColor.getRed()) * coefficient);
        int green = (int)(Math.abs(this.secondaryMain.getGreen() - this.setMainColor.getGreen()) * coefficient);
        int blue = (int)(Math.abs(this.secondaryMain.getBlue() - this.setMainColor.getBlue()) * coefficient);
        this.trySetColor(red,green,blue,graphics);
    }
    /**
     * Counts RGB values based on how many iterations it took for orbit to escape the set.
     * This is done by calculating escape count divided by sets accuracy. This value is then
     * multiplied by RGB values difference.
     * @param graphics Graphics object that draws on the screen.
     */
    private void escapeCount(Graphics graphics)
    {
        double cofficient = ((double)this.escape / (double)this.accurancy);
        int red = (int)(Math.abs(this.secondaryMain.getRed() - this.setMainColor.getRed()) * cofficient);
        int blue = (int)(Math.abs(this.secondaryMain.getBlue() - this.setMainColor.getBlue()) * cofficient);
        int green = (int)(Math.abs(this.secondaryMain.getGreen() - this.setMainColor.getGreen()) * cofficient);
        this.trySetColor(red,green,blue,graphics);
    }
}
