
package MySetTest;

import MyMath.Complex_Number;
import MySet.GeneralJulia;
import MySet.Julia;
import MySet.Set;
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
public class SetTest {
    private Set test1;
    private Set test2;
    private Set test3;
    
    public SetTest() {
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
        this.test1 = new Julia(new Complex_Number(0.235,-0.14),"test1",5);
        this.test2 = new Julia(new Complex_Number(-1.45,0.45),"test2",5);
        this.test3 = new GeneralJulia("+1.45-0.12iz2;+0.14-1.12iz1/+0.12-1.43iz2","test3",3);
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test bolngsToSet method and updateValues method.
     */
    @Test
    public void belongsToSetAndUpdateValuesTest()
    {
        assertEquals(0,this.test1.belongsToSet(new Complex_Number(0.15,-0.46)));
        assertEquals(5,this.test2.belongsToSet(new Complex_Number(0.25,-0.25)));
        assertEquals(0,this.test3.belongsToSet(new Complex_Number(1.15,-1.48)));
        
        Complex_Number []update1 = this.test1.updateValues();
        Complex_Number []update2 = this.test2.updateValues();
        Complex_Number []update3 = this.test3.updateValues();
        
        assertEquals(new Complex_Number(0.24569877436678159,-0.25596168506538125),update1[0]);
        assertEquals(update1[1],null);
        
        assertEquals(new Complex_Number(0.4839349132936097,0.6971256753540039),update2[0]);
        assertEquals(new Complex_Number(-1.7017912069332826,1.1247269065143781),update2[1]);
        
        assertEquals(new Complex_Number(1.012178865002261,-0.033920626251568504),update3[0]);
        assertEquals(null,update3[1]);
    }
    
    /**
     * Tests getName method
     */
    @Test
    public void getName()
    {
        assertEquals("test1",this.test1.getName());
        assertEquals("test2",this.test2.getName());
        assertEquals("test3",this.test3.getName());
    }
    /**
     * Tests getAccuracy method.
     */
    @Test
    public void getAccuracy()
    {
        assertEquals(5,this.test1.getAccurancy());
        assertEquals(5,this.test2.getAccurancy());
        assertEquals(3,this.test3.getAccurancy());
    }
}
