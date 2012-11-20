
package MyMath;

import java.lang.Math;
/**
 * Contains functionality needed to construct
 * complex-number from String.
 * @author Henri Korpela
 */
public class Construction {
    /**
     * Constructs complex-number from String that is formed into
     * form (+-)a(+-)bzn (n is the power of z).
     * @param number String containing information needed to construct
     * complex-number.
     * @return Complex-number corresponding given string.
     */
    public static Complex_Number construct(String number)
    {
        Reader read = new Reader(0);
        int realSign = sign(number,read);
        double realPart = number(number,read);
        int complexSign = sign(number,read);
        double complexPart = number(number,read);
        return new Complex_Number(realSign * realPart,complexSign * complexPart);
    }
    /**
     * Interprets number (double) from given string.
     * Starts from the point defined by given reader.
     * Reads double value and sets readers point to
     * where it stopped reading.
     * @param number String containing information needed to construct
     * complex-number.
     * @param read Reader that contains information where method
     * should start reading String number.
     * @return Interpreted double value.
     */
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
    /**
     * Interprets the sign from pluses and minuses.
     * Reads given from point defined by given reader.
     * After interpreting sign sets readers point to where
     * it stopped reading.
     * @param number String containing information needed to construct
     * complex-number.
     * @param read Reader that contains information where method
     * should start reading String number.
     * @return 1 if sign is plus and (-1) if sign is minus.
     */
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
