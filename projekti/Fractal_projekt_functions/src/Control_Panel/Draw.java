
package Control_Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import FractalViewWindow.Window;
import MyMath.*;
import MySet.*;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 
 * @author Henri Korpela
 */
public class Draw implements ActionListener{
    private InsertedSetProperties setProps;
    private InsertedWindowProperties winProps;
    private ReadProperties reader;
    private JTextArea errors;
    
    public Draw(JCheckBox RGBValueCheck,JCheckBox escapes,JCheckBox sin,
            JCheckBox cos, JTextField width, JTextField heigth, JTextField zoom,
            JTextField center, JTextField function, JTextField KValue, JTextField name,
            JTextField accurancy, JTextField comR, JTextField comG, JTextField comB, JTextField bgR,
            JTextField bgG, JTextField bgB, JTextField seR, JTextField seB, JTextField seG,JTextArea errors)
    {
        this.setProps = new InsertedSetProperties();
        this.winProps = new InsertedWindowProperties();
        this.errors = errors;
        this.reader = new ReadProperties(RGBValueCheck,escapes,sin,cos,width,heigth,zoom,center,function,KValue,name,accurancy,comR,comG,comB,bgR,bgG,bgB,seR,seB,seG);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.errors.setText("");
        this.setProps.clear();
        this.winProps.clear();
        String errors = null;
        try
        {
            errors = this.reader.fillSetAndWindowProperties(this.setProps,this.winProps);
        }
        catch(Exception thisException)
        {
            this.errors.setText("Incorrect Input");
            return;
        }
        if(errors == null)
        {
            this.createFractal();
        }
        else
        {
            this.errors.setText(errors);
        }
    }
    /**
     * Creates set and screen that the set is presented.
     */
    private void createFractal()
    {
        Set set = this.setProps.createSet();
        Window fractalWin = this.winProps.createWindow(set);
        fractalWin.run();
    }
}
