
package MySetTest;

import MyMath.Complex_Number;
import MySet.Julia;
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
public class JuliaTest {
    private Julia test1;
    private Julia test2;
    private Julia test3;
    
    public JuliaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test1 = new Julia(new Complex_Number(0.254,-1.24),"test1",5);
        this.test2 = new Julia(new Complex_Number(1.93,-0,12),"test2",5);
        this.test3 = new Julia(new Complex_Number(-1.34,1.21),"test3",5);
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test Julia class belongsToSet method.
     */
    @Test
    public void belongsToSetTest()
    {
        assertEquals(2,this.test1.belongsToSet(new Complex_Number(-0.486,-1.45)));
        assertEquals(1,this.test2.belongsToSet(new Complex_Number(0.97,-0.84)));
        assertEquals(2,this.test3.belongsToSet(new Complex_Number(-1.75,0.125)));
    }
}
