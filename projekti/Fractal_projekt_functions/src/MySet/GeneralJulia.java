
package MySet;

import MyMath.Complex_Number;

/**
 * Class presents Julia sets form P(x)/Q(x).
 * @author Henri Korpela
 */
public class GeneralJulia extends Set{
    private DefinitionFunction function;
    /**
     * 
     * @param function String containing information
     * that is used to construct definition function
     * for the set.
     * @param name Name of the set.
     * @param accurancy Tells how many iterations complex-planes
     * points orbit has to stay inside circle of radius two so that
     * it's said that it belongs to the set.
     */
    public GeneralJulia(String function,String name,int accurancy)
    {
        super(name,accurancy);
        this.function = new DefinitionFunction(function);
    }
    /**
     * 
     * @param z Complex-number that's orbit is counted. 
     * @return Zero if z belongs to set. If z doesn't
     * belong to set method returns how many iterations
     * it took for orbit to escape the circle of radios two.
     */
    @Override
    public int belongsToSet(Complex_Number z) {
        super.inside = null;
        super.escaped = null;
        
        for(int roundsTillExit = 0;roundsTillExit <= super.accurancy;roundsTillExit ++)
        {
            if(!super.isInSet(z))
            {
                return roundsTillExit;
            }
            z = this.function.countValue(z);
        }
        return 0;
    }
}
