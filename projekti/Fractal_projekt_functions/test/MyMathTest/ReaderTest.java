
package MyMathTest;

import MyMath.Reader;
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
public class ReaderTest {
    private Reader test;
    
    public ReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test = new Reader(0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSetPoint()
    {
        assertEquals(0,this.test.getPoint());
        this.test.setPoint(3);
        assertEquals(3,this.test.getPoint());
        this.test.setPoint(-3);
        assertEquals(-3,this.test.getPoint());
    }
}
