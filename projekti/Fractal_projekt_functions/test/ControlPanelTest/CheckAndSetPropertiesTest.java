
package ControlPanelTest;

import Control_Panel.CheckAndSetProperties;
import Control_Panel.InsertedSetProperties;
import Control_Panel.InsertedWindowProperties;
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
public class CheckAndSetPropertiesTest {
    private CheckAndSetProperties checkAndSetProps;
    private InsertedSetProperties insSetProps;
    private InsertedWindowProperties insWinProps;
    
    public CheckAndSetPropertiesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.checkAndSetProps = new CheckAndSetProperties();
        this.insSetProps = new InsertedSetProperties();
        this.insWinProps = new InsertedWindowProperties();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void functionAndKvalueTest()
    {
        String errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.2850.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("K value error")
                && errorMessage.contains("function error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("K value error")
                && errorMessage.contains("function error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "+1.0+0.0iz2;+0.285+0.001iz0/+1.0+0.0iz0"
                , "", 50,
                1, this.insSetProps);
        
        if(errorMessage != null && errorMessage.isEmpty())
        {
            assertTrue(false);
        }
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "+1.0+0.0iz2;+0.285+0.001iz0+1.0+0.0iz0", "", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("K value error")
                && errorMessage.contains("function error"));
    }
    
    @Test
    public void nameTest()
    {
        String errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        if(errorMessage != null && !errorMessage.isEmpty())
        {
            assertTrue(false);
        }
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("name error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "gesdgrhrhfgfbrgrgs", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        if(errorMessage != null && !errorMessage.isEmpty())
        {
            assertTrue(false);
        }
    }
    
    @Test
    public void errorMessagesTest()
    {
        String errorMessage = this.checkAndSetProps.chekProps(10,0,256,
                45, -0, 1, -1, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("background color error") &&
                errorMessage.contains("set color error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, -0, 1, 14, 255, 255, 1.0, 0, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("heigth error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800,-1, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("width error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", -1,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("accuracy error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 0.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        assertTrue(errorMessage.contains("zoom error"));
        
        errorMessage = this.checkAndSetProps.chekProps(10,0,255,
                45, 0, 1, 14, 255, 255, 1.0, 800, 800, "+0.0+0.0i",
                this.insWinProps, "test", "", "+0.285+0.001i", 50,
                1, this.insSetProps);
        
        if(errorMessage != null && !errorMessage.isEmpty())
        {
            assertTrue(false);
        }
    }
}
