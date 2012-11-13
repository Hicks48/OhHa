/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySet;

import MyMath.Complex_Number;
import java.util.ArrayList;

/**
 *
 * @author henrikorpela
 */
public class Polynom {
    private ArrayList<Term> polynom;
    
    public Polynom(String polynom)
    {
        this.polynom = new ArrayList<Term>();
        String[] terms = polynom.split(";");
        this.construct(terms);
    }
    
    private void construct(String[] terms)
    {
        for(int i = 0;i < terms.length;i ++)
        {
            this.polynom.add(new Term(terms[i]));
        }
    }
    
    public Complex_Number countValue(Complex_Number z)
    {
        Complex_Number value = this.polynom.get(0).countValue(z);
        for(int i = 1;i < this.polynom.size();i ++)
        {
            value = MyMath.Complex_Calculations.addition(value,this.polynom.get(i).countValue(z));
        }
        return value;
    }
    
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
