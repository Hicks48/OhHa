
package Control_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Henri Korpela
 */
public class Delete implements ActionListener{
    private JTextArea errors;
    private JTextField name;
    
    public Delete(JTextArea errors,JTextField name)
    {
        this.name = name;
        this.errors = errors;
    }
    
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
