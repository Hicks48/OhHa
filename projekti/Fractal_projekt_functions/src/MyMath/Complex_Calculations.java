
package MyMath;

/**
 * Class contains calculations for complex-numbers.
 * @author Henri Korpela
 */
import java.lang.Math;
public class Complex_Calculations {
    
    /**
     * Adds two complex-numbers together.
     * @param num1 First complex-number that is added.
     * @param num2 Second complex-number that is added.
     * @return addition of number one and number two.
     */
    public static Complex_Number addition(Complex_Number num1, Complex_Number num2)
    {
        simplify_i(num1);
        simplify_i(num2);
        double realPart = num1.getRealPart() + num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() + num2.getImaginaryPart();
        return new Complex_Number(realPart,imaginaryPart);
    }
    
    /**
     * Multiplicates two complex-numbers.
     * @param num1 First complex-number that is multiplied.
     * @param num2 Second complex-number that is multiplied.
     * @return multiplication of number one and number two.
     */
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
    
    /**
     * Raises complex_number to n.
     * @param num Complex-number that is raised.
     * @param n Degree which complex-number is raised.
     * @return complex-number.
     */
    public static Complex_Number pow(Complex_Number num,int n)
    {
        if(n == 1)
        {
            return new Complex_Number(num.getRealPart(),num.getImaginaryPart(),num.getPower());
        }
        else if(n == 0)
        {
            return new Complex_Number(1,0);
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
    
    /**
     * Rounds complex-number with a precision of accuracy 
     * @param num Complex-number that is rounded.
     * @param accurancy Tells how many numbers are considered in
     * the decimal part.
     * @return rounded complex-number
     */
    public static Complex_Number round(Complex_Number num,int accurancy)
    {
        num.setRealPart(num.round(num.getRealPart(),accurancy));
        num.setImaginaryPart(num.round(num.getImaginaryPart(),accurancy));
        return num;
    }
    
    /**
     * Simplifies any complex-number into a form (a+bi).
     * @param num Complex_number that is simplified.
     * @return simplified complex-number.
     */
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
    
    /**
     * Subtracts number two from number one.
     * @param num1 Complex-number that other complex-number
     * is subtracted from.
     * @param num2 Complex-number that is subtracted from
     * the other complex-number.
     * @return number one - number two.
     */
    public static Complex_Number subtraction(Complex_Number num1, Complex_Number num2)
    {
        num2 = multiplication(new Complex_Number(-1,0),num2);
        return addition(num1,num2);
    }
    
    /**
     * Counts complex-numbers distance from the origin of complex plane using 
     * Pythagorean theorem.
     * @param num Complex-number thats distance from origin is counted.
     * @return numbers distance from the origin of the complex plane.
     */
    public static double abs(Complex_Number num)
    {
        simplify_i(num);
        return Math.sqrt(Math.abs(Math.pow(num.getRealPart(),2)) + Math.abs(Math.pow(num.getImaginaryPart(),2)));
    }
    
    /**
     * Divides complex-number one with complex-number two.
     * @param num1 Dividend complex-number.
     * @param num2 divisor complex-number.
     * @return division of number one and number two.
     */
    public static Complex_Number division(Complex_Number num1,Complex_Number num2)
    {
        num1 = simplify_i(num1);
        num2 = simplify_i(num2);
        Complex_Number conjugate = conjugation(num2);
        Complex_Number top = multiplication(conjugate,num1);
        Complex_Number bottom = multiplication(conjugate,num2);
        return divide(top,bottom);
    }
    
    /**
     * Takes conjugation of complex-number by multiplying complex part
     * bi by (-1).
     * @param num Complex-number thats conjugation is formed.
     * @return cojnugation of complex-number num.
     */
    private static Complex_Number conjugation(Complex_Number num)
    {
        double imaginaryPart = num.getImaginaryPart() * (-1);
        return new Complex_Number(num.getRealPart(),imaginaryPart);
    }
    
    /**
     * Divides complex-number top by complex-number bottom.
     * @param top Dividend complex-number.
     * @param bottom Divisor complex-number.
     * @return top divided by bottom.
     */
    private static Complex_Number divide(Complex_Number top,Complex_Number bottom)
    {
        double realPart;
        double imaginaryPart;
        int power;
        
        if(top.getRealPart() == 0)
        {
            realPart = bottom.getRealPart();
        }
        else if(bottom.getRealPart() == 0)
        {
            realPart = top.getRealPart();
        }
        else
        {
            realPart = top.getRealPart() / bottom.getRealPart();
        }
        
        if(top.getImaginaryPart() == 0)
        {
            imaginaryPart = bottom.getImaginaryPart();
            power = bottom.getPower();
        }
        else
        {
            imaginaryPart = top.getImaginaryPart() / bottom.getRealPart();
            power = top.getPower() - bottom.getPower();
        }
        
        if(power < 1)
        {
            power = 1;
        }
        Complex_Number result = new Complex_Number(realPart,imaginaryPart,power);
        return simplify_i(result);
    }
}

