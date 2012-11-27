
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
     * 
     * @param name
     * @param RGBValueCheck
     * @param width
     * @param heigth
     * @param zoom
     * @param center
     * @param function
     * @param KValue
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
     * @param errors 
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
