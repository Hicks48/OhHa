/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMath;

/**
 *
 * @author henrikorpela
 */
public class Complex_Number implements Comparable<Complex_Number>{
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
    
    @Override
    public int compareTo(Complex_Number compared)
    {
        return this.powerOfIi - compared.getPower();
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
