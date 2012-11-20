
package MySet;

/**
 * Class presents Julia sets that are form z^2 + K.
 * @author Henri Korpela
 */
import MyMath.*;
public class Julia extends Set{
    private Complex_Number K;
    /**
     * 
     * @param K Complex-number constant K.
     * @param name Name of the Julia set.
     * @param accurancy Tells how many iterations complex-planes
     * points orbit has to stay inside circle of radius two so that
     * it's said that it belongs to the set.
     */
    public Julia(Complex_Number K,String name,int accurancy)
    {
        super(name,accurancy);
        this.K = K;
    }
    /**
     * 
     * @param z Complex-number that's orbit is counted.
     * @return Zero if z belongs to set. If z doesn't
     * belong to set method returns how many iterations
     * it took for orbit to escape the circle of radios two.
     */
    @Override
    public int belongsToSet(Complex_Number z)
    {
        super.inside = null;
        super.escaped = null;
        
        for(int roundsTillExit = 0;roundsTillExit <= super.accurancy;roundsTillExit ++)
        {
            if(!super.isInSet(z))
            {
                return roundsTillExit;
            }
            z = Complex_Calculations.addition(this.K,Complex_Calculations.pow(z,2));
        }
        return 0;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String save() {
        return "z^2 " + this.K.toString();
    }
}
