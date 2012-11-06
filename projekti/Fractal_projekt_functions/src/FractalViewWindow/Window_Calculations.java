/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindow;

/**
 *
 * @author henrikorpela
 */
import MyMath.Complex_Number;
public class Window_Calculations {
    
    private static double pixelGap(double zoom)
    {
        return 2.5E-3 * (1.0/zoom);
    }
    
    private static double[] windowCordinateSystemLimits(Complex_Number center,double pixelGap,int width,int heigth)
    {
        double limits[] = new double[2];
        limits[0] = center.getRealPart() - (width/2) * pixelGap; // real-axel min
        limits[1] = center.getImaginaryPart() + (heigth/2) * pixelGap; // imaginary-axel max
        return limits;
    }
    
    public static Complex_Number pixel(Complex_Number center,double zoom,int pixelX,int pixelY,
            int heigth,int width)
    {
        double gap = pixelGap(zoom);
        double limits[] = windowCordinateSystemLimits(center,gap,width,heigth);
        double realPart = limits[0] + pixelX * gap;
        double imaginaryPart = limits[1] - pixelY * gap;
        return new Complex_Number(realPart,imaginaryPart);
    }
}
