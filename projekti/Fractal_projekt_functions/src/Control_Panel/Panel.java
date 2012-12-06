
package Control_Panel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
/**
 * Draws Panel on screen.
 * @author Henri Korpela
 */
public class Panel implements Runnable{
    private JFrame panel;
    /**
     * Runs panel and sets it visible.
     */
    @Override
    public void run()
    {
        this.panel = new JFrame("Control Panel");
        try 
        {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        this.panel.setPreferredSize(new Dimension(1400,350));
        this.panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createComponents(this.panel.getContentPane());
        this.panel.pack();
        this.panel.setVisible(true);
    }
    /**
     * Fills frames container with different components.
     * @param container Container that is filled with panels components. 
     */
    private void createComponents(Container container)
    {
        GridLayout layout = new GridLayout(5,10);
        container.setLayout(layout);
        
        ButtonGroup coloringAlgorithms = new ButtonGroup();
        JCheckBox escapes = new JCheckBox("Escapes");
        JCheckBox sin = new JCheckBox("Sin");
        JCheckBox cos = new JCheckBox("Cos");
        coloringAlgorithms.add(escapes);
        coloringAlgorithms.add(sin);
        coloringAlgorithms.add(cos);
        
        JButton list = new JButton("List");
        JButton draw = new JButton("Draw");
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        JButton delete = new JButton("Delete");
        JCheckBox RGBValueCheck = new JCheckBox("Value check");
        
        JTextField width = new JTextField();
        JTextField heigth = new JTextField();
        JTextField zoom = new JTextField();
        JTextField center = new JTextField();
        
        JTextField function = new JTextField();
        JTextField KValue = new JTextField();
        JTextField name = new JTextField();
        JTextField accurancy = new JTextField();
        
        JTextField comR = new JTextField();
        JTextField comG = new JTextField();
        JTextField comB = new JTextField();
        
        JTextField bgR = new JTextField();
        JTextField bgG = new JTextField();
        JTextField bgB = new JTextField();
        
        JTextField seR = new JTextField();
        JTextField seB = new JTextField();
        JTextField seG = new JTextField();
        
        JTextArea errorMessage = new JTextArea();
        
        List listAction = new List(errorMessage);
        Draw drawAction = new Draw(RGBValueCheck,escapes,sin,cos,width,heigth,zoom,
            center,function,KValue,name,
            accurancy,comR,comG,comB,bgR,
            bgG,bgB,seR,seB,seG,errorMessage);
        Save saveAction = new Save(RGBValueCheck,escapes,sin,cos,width,heigth,zoom,
            center,function,KValue,name,
            accurancy,comR,comG,comB,bgR,
            bgG,bgB,seR,seB,seG,errorMessage);
        Load loadAction = new Load(name,RGBValueCheck,escapes,sin,cos,width,heigth,zoom,
            center,function,KValue,
            accurancy,comR,comG,comB,bgR,
            bgG,bgB,seR,seB,seG,errorMessage);
        Delete deleteAction = new Delete(errorMessage,name);
        
        list.addActionListener(listAction);
        draw.addActionListener(drawAction);
        save.addActionListener(saveAction);
        load.addActionListener(loadAction);
        delete.addActionListener(deleteAction);
        
        container.add(new JLabel(" Set color:"));
        container.add(new JLabel(""));
        container.add(new JLabel("Secondary color:"));
        container.add(new JLabel(""));
        container.add(new JLabel("Background color:"));
        container.add(new JLabel(""));
        container.add(new JLabel("Coloring:"));
        container.add(new JLabel("Window:"));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(list);
        
        container.add(new JLabel("          Red: "));
        container.add(comR);
        container.add(new JLabel("          Red: "));
        container.add(seR);
        container.add(new JLabel("          Red: "));
        container.add(bgR);
        container.add(escapes);
        container.add(new JLabel("  Zoom: "));
        container.add(zoom);
        container.add(new JLabel("  name: "));
        container.add(name);
        container.add(load);
        
        container.add(new JLabel("          Green: "));
        container.add(comG);
        container.add(new JLabel("          Green: "));
        container.add(seG);
        container.add(new JLabel("          Green: "));
        container.add(bgG);
        container.add(cos);
        container.add(new JLabel("  Width: "));
        container.add(width);
        container.add(new JLabel("  K value: "));
        container.add(KValue);
        container.add(save);
        
        container.add(new JLabel("          Blue: "));
        container.add(comB);
        container.add(new JLabel("          Blue: "));
        container.add(seB);
        container.add(new JLabel("          Blue: "));
        container.add(bgB);
        container.add(sin);
        container.add(new JLabel("  Heigth: "));
        container.add(heigth);
        container.add(new JLabel("  Function: "));
        container.add(function);
        container.add(draw);
        
        container.add(new JLabel("Errors"));
        container.add(errorMessage);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(RGBValueCheck);
        container.add(new JLabel("  center: "));
        container.add(center);
        container.add(new JLabel("  accuracy: "));
        container.add(accurancy);
        container.add(delete);
    }
}
