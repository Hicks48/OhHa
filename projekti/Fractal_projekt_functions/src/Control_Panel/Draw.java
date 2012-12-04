
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
 * Draws set on a window that it creates.
 * @author Henri Korpela
 */
public class Draw implements ActionListener{
    private InsertedSetProperties setProps;
    private InsertedWindowProperties winProps;
    private ReadProperties reader;
    private JTextArea errors;
    /**
     * Creates new Draw button listener.
     * @param RGBValueCheck Check box which tells whether 
     * RGB value check is used.
     * @param escapes Check box 
     * which tells is escapes coloring algorithm selected.
     * @param sin Check box 
     * which tells is sin coloring algorithm selected.
     * @param cos Check box 
     * which tells is cos coloring algorithm selected.
     * @param width field that contains width of the window.
     * @param heigth field that contains height of the window.
     * @param zoom field that contains zoom value of the window. 
     * @param center field that contains complex-number that
     * is at the center of the window.
     * @param function field that contains function of the set. 
     * @param KValue field that contains K value of set.
     * @param name field that contains name of the set.
     * @param accurancy field that contains accuracy of the set.
     * @param comR field that contains red RGB value of main color of the set.
     * @param comG field that contains green RGB value of main color of the set.
     * @param comB field that contains blue RGB value of main color of the set.
     * @param bgR field that contains red RGB value of background
     * color of the window.
     * @param bgG field that contains green RGB value of background
     * color of the window.
     * @param bgB field that contains blue RGB value of background
     * color of the window.
     * @param seR field that contains red RGB value of secondary
     * color of the set.
     * @param seB field that contains blue RGB value of secondary
     * color of the set.
     * @param seG field that contains green RGB value of secondary
     * color of the set.
     * @param errors field that errors are displayed.
     */
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
    /**
     * Starts when draw button is clicked.
     * Creates a window and draws a set on the screen.
     * @param e Event that occurs when draw button is clicked.
     */
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
