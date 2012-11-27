
package MySet;

/**
 * Abstract class that all sets inherit. Contains definitions
 * for all functions that sets require.
 * @author Henri Korpela
 */
import MyMath.Complex_Calculations;
import MyMath.Complex_Number;
public abstract class Set {
    protected String name;
    protected int accurancy;
    protected Complex_Number escaped;
    protected Complex_Number inside;
    /**
     * 
     * @param name Name of the set.
     * @param accurancy Tells how many iterations complex-planes
     * points orbit has to stay inside circle of radius two so that
     * it's said that it belongs to the set.
     */
    public Set(String name,int accurancy)
    {
        this.name = name;
        this.accurancy = accurancy;
        this.inside = null;
        this.escaped = null;
    }
    /**
     * Checks does the orbit of complex-number z belong to the set.
     * Checking is done by calculating orbit of z. Define f(x)^2 = f(f(x)),
     * f(x)^3 = f(f(f(x))), ... . Whether z belongs to the set or not is defined
     * true if orbit(z)^accuracy hasn't escaped the set (Any complex-number that
     * belongs to orbit isn't further than two from the origin of the complex plane)
     * and false if the orbit has escaped the set. 
     * @param z Complex-number that presents a point on the complex-plain.
     * @return true if orbit of z belongs to the set and false if it doesn't.
     */
    public abstract int belongsToSet(Complex_Number z);
    /**
     * Escape is the first complex-number in the orbit of complex-number z
     * that escaped from set and inside is the last complex-number that was
     * still inside the set.
     * @return Values of complex-numbers inside and escape.
     */
    public Complex_Number[] updateValues()
    {
        Complex_Number update[] = new Complex_Number[2];
        update[0] = this.inside;
        update[1] = this.escaped;
        return update;
    }
    /**
     * Checks whether complex-number zi belongs to set.
     * This is done by checking whether zi:s distance from
     * the origin of complex plane is smaller than two.
     * If distance is bigger than two zi doesn't belong to set
     * and if smaller zi belongs to set.
     * @param zi complex-number presenting i:th part of the complex-number
     * z:s orbit.
     * @return True if zi belongs to set and false if it doesn't.
     */
    protected boolean isInSet(Complex_Number zi)
    {
        if(Complex_Calculations.abs(zi) <= 2.0)
        {
            this.inside = zi;
            return true;
        }
        this.escaped = zi;
        return false;
    }
    /**
     * Returns name of the set.
     * @return The name of the set.
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Returns accuracy of the set.
     * @return Accuracy witch the set uses.
     */
    public int getAccurancy()
    {
        return this.accurancy;
    }
}
