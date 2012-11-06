/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FractalViewWindowTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import FractalViewWindow.Window_Calculations;
import MyMath.Complex_Number;
/**
 *
 * @author henrikorpela
 */
public class Window_Calculations_Test {
    public Window_Calculations_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pixelGap() 
    {
        assertEquals(5.06E-3,Window_Calculations.pixelGap(0.5),0.0001);
        assertEquals(2.5E-3,Window_Calculations.pixelGap(1.0),0.0001);
        assertEquals(1.25E-5,Window_Calculations.pixelGap(200.0),0.0001);
    }
    
    @Test
    public void windowCoordinateSystemLimits()
    {
        
    }
    
    @Test
    public void pixel()
    {
        assertEquals(new Complex_Number(0,0),Window_Calculations.pixel(new Complex_Number(0,0),1.0,400,400,800,800));
        assertEquals(new Complex_Number(0,0),Window_Calculations.pixel(new Complex_Number(0,0),1.0,600,600,1200,1200));
        assertEquals(new Complex_Number(0,0),Window_Calculations.pixel(new Complex_Number(0,0),0.5,600,600,1200,1200));
        assertEquals(new Complex_Number(0.78,-0.15),Window_Calculations.pixel(new Complex_Number(0.78,-0.15),0.5,600,600,1200,1200));
    }
}
