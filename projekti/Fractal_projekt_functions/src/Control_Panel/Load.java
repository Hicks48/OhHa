
package Control_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.io.File;
import java.util.Scanner;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
/**
 * Loads set from the file.
 * @author Henri Korpela
 */
public class Load implements ActionListener{  
    private JTextField name;
    private JTextArea errors;
    private InsertedSetProperties setProps;
    private InsertedWindowProperties winProps;
    private WriteProperties writeProperties;
    /**
     * Creates new load button listener.
     * @param name field that contains name of the set.
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
    public Load(JTextField name,JCheckBox RGBValueCheck,JCheckBox escapes,JCheckBox sin,
            JCheckBox cos, JTextField width, JTextField heigth,
            JTextField zoom, JTextField center, JTextField function, JTextField KValue,
            JTextField accurancy, JTextField comR, JTextField comG,
            JTextField comB, JTextField bgR, JTextField bgG, JTextField bgB, JTextField seR,
            JTextField seB, JTextField seG,JTextArea errors)
    {
        this.name = name;
        this.errors = errors;
        this.setProps = new InsertedSetProperties();
        this.winProps = new InsertedWindowProperties();
        this.writeProperties = new WriteProperties(RGBValueCheck,escapes,sin,cos,width,heigth,
            zoom,center,function,KValue,
            name,accurancy,comR,comG,
            comB,bgR,bgG,bgB,seR,
            seB,seG);
    }
    /**
     * Loads set thats name corresponds given name.
     * Sets values are putted into the corresponding fields.
     * If set of given name is not found error message is
     * displayed on the error field.
     * @param e Event that occurs when users clicks load button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String props = this.readSet(this.name.getText());
        if(props.equals("Error: No file found.") || props.equals("No set found."))
        {
            this.errors.setText(props);
            return;
        }
        this.writeProperties.writeProps(props);
    }
    /**
     * Reads SavedSets file and tries to find a set thats name 
     * is same as the name of the sets that's searched.
     * @param name Name of the set thats been searched.
     * @return String array that contains information of the set.
     */
    private String readSet(String name)
    {
        this.errors.setText("");
        File setFile = new File("SavedSets.txt");
        Scanner reader;
        try
        {
            reader = new Scanner(setFile);
        }
        catch(Exception e)
        {
            return "Error: No file found.";
        }
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            String linesName = this.readName(line);
            if(linesName.equals(name))
            {
                return line;
            }
        }
        return "No set found.";
    }
    /**
     * Reads name of the set that has been saved on the given line.
     * @param line Line which name method returns.
     * @return Name of the set saved on the line.
     */
    private String readName(String line)
    {
        String name = "";
        int i = 0;
        while(i < line.length() && line.charAt(i) != ':')
        {
            name = name + line.charAt(i);
            i ++;
        }
        return name;
    }
}
