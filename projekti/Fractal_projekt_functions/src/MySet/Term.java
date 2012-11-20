
package MySet;

/** This class contains functionality for term.
 * Term is part of the polynomial.
 * @author Henri Korpela
 */
import MyMath.*;
public class Term {
    private int degree;
    private Complex_Number Coefficient;
    /**
     * 
     * @param term String containing information needed to construct term.
     */
    public Term(String term)
    {
        String[] parts = term.split("z");
        this.construct(parts);
    }
    /**
     * Forms the term from two String that are stored in parts.
     * Strings are in form (+-)a+(+-)b and zn.
     * @param parts Array that contains terms degree separated from the
     * coefficients.
     */
    private void construct(String[] parts)
    {
        this.degree = Integer.parseInt(parts[1]);
        this.Coefficient = MyMath.Construction.construct(parts[0]);
    }
    /**
     * Counts the value of the term for complex-number z.
     * @param z Complex-number that is inserted to the term
     * (z is used to count value of the term).
     * @return complex-number as the value of the term.
     */
    public Complex_Number countValue(Complex_Number z)
    {
        Complex_Number modifierPart = MyMath.Complex_Calculations.pow(z,this.degree);
        Complex_Number withCoefficient = MyMath.Complex_Calculations.multiplication(this.Coefficient,modifierPart);
        return withCoefficient;
    }
    /**
     * @return 
     */
    @Override
    public String toString()
    {
        return this.Coefficient.toString() + " * " + "z^" + this.degree; 
    }
}
