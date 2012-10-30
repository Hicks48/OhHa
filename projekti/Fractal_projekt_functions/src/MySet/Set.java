/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySet;

/**
 *
 * @author henrikorpela
 */
import MyMath.Complex_Number;
public abstract class Set {
    protected String name;
    
    public abstract int belongsToSet(Complex_Number z);
    
    public String getName()
    {
        return this.name;
    }
}
