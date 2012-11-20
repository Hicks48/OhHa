/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySetTest;

import MySet.GeneralJulia;
import MySet.Julia;
import MyMath.Complex_Number;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author henrikorpela
 */
public class GeneralJuliaTest {
    private Random generator;
    private Julia julia;
    private GeneralJulia generalJulia;
    public GeneralJuliaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        generator = new Random();
        julia = new Julia(new Complex_Number(0.285,0.01),"julia",50);
        generalJulia = new GeneralJulia("+1.0+0.0iz2;+0.285+0.01iz0/+1.0+0.0iz0","generalJulia",50);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void JuliaEqualsGeneraliJulia() 
    {
        for(int i = 0;i < 100;i ++)
        {
            Complex_Number test = createNumber(generator);
            System.out.println("test = " + test);
            assertEquals(julia.belongsToSet(test),generalJulia.belongsToSet(test));
        }
    }
    
    @Test
    public void hazardTest()
    {
        Complex_Number z = new Complex_Number(0.13007431616127063,+0.9015645527639827);
        assertEquals(julia.belongsToSet(z),this.generalJulia.belongsToSet(z));
    }
    
    private Complex_Number createNumber(Random generator)
    {
        double realPart = generator.nextInt(3) + generator.nextDouble();
        double imaginaryPart = generator.nextInt(3) + generator.nextDouble();
        return new Complex_Number(realPart,imaginaryPart);
    }
}
