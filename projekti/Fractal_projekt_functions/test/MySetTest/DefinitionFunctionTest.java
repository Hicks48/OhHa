
package MySetTest;

import MyMath.Complex_Number;
import java.util.Random;
import MySet.DefinitionFunction;
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
public class DefinitionFunctionTest {
    private DefinitionFunction test1;
    private DefinitionFunction test2;
    private DefinitionFunction test3;
    public DefinitionFunctionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.test1 = new DefinitionFunction("+1.0+0.0iz2;+0.285+0.01iz0/+1.0+0.0iz0");
        this.test2 = new DefinitionFunction("+0.25-3.12iz3;+0.0+0.0iz0/+0.825-1.21iz2");
        this.test3 = new DefinitionFunction("-0.0001+0.856iz5;+3.12+0.0iz1;-1.74-1.75iz2/+0.12+0.003iz1;-0.16+3.142iz2");
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void toStringTest() 
     {
         assertEquals("1.0 * z^2 + 0.285 + 0.01i * z^0 / 1.0 * z^0",this.test1.toString());
         assertEquals("0.25 + -3.12i * z^3 + 0.0 * z^0 / 0.825 + -1.21i * z^2",this.test2.toString());
         assertEquals("-1.0E-4 + 0.856i * z^5 + 3.12 * z^1 + -1.74 + -1.75i * z^2 /"
                 + " 0.12 + 0.003i * z^1 + -0.16 + 3.142i * z^2",this.test3.toString());
     }
     
     @Test
     public void countValue()
     {
         assertEquals(new Complex_Number(-1.21037024,+0.335704),this.test1.countValue(new Complex_Number(0.1324,+1.23)));
         assertEquals(new Complex_Number(0.25981431,+0.01),this.test1.countValue(new Complex_Number(0,0.1587)));
         assertEquals(new Complex_Number(0.285,+0.09),this.test1.countValue(new Complex_Number(0.2,0.2)));
         assertEquals(new Complex_Number(0.285,+0.055),this.test1.countValue(new Complex_Number(0.15,0.15)));
         
         assertEquals(new Complex_Number(-2.4328924221054,+2.10160020515451),this.test2.countValue(new Complex_Number(-01.476,+0.29)));
         assertEquals(new Complex_Number(4.81128606231568,+0.281643800487242),this.test2.countValue(new Complex_Number(1.89,+1.23)));
         
         assertEquals(new Complex_Number(-0.780698614980271,+1.14988342247666),this.test3.countValue(new Complex_Number(0.457891,-1.556234)));
         assertEquals(new Complex_Number(-9.55005767388207,+1.31260421620132),this.test3.countValue(new Complex_Number(0,0.15)));
     }
     
     @Test
     public void JuliaVsTest()
     {
         Random generator = new Random();
         Complex_Number K = new Complex_Number(0.285,0.01);
         DefinitionFunction function = new DefinitionFunction("+1.0+0.0iz2;+0.285+0.01iz0/+1.0+0.0iz0");
         for(int i = 0;i < 20;i ++)
         {
             Complex_Number z = createNumber(generator);
             assertEquals(MyMath.Complex_Calculations.addition(MyMath.Complex_Calculations.pow(z,2),K),
                     function.countValue(z));
         }
     }
     
     private Complex_Number createNumber(Random generator)
     {
         double realPart = generator.nextInt(3) + generator.nextDouble();
         double imaginaryPart = generator.nextInt(3) + generator.nextDouble();
         return new Complex_Number(realPart,imaginaryPart);
     }
}
