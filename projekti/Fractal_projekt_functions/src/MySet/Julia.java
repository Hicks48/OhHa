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
    
    public Julia(Complex_Number K,String name,int accurancy)
    {
        super(name,accurancy);
        this.K = K;
    }
    
    @Override
    public int belongsToSet(Complex_Number z)
    {
        super.escaped = null;
        super.inside = null;
        int roundsTillExit = 0;
        for(;roundsTillExit <= super.accurancy;roundsTillExit ++)
        {
            if(!super.isInSet(z))
            {
                return roundsTillExit;
            }
            z = Complex_Calculations.addition(this.K,Complex_Calculations.pow(z,2));
        }
        return 0;
    }

    @Override
    public String save() {
        return "z^2 " + this.K.toString();
    }
}
