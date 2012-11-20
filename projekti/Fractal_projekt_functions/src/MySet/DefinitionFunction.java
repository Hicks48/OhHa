
package MySet;

/**
 * Class presents functions form P(x)/Q(x).
 * P(x) and Q(x) are complex-polynomials.
 * @author Henri Korpela
 */
import MyMath.*;
import java.util.ArrayList;
public class DefinitionFunction {
    private final Polynom dividend;
    private final Polynom divisor;
    /**
     * 
     * @param function String containing information needed
     * to construct definition function (P(x) and Q(x)).
     */
    public DefinitionFunction(String function)
    {
        String[] polynoms= function.split("/");
        this.dividend = new Polynom(polynoms[0]);
        this.divisor = new Polynom(polynoms[1]);
    }
    /**
     * Counts value of the definition function.
     * This is done by counting value of polynomial one
     * and dividing it by the value of polynomial two.
     * @param z Complex-number which value of function is counted.
     * @return Complex-number presenting the value of the function.
     */
    public Complex_Number countValue(Complex_Number z)
    {
        return MyMath.Complex_Calculations.division(this.dividend.countValue(z),
                this.divisor.countValue(z));
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        return this.dividend.toString() + " / " + this.divisor.toString();
    }
}
