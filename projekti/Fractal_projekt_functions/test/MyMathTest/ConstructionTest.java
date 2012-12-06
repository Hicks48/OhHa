
package MyMathTest;

import MyMath.Complex_Number;
import MyMath.Construction;
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
public class ConstructionTest {
    private String num1;
    private String num2;
    private String num3;
    
    public ConstructionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.num1 = "+1.42-0.53i";
        this.num2 = "-2.53+--1.24i";
        this.num3 = "+0.14-1.42";
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructionTest()
    {
        assertEquals(new Complex_Number(1.42,-0.53),Construction.construct(this.num1));
        assertEquals(new Complex_Number(-2.53,+1.24),Construction.construct(this.num2));
        assertEquals(new Complex_Number(0.14,-1.42),Construction.construct(this.num3));
        try
        {
            Construction.construct("0.14-0,15");
            assertTrue(false);
        }
        catch(Exception e)
        { }
    }
}
