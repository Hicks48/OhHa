/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMath;

/**
 *
 * @author henrikorpela
 */
import java.lang.Math;
public class Complex_Calculations {
    
    public static Complex_Number addition(Complex_Number num1, Complex_Number num2)
    {
        simplify_i(num1);
        simplify_i(num2);
        double realPart = num1.getRealPart() + num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() + num2.getImaginaryPart();
        return new Complex_Number(realPart,imaginaryPart);
    }
    
    public static Complex_Number multiplication(Complex_Number num1, Complex_Number num2)
    {
        simplify_i(num1);
        simplify_i(num2);
        double realTerm1 = num1.getRealPart() * num2.getRealPart();
        double imaginaryTerm2 = num1.getRealPart() * num2.getImaginaryPart();
        double imaginaryTerm3 = num1.getImaginaryPart() * num2.getRealPart();
        double imaginaryTerm4 = num1.getImaginaryPart() * num2.getImaginaryPart() * (-1);
        double realPart = realTerm1 + imaginaryTerm4;
        double imaginaryPart = imaginaryTerm2 + imaginaryTerm3;
        return new Complex_Number(realPart,imaginaryPart);
    }
    
    public static Complex_Number pow(Complex_Number num,int n)
    {
        if(n == 1)
        {
            return new Complex_Number(num.getRealPart(),num.getImaginaryPart(),num.getPower());
        }
        simplify_i(num);
        Complex_Number pow = new Complex_Number(num.getRealPart(),num.getImaginaryPart());
        for(int i = 1;i < n;i ++)
        {
            pow = multiplication(pow,num);
            simplify_i(pow);
        }
        return pow;
    }
    
    public static Complex_Number round(Complex_Number num,int accurancy)
    {
        num.setRealPart(num.round(num.getRealPart(),accurancy));
        num.setImaginaryPart(num.round(num.getImaginaryPart(),accurancy));
        return num;
    }
    public static Complex_Number simplify_i(Complex_Number num)
    {
        if(num.getPower() != 1)
        {
            int power = num.getPower();
            power = power  - (power / 4) * 4;// poisttaa epäoleelliset
            int effective = power % 4;
            switch(effective)
            {
                case 0: num.setRealPart(num.getRealPart() +  num.getImaginaryPart());
                        num.setImaginaryPart(0);
                        num.setPower(0);
                        return num;
                case 1: num.setPower(1);
                        return num;
                case 2: num.setRealPart(num.getRealPart() - num.getImaginaryPart());
                        num.setImaginaryPart(0.0);
                        num.setPower(0);
                        return num;
                case 3: num.setImaginaryPart(num.getImaginaryPart() * (-1));
                        num.setPower(1);
            }
        }
        return num;
    }
    
    public static Complex_Number subtraction(Complex_Number num1, Complex_Number num2)
    {
        num2 = multiplication(new Complex_Number(-1,0),num2);
        return addition(num1,num2);
    }
    
    public static double abs(Complex_Number num)
    {
        simplify_i(num);
        return Math.sqrt(Math.abs(Math.pow(num.realPart,2)) + Math.abs(Math.pow(num.imaginaryPart,2)));
    }
}

