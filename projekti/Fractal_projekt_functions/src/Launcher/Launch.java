/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Launcher;

/**
 *
 * @author henrikorpela
 */
import MyMath.*;
public class Launch {
    public static void main(String []args)
    {
        Complex_Number num1 = new Complex_Number(8,3,1);
        Complex_Number num2 = new Complex_Number(3,2,1);
        Complex_Number result = Complex_Calculations.subtraction(num1, num2);
        System.out.println("tulos: " + result);
    }
}
