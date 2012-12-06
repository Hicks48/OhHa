
package MyMathTest;

import MyMath.Complex_Calculations;
import MyMath.Complex_Number;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henri Korpela
 */
public class Complex_Calculations_Test {
    private Complex_Number test1;
    private Complex_Number test2;
    private Complex_Number test3;
    private Complex_Number test4;
    private Complex_Number test5;
    private Complex_Number test6;
    public Complex_Calculations_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        test1 = new Complex_Number(2.5,-7);
        test2 = new Complex_Number(5.3,2);
        test3 = new Complex_Number(0.283678,-0.0012);
        test4 = new Complex_Number(1.475,0.837);
        test5 = new Complex_Number(2.11,-6,3);
        test6 = new Complex_Number(-3.12,-4,2);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void round()
    {
        assertEquals(new Complex_Number(0.28,0),Complex_Calculations.round(test3,2));
        assertEquals(new Complex_Number(1.567,-2.456),Complex_Calculations.round(new Complex_Number(1.56681235,-2.456389),3));
    }
    
    @Test
    public void simplify()
    {
        assertEquals(new Complex_Number(2.5,-7),Complex_Calculations.simplify_i(test1));
        assertEquals(new Complex_Number(2.11,6),Complex_Calculations.simplify_i(test5));
        assertEquals(new Complex_Number(0.88,0,0),Complex_Calculations.simplify_i(test6));
    }
    
    @Test
    public void addition()
    {
        assertEquals(new Complex_Number(7.8,-5),Complex_Calculations.addition(test1,test2));
        assertEquals(new Complex_Number(1.758678,0.8358),Complex_Calculations.addition(test3, test4));
        assertEquals(new Complex_Number(2.99,6,1),Complex_Calculations.addition(test5, test6));
    }
    
    @Test
    public void multiplication()
    {
        assertEquals(new Complex_Number(27.25,-32.1),Complex_Calculations.multiplication(test1,test2));
        assertEquals(new Complex_Number(0.41942945,0.235668486),Complex_Calculations.multiplication(test3, test4));
        assertEquals(new Complex_Number(1.8568,5.28),Complex_Calculations.multiplication(test5, test6));
    }
    
    @Test
    public void pow()
    {
        assertEquals(new Complex_Number(1.0,0),Complex_Calculations.pow(test1,0));
        assertEquals(new Complex_Number(2.5,-7),Complex_Calculations.pow(test1,1));
        assertEquals(new Complex_Number(24.09,21.2),Complex_Calculations.pow(test2,2));
        assertEquals(new Complex_Number(0.080471767684,-0.0006808272),Complex_Calculations.pow(test3,2));
        assertEquals(new Complex_Number(0.0228272531204218,-0.0002897018196624),Complex_Calculations.pow(test3,3));
        assertEquals(new Complex_Number(0.681472,0),Complex_Calculations.pow(test6,3));
        assertEquals(new Complex_Number(-218.486069,-135.8622),Complex_Calculations.pow(test5,3));
        assertEquals(new Complex_Number(0,0.08),Complex_Calculations.pow(new Complex_Number(0.2,0.2),2));
    }
    
    @Test
    public void abs()
    {
        assertEquals(2.0,Complex_Calculations.abs(new Complex_Number(2,0)),0.0001);
        assertEquals(1.0,Complex_Calculations.abs(new Complex_Number(-1,0)),0.0001);
        assertEquals(1.51162,Complex_Calculations.abs(new Complex_Number(1.25,0.85)),0.00001);
        assertEquals(1.8243193,Complex_Calculations.abs(new Complex_Number(-0.579,1.73)),0.0001);
    }
    
    @Test
    public void division()
    {
        Complex_Number top = new Complex_Number(2,6);
        Complex_Number bottom = new Complex_Number(4,1);
        assertEquals(new Complex_Number(14.0/17.0,22.0/17.0,1),Complex_Calculations.division(top,bottom));
        assertEquals(new Complex_Number(-0.0233717669055781,-1.31193518229978),Complex_Calculations.division(test1,test2));
        assertEquals(new Complex_Number(0.145129518384365,-0.0831684114492973),Complex_Calculations.division(test3,test4));
        assertEquals(new Complex_Number(2.39772727272727,+6.81818181818182,1),Complex_Calculations.division(test5,test6));
        assertEquals(new Complex_Number(1,1.11022302462516E-16),Complex_Calculations.division(new Complex_Number(0.15,0.15),new Complex_Number(0.15,0.15)));
        assertEquals(new Complex_Number(0.15,0.15),Complex_Calculations.division(new Complex_Number(0.15,0.15),new Complex_Number(1,0)));
    }
}
