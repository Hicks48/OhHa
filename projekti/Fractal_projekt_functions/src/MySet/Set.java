/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySet;

/**
 *
 * @author henrikorpela
 */
import MyMath.Complex_Calculations;
import MyMath.Complex_Number;
public abstract class Set {
    protected String name;
    protected int accurancy;
    protected Complex_Number escaped;
    protected Complex_Number inside;
    
    public Set(String name,int accurancy)
    {
        this.name = name;
        this.accurancy = accurancy;
        this.inside = null;
        this.escaped = null;
    }
    
    public abstract int belongsToSet(Complex_Number z);
    public abstract String save();
    
    public Complex_Number[] updateValues()
    {
        Complex_Number update[] = new Complex_Number[2];
        update[0] = this.inside;
        update[1] = this.escaped;
        return update;
    }
    
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
    
    public String getName()
    {
        return this.name;
    }
    public int getAccurancy()
    {
        return this.accurancy;
    }
}
