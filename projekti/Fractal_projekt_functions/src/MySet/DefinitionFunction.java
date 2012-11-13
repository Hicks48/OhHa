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
import java.util.ArrayList;
public class DefinitionFunction {
    private final Polynom dividend;
    private final Polynom divisor;
    
    public DefinitionFunction(String function)
    {
        String[] polynoms= function.split("/");
        this.dividend = new Polynom(polynoms[0]);
        this.divisor = new Polynom(polynoms[1]);
    }
    
    public Complex_Number countValue(Complex_Number z)
    {
        return MyMath.Complex_Calculations.division(this.dividend.countValue(z),
                this.divisor.countValue(z));
    }
    
    @Override
    public String toString()
    {
        return this.dividend.toString() + " / " + this.divisor.toString();
    }
}
