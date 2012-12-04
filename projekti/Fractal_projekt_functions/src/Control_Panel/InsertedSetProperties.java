
package Control_Panel;

import MyMath.Complex_Number;
import MyMath.Construction;
import MySet.DefinitionFunction;
import MySet.Set;
import MySet.GeneralJulia;
import MySet.Julia;
/**
 * Contains all information needed to
 * construct set.
 * @author Henri Korpela
 */
public class InsertedSetProperties {
    private int accurancy;
    private String name;
    private String function;
    private Complex_Number  K;
    /**
     * Creates new InsertedSetProperties object
     * and initializes variables with invalid values.
     */
    public InsertedSetProperties()
    {
        this.accurancy = -1;
        this.K = null;
        this.name = null;
        this.function = null;
    }
    /**
     * Checks sets definition function.
     * @param function
     * @return true if function is valid
     * and false if isn't.
     */
    private String checkFunction(String function)
    {
        try
        {
            String original = function;
            DefinitionFunction test = new DefinitionFunction(function);
            test.countValue(new Complex_Number(0,0));
            return original;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    /**
     * Checks K value.
     * @param K K value that
     * is set.
     * @return true if K value is valid
     * and false if isn't.
     */
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
    /**
     * Creates new Set with
     * values of this InsertedSetProperties object.
     * @return new Julia object if K value is set
     * and GeneralJulia object if K value is null.
     */
    public Set createSet()
    {
        if(this.K == null)
        {
            return new GeneralJulia(this.function,this.name,this.accurancy);
        }
        else
        {
            return new Julia(this.K,this.name,this.accurancy);
        }
    }
    /**
     * Sets initializes all variables
     * with invalid values.
     */
    public void clear()
    {
        this.accurancy = -1;
        this.K = null;
        this.name = null;
        this.function = null;
    }
    /**
     * Sets function.
     * @param function definition function
     * that is set.
     * @return true if function is valid
     * and false if isn't
     */
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
    /**
     * Sets accuracy.
     * @param accurancy accuracy that is set.
     * @return true if accuracy is valid and
     * false if isn't.
     */
    public boolean setAccurancy(int accurancy)
    {
        if(accurancy <= 0)
        {
            return false;
        }
        this.accurancy = accurancy;
        return true;
    }
    /**
     * Sets name of the set.
     * @param name name that is set.
     * @return true if name is valid
     * and false if isn't.
     */
    public boolean setName(String name)
    {
        if(name == null || name.equals(""))
        {
            return false;
        }
        this.name = name;
        return true;
    }
    /**
     * Sets K.
     * @param K K value that
     * is set.
     * @return true if K value is valid
     * and false if isn't.
     */
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
    /**
     * Return String that is used to
     * save set properties.
     * @return String that is saved.
     */
    public String save()
    {
        String K;
        if(this.function == null)
        {
            function = "";
        }
        if(this.K == null)
        {
            this.K = new Complex_Number(0,0);
            K = this.K.NullSave();
        }
        else
        {
            K = this.K.save();
        }
        return this.name + ":" + this.accurancy + ":" + this.function + ":" + K;
    }
}
