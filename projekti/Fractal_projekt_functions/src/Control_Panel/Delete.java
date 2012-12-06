
package Control_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Handles deleting sets from SavedSets.txt file.
 * @author Henri Korpela
 */
public class Delete implements ActionListener{
    private JTextArea errors;
    private JTextField name;
    /**
     * Creates new delete button listener.
     * @param errors field that errors are displayed.
     * @param name field that contains name of the set.
     */
    public Delete(JTextArea errors,JTextField name)
    {
        this.name = name;
        this.errors = errors;
    }
    /**
     * Starts when delete button is clicked.
     * Deletes set of the given name from the SavedSets.txt file.
     * @param e Event occurs when delete button is clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.errors.setText("");
        try
        {
            Scanner reader = new Scanner(new File("SavedSets.txt"));
            String lines = this.readOriginalNotoBeDleted(this.name.getText(),reader);
            if(lines.equals("Nothing was deleted."))
            {
                this.errors.setText(lines);
                return;
            }
            FileWriter writer = new FileWriter("SavedSets.txt");
            writer.write(lines);
            writer.close();
        }
        catch(Exception thisException)
        {
            this.errors.setText("No file found.");
        }
    }
    /**
     * Reads everything except set that's being deleted
     * into a String.
     * @param name name of the set that's being deleted.
     * @param reader Reader that is used to read name of the set.
     * @return String containing everything in SavedSets.txt file except
     * set to be deleted.
     */
    private String readOriginalNotoBeDleted(String name,Scanner reader)
    {
        String lines = "";
        boolean deleted = false;
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            if(!name.equals(this.readName(line)))
            {
                lines = lines + line + "\n";
            }
            else
            {
                deleted = true;
            }
        }
        if(deleted)
        {
            return lines;
        }
        else
        {
            return "Nothing was deleted.";
        }
    }
    /**
     * Reads name of the set that is saved at the given line.
     * @param line line that contains the set thats name is being read.
     * @return String that contains name of the set.
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
