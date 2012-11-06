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
import MySet.*;
import FractalViewWindow.Window;
import FractalViewWindow.*;
import java.awt.Color;
public class Launch {
    public static void main(String []args)
    {
        //Window fwin = new Window(new Complex_Number(0.0,0.0),0.5,new Julia(new Complex_Number(0.70176,-0.3842),"Julia",250),800,800,0,0,Color.WHITE,Color.BLACK,null);
        Window fwin = new Window(new Complex_Number(0.0,0.0),0.5,new Julia(new Complex_Number(-0.726895347709114071439,0.188887129043845954792),"Julia",200),1200,1200,0,0,Color.WHITE,Color.BLACK,null);
        //Window fwin = new Window(new Complex_Number(0.0,0.0),1.0,new Julia(new Complex_Number(0.285,0.0),"Julia",50),800,800,0,0,Color.WHITE,Color.BLACK,null);
        //Window fwin = new Window(new Complex_Number(0.12,0.22),200.0,new Julia(new Complex_Number(0.285,0.01),"Julia",20),800,800,0,0,Color.BLUE,Color.WHITE);
        fwin.run();
        //System.out.println(Window_Calculations.pixel(new Complex_Number(0,0),1.0,400,400,800,800));
        /*
        Complex_Number num1 = new Complex_Number(8,3,1);
        Complex_Number num2 = new Complex_Number(3,2,1);
        Complex_Number result = Complex_Calculations.subtraction(num1, num2);
        System.out.println("tulos: " + result);
        * **/
        //Complex_Number test3 = new Complex_Number(1,2);
        //Complex_Number test4 = new Complex_Number(1.47556623525,-0.83456542);
        //System.out.println(Complex_Calculations.abs(test3));
        /*
        System.out.println(new Complex_Number(0.88,0,0));
        System.out.println(new Complex_Number(0.88,-3.5));
        System.out.println(new Complex_Number(0.88,-3.56,3));
        * **/
    }
}
