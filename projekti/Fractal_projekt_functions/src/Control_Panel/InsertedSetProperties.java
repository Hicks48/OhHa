/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Panel;
import MyMath.Complex_Number;
import MySet.Set;
import MySet.GeneralJulia;
import MySet.Julia;
/**
 *
 * @author henrikorpela
 */
public class InsertedSetProperties {
    private int accurancy;
    private String name;
    private String function;
    private Complex_Number  K;
    
    public InsertedSetProperties()
    {
        this.accurancy = -1;
        this.K = null;
        this.name = null;
        this.function = null;
    }
    
    private String checkFunction(String function)
    {
        return null;
    }
    
    private Complex_Number checkK(String K)
    {
        return null;
    }
    
    public Set createSet()
    {
        if(this.K == null)
        {
            return new GeneralJulia(this.name,this.function,this.accurancy);
        }
        else
        {
            return new Julia(this.K,this.name,this.accurancy);
        }
    }
    
    public void clear()
    {
        this.accurancy = -1;
        this.K = null;
        this.name = null;
        this.function = null;
    }
    
    public boolean setFunction(String function)
    {
        String toBeCheckedFunction = this.checkFunction(function);
        if(toBeCheckedFunction == null)
        {
            return false;
        }
        this.function = toBeCheckedFunction;
        return true;
    }
    
    public boolean setAccurancy(int accurancy)
    {
        if(accurancy <= 0)
        {
            return false;
        }
        this.accurancy = accurancy;
        return true;
    }
    
    public boolean setName(String name)
    {
        if(name == null || name.equals(""))
        {
            return false;
        }
        this.name = name;
        return true;
    }
    
    public boolean setK(String K)
    {
        Complex_Number toBeCheckedK = this.checkK(K);
        if(toBeCheckedK == null)
        {
            return false;
        }
        this.K = toBeCheckedK;
        return true;
    }
}
