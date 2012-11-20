/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Panel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Henri Korpela
 */
public class ReadProperties {
    private JCheckBox RGBValueCheck;
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
     * 
     * @param RGBValueCheck
     * @param width
     * @param heigth
     * @param zoom
     * @param center
     * @param function
     * @param KValue
     * @param name
     * @param accurancy
     * @param comR
     * @param comG
     * @param comB
     * @param bgR
     * @param bgG
     * @param bgB
     * @param seR
     * @param seB
     * @param seG 
     */
    public ReadProperties(JCheckBox RGBValueCheck, JTextField width, JTextField heigth, JTextField zoom, JTextField center, JTextField function, JTextField KValue, JTextField name, JTextField accurancy, JTextField comR, JTextField comG, JTextField comB, JTextField bgR, JTextField bgG, JTextField bgB, JTextField seR, JTextField seB, JTextField seG) {
        this.RGBValueCheck = RGBValueCheck;
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
    
    public void fillSetAndWindowProperties(InsertedSetProperties setProps,
            InsertedWindowProperties winProps)
    {
        
    }
}
