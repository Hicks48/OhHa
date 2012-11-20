
package FractalViewWindow;

/**
 * Defines complex-number fro pixel in
 * coordinates pixelX and pixelY.
 * @author Henri Korpela
 */
import MyMath.Complex_Number;
public class Window_Calculations {
    /**
     * Counts the area of complex values that each pixel covers.
     * @param zoom Value that defines how much picture is zoomed.
     * @return Longest distance between two complex-numbers that pixel covers.
     */
    public static double pixelGap(double zoom)
    {
        return 2.5E-3 * (1.0/zoom);
    }
    /**
     * Counts biggest imaginary value and smallest real value 
     * that can be seen on the screen.
     * @param center Complex-number that is at the center
     * of the screen.
     * @param pixelGap Biggest difference between two complex-number
     * that any pixel presents.
     * @param width Width of the screen in pixels.
     * @param heigth Height of the screen in pixels.
     * @return Array that contains real-axel min value (index 0)
     * and imaginary-axel max value (index 1).
     */
    public static double[] windowCordinateSystemLimits(Complex_Number center,double pixelGap,int width,int heigth)
    {
        double limits[] = new double[2];
        limits[0] = center.getRealPart() - (width/2) * pixelGap; // real-axel min
        limits[1] = center.getImaginaryPart() + (heigth/2) * pixelGap; // imaginary-axel max
        return limits;
    }
    /**
     * Forms complex-number that corresponds given pixel coordinates.
     * @param center Complex-number that is at the center
     * of the screen.
     * @param zoom Value that defines how much picture is zoomed.
     * @param pixelX x-coordinate of the pixel.
     * @param pixelY y-coordinate of the pixel.
     * @param heigth Height of the screen in pixels.
     * @param width Width of the screen in pixels.
     * @return Complex-number corresponding given pixel coordinates.
     */
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
