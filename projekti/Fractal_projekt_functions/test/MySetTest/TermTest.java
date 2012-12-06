
package MySetTest;

import MySet.Term;
import MyMath.Complex_Number;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test function of term class.
 * @author Henri Korpela
 */
public class TermTest {
    private Term test1;
    private Term test2;
    private Term test3;
    private Term test4;
    public TermTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test1 = new Term("+1+0iz2");
        this.test2 = new Term("+-4+2iz1");
        this.test3 = new Term("+3.123-1.561iz2");
        this.test4 = new Term("--5.46+1.34iz3");
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Tests countValue method.
     */
    @Test
    public void countValue()
    {
        assertEquals(new Complex_Number(0,0),this.test1.countValue(new Complex_Number(0,0)));
        assertEquals(new Complex_Number(6.24,-12.8),this.test1.countValue(new Complex_Number(-3.2,+2)));
        assertEquals(new Complex_Number(0.0,0.045),this.test1.countValue(new Complex_Number(0.15,0.15)));
        
        assertEquals(new Complex_Number(-4.1,+0.3),this.test2.countValue(new Complex_Number(0.85,+0.35)));
        assertEquals(new Complex_Number(6.0752,-2.4196),this.test2.countValue(new Complex_Number(-1.457,-0.1236)));
        
        assertEquals(new Complex_Number(3.3879957,-0.5458999),this.test3.countValue(new Complex_Number(-0.98,-0.15)));
        assertEquals(new Complex_Number(-14.4360675,+7.2157225),this.test3.countValue(new Complex_Number(0,-2.15)));
        
        assertEquals(new Complex_Number(0.01137439054,-0.04351592534),this.test4.countValue(new Complex_Number(-0.001,+0.2)));
        assertEquals(new Complex_Number(9.67272306,+2.37389174),this.test4.countValue(new Complex_Number(1.21,0)));
    }
    /**
     * Tests to String method.
     */
    @Test
    public void toStringTest() 
    {
        assertEquals("1.0 * z^2",this.test1.toString());
        assertEquals("-4.0 + 2.0i * z^1",this.test2.toString());
        assertEquals("3.123 + -1.561i * z^2",this.test3.toString());
        assertEquals("5.46 + 1.34i * z^3",this.test4.toString());
    }
}
