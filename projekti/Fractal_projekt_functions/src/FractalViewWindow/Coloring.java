/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
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
    
    public void updateValues(int escape,Complex_Number escaped,Complex_Number inside)
    {
        this.escape = escape;
        this.inside = inside;
        this.escaped = escaped;
    }
    
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
    
    private int insideRGB(int color)
    {
        if(color > 250)
        {
            return 250;
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
    
    private void escapeCount(Graphics graphics)
    {
        double cofficient = ((double)this.escape / (double)this.accurancy);
        int red = (int)(Math.abs(this.secondaryMain.getRed() - this.setMainColor.getRed()) * cofficient);
        int blue = (int)(Math.abs(this.secondaryMain.getBlue() - this.setMainColor.getBlue()) * cofficient);
        int green = (int)(Math.abs(this.secondaryMain.getGreen() - this.setMainColor.getGreen()) * cofficient);
        this.trySetColor(red,green,blue,graphics);
    }
}
