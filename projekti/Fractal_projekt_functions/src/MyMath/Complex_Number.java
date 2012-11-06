/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMath;
import java.text.DecimalFormat;

/**
 *
 * @author henrikorpela
 */
public class Complex_Number{
    double realPart;
    double imaginaryPart;
    int powerOfIi;
    
    public Complex_Number(double realPart,double imaginaryPart)
    {
        this(realPart,imaginaryPart,1);
    }
    
    public Complex_Number(double realPart,double imaginaryPart,int power)
    {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        this.powerOfIi = power;
    }
    
    public Complex_Number(double realPart)
    {
        this(realPart,0,0);
    }
    
    public double getRealPart()
    {
        return this.realPart;
    }
    
    public double getImaginaryPart()
    {
        return this.imaginaryPart;
    }
    
    public int getPower()
    {
        return this.powerOfIi;
    }
    
    public void setPower(int i)
    {
        this.powerOfIi = i;
    }
    
    public void setRealPart(double realPart)
    {
        this.realPart = realPart;
    }
    
    public void setImaginaryPart(double imaginaryPart)
    {
        this.imaginaryPart = imaginaryPart;
    }
    public double round(double round,int accurancy)
    {
        String rounding = "#.";
        for(int i = 0;i < accurancy;i ++)
        {
            rounding = rounding + "#";
        }
        DecimalFormat df = new DecimalFormat(rounding);
        return Double.parseDouble(df.format(round));
    }
    @Override
    public boolean equals(Object o)
    {
        if(o.getClass() != this.getClass())
        {
            return false;
        }
        Complex_Number compare = (Complex_Number)o;
        if(this.round(compare.getRealPart(),10) == this.round(
            this.realPart,10) && this.round(compare.getImaginaryPart(),8) == this.round(this.imaginaryPart,8)
                && compare.getPower() == this.powerOfIi)
        {
            return true;
        }
        return false;
    }
    @Override
    public String toString()
    {
        if(this.powerOfIi == 0 || this.imaginaryPart == 0.0)
        {
            return ("" + this.realPart);
        }
        else if(this.powerOfIi != 1)
        {
            return (this.realPart + " + " + this.imaginaryPart + "i ^ " + this.powerOfIi);
        }
        else
        {
            return (this.realPart + " + " + this.imaginaryPart + "i");
        }
    }
}
