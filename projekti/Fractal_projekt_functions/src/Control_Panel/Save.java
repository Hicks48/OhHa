
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
     * 
     * @param RGBValueCheck
     * @param escapes
     * @param sin
     * @param cos
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
     * @param errors 
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
     * @param e 
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
