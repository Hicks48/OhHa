
package MySet;

import MyMath.Complex_Number;
import java.util.ArrayList;

/**
 * Class presents functionality for a polynomial.
 * @author Henri Korpela
 */
public class Polynom {
    private ArrayList<Term> polynom;
    /**
     * Creates new Polynomial.
     * @param polynom String containing information
     * that is used to construct polynomial.
     */
    public Polynom(String polynom)
    {
        this.polynom = new ArrayList<Term>();
        String[] terms = polynom.split(";");
        this.construct(terms);
    }
    /**
     * Constructs polynomial from terms.
     * terms includes all the terms of the polynomial.
     * @param terms String containing Strings of terms separated
     * from each other.
     */
    private void construct(String[] terms)
    {
        for(int i = 0;i < terms.length;i ++)
        {
            this.polynom.add(new Term(terms[i]));
        }
    }
    /**
     * Counts value of the polynomial for complex-number z.
     * This is done by counting values of each term of the polynomial
     * and adding these values together.
     * @param z Complex-number presenting point on the complex-plane
     * (z is used to count value of the polynomial).
     * @return Value of polynomial.
     */
    public Complex_Number countValue(Complex_Number z)
    {
        Complex_Number value = this.polynom.get(0).countValue(z);
        for(int i = 1;i < this.polynom.size();i ++)
        {
            value = MyMath.Complex_Calculations.addition(value,this.polynom.get(i).countValue(z));
        }
        return value;
    }
    /**
     * Return String presentation of polynomial.
     * Presentation is in form: coefficient1 * z^degree1
     * + coefficient2 * z^degree2 + ... .
     * @return String presentation of the polynomial.
     */
    @Override
    public String toString()
    {
        String terms = "";
        for(int i = 0;i < this.polynom.size();i ++)
        {
            if(i != this.polynom.size() - 1)
            {
                terms = terms + this.polynom.get(i).toString() + " + ";
            }
            else
            {
                terms = terms + this.polynom.get(i).toString();
            }
        }
        return terms;
    }
}
