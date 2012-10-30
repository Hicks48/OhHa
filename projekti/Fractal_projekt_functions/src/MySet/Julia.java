/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySet;

/**
 *
 * @author henrikorpela
 */
import MyMath.*;
public class Julia extends Set{
    private Complex_Number K;
    private int accurancy;
    
    public Julia(Complex_Number K,String name,int accurancy)
    {
        super.name = name;
        this.K = K;
        this.accurancy = accurancy;
    }
    @Override
    public int belongsToSet(Complex_Number z)
    {
        int roundsTillExit = 0;
        for(;roundsTillExit <= this.accurancy;roundsTillExit ++)
        {
            if(!isInSet(z))
            {
                return roundsTillExit;
            }
            z = Complex_Calculations.addition(this.K,Complex_Calculations.pow(z,2));
        }
        return 0;
    }
    private boolean isInSet(Complex_Number zi)
    {
        if(Complex_Calculations.abs(zi) <= 2.0)
        {
            return true;
        }
        return false;
    }
}
