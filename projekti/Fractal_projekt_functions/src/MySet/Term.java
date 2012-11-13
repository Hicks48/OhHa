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
public class Term {
    private int degree;
    private Complex_Number Coefficient;
    
    public Term(String term)
    {
        String[] parts = term.split("z");
        this.construct(parts);
    }
    
    private void construct(String[] parts)
    {
        this.degree = Integer.parseInt(parts[1]);
        this.Coefficient = MyMath.Construction.construct(parts[0]);
    }
    
    public Complex_Number countValue(Complex_Number z)
    {
        Complex_Number modifierPart = MyMath.Complex_Calculations.pow(z,this.degree);
        Complex_Number withCoefficient = MyMath.Complex_Calculations.multiplication(this.Coefficient,modifierPart);
        return withCoefficient;
    }
    
    @Override
    public String toString()
    {
        return this.Coefficient.toString() + " * " + "z^" + this.degree; 
    }
}
