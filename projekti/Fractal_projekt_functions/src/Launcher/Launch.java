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
import FractalViewWindow.*;
import java.awt.Color;
import Control_Panel.*;
public class Launch {
    public static void main(String []args)
    {
        //Window fwin = new Window(new Complex_Number(0.0,0.0),1.0,new Julia(new Complex_Number(0.285,0.0),"Julia",100),800,800,0,0,new RGB(250,250,250),new RGB(0,0,0),new RGB(0,150,0),1,true);
        //Window fwin = new Window(new Complex_Number(0,0),0.5,new Julia(new Complex_Number(0.285,0.01),"Julia",100),900,900,0,0,new RGB(0,0,0),new RGB(51,204,255),new RGB(255,204,51),1,true);
        //Window fwin = new Window(new Complex_Number(0,0),0.5,new GeneralJulia("+1.0+0.0iz1;-1.0+0.0iz4/+6+0iz1",100,"JuliaSet"),800,800,0,0,new RGB(0,0,0),new RGB(51,204,255),new RGB(255,204,51),1,true);
        Window fwin = new Window(new Complex_Number(0,0),0.5,new Julia(new Complex_Number(-0.726895347709114071439,0.188887129043845954792),"Pikku Boosa",100),900,900,0,0,new RGB(0,0,0),new RGB(250,68,240),new RGB(250,68,240),1,true);
        fwin.run();
        //System.out.println("Valmis");
        //System.out.println(Window_Calculations.pixel(new Complex_Number(0,0),1.0,400,400,800,800));
        //Panel panel = new Panel();
        //panel.run();
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
