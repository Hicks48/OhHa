
package FractalViewWindowTest;

import FractalViewWindow.RGB;
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
public class RGBTest {
    private RGB test1;
    private RGB test2;
    private RGB test3;
    
    public RGBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test2 = new RGB(0,0,0);
        this.test1 = new RGB(1,1,1);
        this.test3 = new RGB(-1,0,0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringTest()
    {
        assertEquals("R: 1 G: 1 B: 1",this.test1.toString());
        assertEquals("R: 0 G: 0 B: 0",this.test2.toString());
        assertEquals("R: -1 G: 0 B: 0",this.test3.toString());
    }
    
    @Test
    public void saveTest()
    {
        assertEquals("1&1&1",this.test1.save());
        assertEquals("0&0&0",this.test2.save());
        assertEquals("-1&0&0",this.test3.save());
    }
    
    @Test
    public void testIsValid()
    {
        assertTrue(this.test1.isValid());
        assertTrue(this.test2.isValid());
        assertTrue(!this.test3.isValid());
    }
    
    @Test
    public void testGetters()
    {
        assertEquals(1,this.test1.getRed());
        assertEquals(1,this.test1.getGreen());
        assertEquals(1,this.test1.getBlue());
        
        assertEquals(0,this.test2.getRed());
        assertEquals(0,this.test2.getGreen());
        assertEquals(0,this.test2.getBlue());
        
        assertEquals(-1,this.test3.getRed());
        assertEquals(0,this.test3.getGreen());
        assertEquals(0,this.test3.getBlue());
    }
    
}
