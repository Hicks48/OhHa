
package Control_Panel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reads inserted properties from information fields
 * of the screen.
 * Fills given InsertedSetProperties object
 * and InsertedwindowProperties object.
 * @author Henri Korpela
 */
public class ReadProperties {
    private JCheckBox RGBValueCheck;
    private JCheckBox escapes;
    private JCheckBox sin;
    private JCheckBox cos;
    
    private JTextField width;
    private JTextField heigth;
    private JTextField zoom;
    private JTextField center;
    
    private JTextField function;
    private JTextField KValue;
    private JTextField name;
    private JTextField accurancy;
    
    private JTextField comR;
    private JTextField comG;
    private JTextField comB;
    
    private JTextField bgR;
    private JTextField bgG;
    private JTextField bgB;
    
    private JTextField seR;
    private JTextField seB;
    private JTextField seG;
    
    /**
     * Creates new WriteProperties.
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
     */
    public ReadProperties(JCheckBox RGBValueCheck,JCheckBox escapes,JCheckBox sin,
            JCheckBox cos, JTextField width, JTextField heigth,
            JTextField zoom, JTextField center, JTextField function, JTextField KValue,
            JTextField name, JTextField accurancy, JTextField comR, JTextField comG,
            JTextField comB, JTextField bgR, JTextField bgG, JTextField bgB, JTextField seR,
            JTextField seB, JTextField seG) {
        this.RGBValueCheck = RGBValueCheck;
        this.escapes = escapes;
        this.sin = sin;
        this.cos = cos;
        this.width = width;
        this.heigth = heigth;
        this.zoom = zoom;
        this.center = center;
        this.function = function;
        this.KValue = KValue;
        this.name = name;
        this.accurancy = accurancy;
        this.comR = comR;
        this.comG = comG;
        this.comB = comB;
        this.bgR = bgR;
        this.bgG = bgG;
        this.bgB = bgB;
        this.seR = seR;
        this.seB = seB;
        this.seG = seG;
    }
    /**
     * Fills InsertedSetProperties object and InsertedWindowProperties object
     * with properties of the screens information fields.
     * @param setProps InsertedSetProperties object that will
     * be filled with information related to set.
     * @param winProps InsertedWindowProperties object that will be
     * filled with information related to window.
     * @return String containing possible errors.
     * @throws Exception If can't interpret information fields values.
     */
    public String fillSetAndWindowProperties(InsertedSetProperties setProps,
            InsertedWindowProperties winProps) throws Exception
    {
        String errors = "";
        int heigth = Integer.parseInt(this.heigth.getText());
        int width = Integer.parseInt(this.width.getText());
        
        String center = this.center.getText();
        double zoom = Double.parseDouble(this.zoom.getText());
        
        int comR = Integer.parseInt(this.comR.getText());
        int comG = Integer.parseInt(this.comG.getText());
        int comB = Integer.parseInt(this.comB.getText());
        
        int seR = Integer.parseInt(this.seR.getText());
        int seG = Integer.parseInt(this.seG.getText());
        int seB = Integer.parseInt(this.seB.getText());
        
        int bgR = Integer.parseInt(this.bgR.getText());
        int bgG = Integer.parseInt(this.bgG.getText());
        int bgB = Integer.parseInt(this.bgB.getText());
        
        
        String name = this.name.getText();
        String function = this.function.getText();
        String K = this.KValue.getText();
        int accuracy = Integer.parseInt(this.accurancy.getText());
        
        int coloringAlgorithm = 0;
        if(this.escapes.isSelected())
        {
            coloringAlgorithm = 1;
        }
        else if(this.sin.isSelected())
        {
            coloringAlgorithm = 2;
        }
        else if(this.cos.isSelected())
        {
            coloringAlgorithm = 3;
        }
        
        winProps.setRGBValueCheck(this.RGBValueCheck.isSelected());
        
        CheckAndSetProperties checkAndSet = new CheckAndSetProperties();
        errors = checkAndSet.chekProps(comR, comG, comB, seR, seG, seB, bgR, bgG, bgB, zoom, heigth,
                width, center, winProps, name,function,K,accuracy,coloringAlgorithm,setProps);
        return errors;
    }
}
