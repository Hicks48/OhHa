
package MyMath;
import java.text.DecimalFormat;

/**
 * Class presents complex-numbers in form a+bi.
 * @author Henri Korpela
 */
public class Complex_Number{
    private double realPart;
    private double imaginaryPart;
    private int powerOfIi;
    /**
     * 
     * @param realPart Real-part of the complex-number.
     * @param imaginaryPart Imaginary coefficient.
     */
    public Complex_Number(double realPart,double imaginaryPart)
    {
        this(realPart,imaginaryPart,1);
    }
    /**
     * 
     * @param realPart Real-part of the complex-number.
     * @param imaginaryPart Imaginary coefficient.
     * @param power Degree of i.
     */
    public Complex_Number(double realPart,double imaginaryPart,int power)
    {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        this.powerOfIi = power;
    }
    /**
     * 
     * @param realPart Real-part of the complex-number.
     */
    public Complex_Number(double realPart)
    {
        this(realPart,0,0);
    }
    /**
     * Return real-part of complex-number.
     * @return Real-part of the complex-number.
     */
    public double getRealPart()
    {
        return this.realPart;
    }
    /**
     * Returns imaginary coefficient of the complex-number.
     * @return Imaginary coefficient of the complex-number.
     */
    public double getImaginaryPart()
    {
        return this.imaginaryPart;
    }
    /**
     * Returns degree of i.
     * @return Degree of i.
     */
    public int getPower()
    {
        return this.powerOfIi;
    }
    /**
     * Sets degree for i.
     * @param i New degree for i.
     */
    public void setPower(int i)
    {
        this.powerOfIi = i;
    }
    /**
     * Sets real-part for the complex-number.
     * @param realPart New real-part value for the complex-number.
     */
    public void setRealPart(double realPart)
    {
        this.realPart = realPart;
    }
    /**
     * Sets imaginary coefficient for the complex-number.
     * @param imaginaryPart New imaginary coefficient.
     */
    public void setImaginaryPart(double imaginaryPart)
    {
        this.imaginaryPart = imaginaryPart;
    }
    /**
     * Rounds double value.
     * @param round Double value to be rounded.
     * @param accurancy Tells how many numbers are
     * considered in the decimal part.
     * @return Rounded double value.
     */
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
    /**
     * Determines whether object equals this
     * complex-number.
     * Method determines whether o equals
     * this complex-number or not by comparing
     * real-part, imaginary part and degree of i.
     * @param o Object that is compared to this complex-number.
     * @return True if o equals this complex-number and false
     * if o doesn't equal this complex-number.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o.getClass() != this.getClass())
        {
            return false;
        }
        Complex_Number compare = (Complex_Number)o;
        if(this.powerOfIi == compare.getPower())
        {
            if(Math.abs(this.round(this.realPart,10) - this.round(compare.getRealPart(),10)) < 0.000000001)
            {
                if(Math.abs(this.round(this.imaginaryPart,10) - this.round(compare.getImaginaryPart(),10)) < 0.000000001)
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        if(this.powerOfIi == 0 || this.imaginaryPart == 0.0)
        {
            return ("" + this.realPart);
        }
        else if(this.powerOfIi != 1)
        {
            return (this.realPart + " + " + this.imaginaryPart + "i^" + this.powerOfIi);
        }
        else
        {
            return (this.realPart + " + " + this.imaginaryPart + "i");
        }
    }
}
