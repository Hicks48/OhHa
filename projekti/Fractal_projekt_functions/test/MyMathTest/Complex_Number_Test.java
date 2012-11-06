package MyMathTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import MyMath.Complex_Number;
/**
 *
 * @author henrikorpela
 */
public class Complex_Number_Test {
    
    public Complex_Number_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructor()
    {
        assertEquals(new Complex_Number(0.45,0,0),new Complex_Number(0.45));
        assertEquals(new Complex_Number(0.5,3.45,1),new Complex_Number(0.5,3.45));
        assertEquals(new Complex_Number(-0.5,3.45,1),new Complex_Number(-0.5,3.45));
        assertEquals(2,new Complex_Number(0.45,0.93,2).getPower());
        assertEquals(3,new Complex_Number(0.45,0.93,3).getPower());
    }
    
    @Test
    public void equals()
    {
        assertEquals(true,new Complex_Number(0.83,0.5).equals(new Complex_Number(0.83,0.5)));
        assertEquals(false,new Complex_Number(0.83,0.5).equals(new Complex_Number(0.83,0.6)));
        assertEquals(true,new Complex_Number(0.83,0.5).equals(new Complex_Number(0.830000000000000003,0.50000000000001)));
        assertEquals(true,new Complex_Number(0.83,0.5).equals(new Complex_Number(0.83,0.5)));
        assertEquals(true,new Complex_Number(0.88,0.0,0).equals(new Complex_Number(0.88,0.0,0)));
        assertEquals(false,new Complex_Number(0.88,0.0,1).equals(new Complex_Number(0.88,0.0,0)));
        assertEquals(false,new Complex_Number(-0.88,0.0,0).equals(new Complex_Number(0.88,0.0,0)));
        assertEquals(true,new Complex_Number(-0.88,0.0,0).equals(new Complex_Number(-0.88,0.0,0)));
    }
    
    @Test
    public void toStringTest()
    {
        assertEquals("0.88 + 4.0i",new Complex_Number(0.88,4).toString());
        assertEquals("0.88",new Complex_Number(0.88,0,0).toString());
        assertEquals("0.88 + 2.0i^2",new Complex_Number(0.88,2,2).toString());
        assertEquals("-0.88 + 3.56i",new Complex_Number(-0.88,3.56).toString());
        assertEquals("-0.88 + -3.56i",new Complex_Number(-0.88,-3.56).toString());
    }
    
    @Test
    public void round()
    {
        assertEquals(3.15,new Complex_Number(0,0,0).round(3.15,2),0.00001);
        assertEquals(3.15,new Complex_Number(0,0,0).round(3.1542354656,2),0.0001);
        assertEquals(3.16,new Complex_Number(0,0,0).round(3.1582354656,2),0.0001);
        assertEquals(5.46,new Complex_Number(0,0,0).round(5.455,2),0.0001);
        assertEquals(3.1583,new Complex_Number(0,0,0).round(3.1583402343,4),0.0001);
    }
}
