
package Control_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Saves set and window values of screens fields.
 * @author Henri Korpela
 */
public class Save implements ActionListener{
    private ReadProperties reader;
    private JTextArea errors;
    private JTextField name;
    private InsertedSetProperties setProps;
    private InsertedWindowProperties winProps;
    /**
     * Creates new Save button listener.
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
    public Save(JCheckBox RGBValueCheck,JCheckBox escapes,JCheckBox sin,
            JCheckBox cos, JTextField width, JTextField heigth,
            JTextField zoom, JTextField center, JTextField function, JTextField KValue,
            JTextField name, JTextField accurancy, JTextField comR, JTextField comG,
            JTextField comB, JTextField bgR, JTextField bgG, JTextField bgB, JTextField seR,
            JTextField seB, JTextField seG,JTextArea errors)
    {
        this.name = name;
        this.setProps = new InsertedSetProperties();
        this.winProps = new InsertedWindowProperties();
        this.errors = errors;
        this.reader = new ReadProperties(RGBValueCheck,escapes,sin,cos,width,heigth,
            zoom,center,function,KValue,
            name,accurancy,comR,comG,
            comB,bgR,bgG,bgB,seR,seB,seG);
    }
    /**
     * Reads original text in the file.
     * @return Original text in the file.
     */
    private String readOriginal(Scanner reader)
    {
        String lines = "";
        while(reader.hasNextLine())
        {
            lines = lines + reader.nextLine() + "\n";
        }
        return lines;
    }
    /**
     * Starts when save button is clicked.
     * Saves current values on the screens informations fields.
     * If information fields values aren't valid doesn't save
     * values but writes error in the error field of the screen.
     * @param e Action that occurs when save button is clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setProps.clear();
        this.winProps.clear();
        String errors = null;
        try
        {
            errors = this.reader.fillSetAndWindowProperties(this.setProps,this.winProps);
        }
        catch(Exception thisException1)
        {
            this.errors.setText("Incorrect Input");
        }
        if(errors == null)
        {
            this.errors.setText("");
            try
            {
                File file = new File("SavedSets.txt");
                Scanner reader = new Scanner(file);
                String original = this.readOriginal(reader);
                if(original.contains(this.name.getText()))
                {
                    this.errors.setText("Invalid name: name already exists.");
                    return;
                }
                FileWriter writer = new FileWriter("SavedSets.txt");
                original = original + this.setProps.save() + "#" + this.winProps.save() + "\n";
                writer.write(original);
                writer.close();
            }
            catch(Exception thisException)
            {
                this.errors.setText("Error: No file found.");
            }
        }
        else
        {
            this.errors.setText(errors);
        }
    }
}
