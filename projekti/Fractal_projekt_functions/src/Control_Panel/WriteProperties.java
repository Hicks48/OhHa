
package Control_Panel;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 * Writes loaded properties into screen fields.
 * @author Henri Korpela
 */
public class WriteProperties {
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
    public WriteProperties(JCheckBox RGBValueCheck,JCheckBox escapes,JCheckBox sin,
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
     * Fills screens information fields with 
     * information that has been loaded.
     * @param props String that is in save format.
     * String contains all properties that are needed
     * create and draw a set.
     */
    public void writeProps(String props)
    {
        String[] setAndWin = props.split("#");
        this.writeSetProps(setAndWin[0]);
        this.writeWinProps(setAndWin[1]);
    }
    /**
     * Fills screens information fields that
     * are related to set.
     * Name, accuracy, function and K value.
     * @param setProps Contains name, accuracy, function
     * and K value separated by ":".
     */
    private void writeSetProps(String setProps)
    {
        String[] parts = setProps.split(":");
        this.name.setText(parts[0]);
        this.accurancy.setText(parts[1]);
        this.function.setText(parts[2]);
        this.KValue.setText(parts[3]);
    }
    /**
     * Fills screens information fields that
     * is related to window.
     * Center, width, height, zoom,
     * sets main color, secondary color,
     * background color, coloring algorithm
     * and coloring value check.
     * @param winProps Contains all window related information.
     */
    private void writeWinProps(String winProps)
    {
        String[] parts = winProps.split(":");
        this.center.setText(parts[0]);
        this.width.setText(parts[1]);
        this.heigth.setText(parts[2]);
        this.zoom.setText(parts[3]);
        
        String[] com = parts[4].split("&");
        String[] se = parts[5].split("&");
        String[] bg = parts[6].split("&");
        
        this.comR.setText(com[0]);
        this.comG.setText(com[1]);
        this.comB.setText(com[2]);
        
        this.seR.setText(se[0]);
        this.seG.setText(se[1]);
        this.seB.setText(se[2]);
        
        this.bgR.setText(bg[0]);
        this.bgG.setText(bg[1]);
        this.bgB.setText(bg[2]);
        
        int coloringAlgorithm = Integer.parseInt(parts[7]);
        if(coloringAlgorithm == 1)
        {
            this.escapes.setSelected(true);
        }
        else if(coloringAlgorithm == 2)
        {
            this.sin.setSelected(true);
        }
        else if(coloringAlgorithm == 3)
        {
            this.cos.setSelected(true);
        }
        
        String RGBValueCheck = parts[8];
        if(RGBValueCheck.equals("true"))
        {
            this.RGBValueCheck.setSelected(true);
        }
    }
}
