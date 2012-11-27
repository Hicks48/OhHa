
package Control_Panel;
import MyMath.Complex_Number;
import MyMath.Construction;
import MySet.Set;
import MySet.GeneralJulia;
import MySet.Julia;
/**
 * 
 * @author Henri Korpela
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
        try
        {
            Complex_Number constantK = MyMath.Construction.construct(K);
            return constantK;
        }
        catch(Exception e)
        {
            return null;
        }
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
    
    public String save()
    {
        return this.name + ":" + this.accurancy + ":" + this.function + ":" + this.K.save();
    }
}
