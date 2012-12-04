
package Control_Panel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.File;
import javax.swing.JTextArea;

/**
 * Displays screen that shows names of all
 * sets that have been saved.
 * Activates when List-button is clicked.
 * @author Henri Korpela
 */
public class List implements Runnable,ActionListener{
    private JFrame frame;
    private File file;
    private JTextArea textArea;
    private JTextArea errors;
    
    public List(JTextArea errors)
    {
        this.file = new File("SavedSets.txt");
        this.errors = errors;
        this.textArea = new JTextArea();
    }
    /**
     * Runs window that displays name of
     * all saved sets.
     */
    @Override
    public void run() {
        this.frame = new JFrame("Saved Sets");
        this.frame.setPreferredSize(new Dimension(300,800));
        this.frame.getContentPane().add(this.textArea);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    /**
     * Constructs String containing
     * all names of saved sets.
     * @return String containing names of all saved sets.
     */
    private String constructList()
    {
        try
        {
            Scanner reader = new Scanner(this.file);
            String names = "";
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                names = names + this.name(line) + "\n";
            }
            return names;
        }
        catch(Exception thisException)
        {
            return "No file found.";
        }
    }
    /**
     * Starts when List button is clicked.
     * @param e Event that occurs when list button is clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.errors.setText("");
        String names = this.constructList();
        this.textArea.setText(names);
        this.run();
    }
    /**
     * Reads name of the set that
     * is saved in the given line.
     * @param line Line which contains set
     * thats name is read.
     * @return Name of the set.
     */
    private String name(String line)
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
