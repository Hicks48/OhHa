
package MySetTest;

import MySet.Polynom;
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
public class PolynomTest {
    private Polynom test1;
    private Polynom test2;
    private Polynom test3;
    public PolynomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test1 = new Polynom("+3.12+0.132iz1;+2.14+0.0iz0");
        this.test2 = new Polynom("+1+0iz2;+2.34-0.14iz1;+0.18-0.1398iz0");
        this.test3 = new Polynom("-0.15-+0.12iz3;0.14+2.15iz2");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringTest() 
    {
        assertEquals("3.12 + 0.132i * z^1 + 2.14 * z^0",this.test1.toString());
        assertEquals("1.0 * z^2 + 2.34 + -0.14i * z^1 + 0.18 + -0.1398i * z^0",this.test2.toString());
        assertEquals("-0.15 + -0.12i * z^3 + 0.14 + 2.15i * z^2",this.test3.toString());
    }
    
    @Test
    public void countValue()
    {
        assertEquals(new Complex_Number(1.8334,+6.175686),this.test1.countValue(new Complex_Number(-0.0145,+1.98)));
        assertEquals(new Complex_Number(2.14312,+0.000132),this.test1.countValue(new Complex_Number(0.001,0)));
        assertEquals(new Complex_Number(2.5882,+0.4878),this.test1.countValue(new Complex_Number(0.15,0.15)));
        
        assertEquals(new Complex_Number(-3.1665,+5.1192),this.test2.countValue(new Complex_Number(0.15,+2)));
        assertEquals(new Complex_Number(0.17649111,+0.238578),this.test2.countValue(new Complex_Number(0,0.1617)));
        
        assertEquals(new Complex_Number(-2.6866376,-8.15886611),this.test3.countValue(new Complex_Number(0.12,+2.15)));
        assertEquals(new Complex_Number(0,0),this.test3.countValue(new Complex_Number(0,0)));
    }
}
