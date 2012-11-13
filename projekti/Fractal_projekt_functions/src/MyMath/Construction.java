/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMath;

import java.lang.Math;
/**
 *
 * @author henrikorpela
 */
public class Construction {
    
    public static Complex_Number construct(String number)
    {
        Reader read = new Reader(0);
        int realSign = sign(number,read);
        double realPart = number(number,read);
        int complexSign = sign(number,read);
        double complexPart = number(number,read);
        return new Complex_Number(realSign * realPart,complexSign * complexPart);
    }
    
    private static double number(String number,Reader read)
    {
        int where = read.getPoint();
        String coef = "";
        while(number.length() > where && number.charAt(where) != 'i' && 
                number.charAt(where) != '+' && number.charAt(where) != '-')
        {
            coef = coef + number.charAt(where);
            where ++;
        }
        read.setPoint(where);
        return Double.parseDouble(coef);
    }
    
    private static int sign(String number,Reader read)
    {
        int where = read.getPoint();
        int minus = 0;
        while(number.charAt(where) == '+' || number.charAt(where) == '-')
        {
            if(number.charAt(where) == '-')
            {
                minus ++;
            }
            where ++;
        }
        read.setPoint(where);
        if(minus % 2 == 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
