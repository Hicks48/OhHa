/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySet;

import MyMath.Complex_Number;

/**
 *
 * @author henrikorpela
 */
public class GeneralJulia extends Set{
    private DefinitionFunction function;
    
    public GeneralJulia(String function,int accurancy,String name)
    {
        super(name,accurancy);
        this.function = new DefinitionFunction(function);
    }

    @Override
    public int belongsToSet(Complex_Number z) {
        super.inside = null;
        super.escaped = null;
        
        for(int roundsTillExit = 0;roundsTillExit < super.accurancy;roundsTillExit ++)
        {
            if(!super.isInSet(z))
            {
                return roundsTillExit;
            }
            z = this.function.countValue(z);
        }
        return 0;
    }

    @Override
    public String save() {
        return "";
    }
}
