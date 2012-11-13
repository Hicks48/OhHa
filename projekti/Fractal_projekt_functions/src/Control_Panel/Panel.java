/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Panel;

/**
 *
 * @author henrikorpela
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
public class Panel implements Runnable{
    private JFrame panel;
    
    public Panel()
    {
        
    }
    
    @Override
    public void run()
    {
        this.panel = new JFrame("Control Panel");
        this.panel.setPreferredSize(new Dimension(600,300));
        this.panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createComponents(this.panel.getContentPane());
        this.panel.pack();
        this.panel.setVisible(true);
    }
    
    private void createComponents(Container container)
    {
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        
        JLabel coloringAlgorithmLabel = new JLabel("Coloring algorithms:");
        
        ButtonGroup coloringAlgorithms = new ButtonGroup();
        JCheckBox escapes = new JCheckBox("Escapes");
        JCheckBox sin = new JCheckBox("Sin");
        JCheckBox cos = new JCheckBox("Cos");
        coloringAlgorithms.add(escapes);
        coloringAlgorithms.add(sin);
        coloringAlgorithms.add(cos);
        
        JButton draw = new JButton("Draw");
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        
        JTextField function = new JTextField();
        JTextField name = new JTextField();
        
        JLabel complementSetColor = new JLabel("Complement set color RGB values:");
        JLabel backroundColor = new JLabel("Backround color");
        JLabel secondaryColor = new JLabel("Secondary color");
        
        JTextField comR = new JTextField();
        JTextField comG = new JTextField();
        JTextField comB = new JTextField();
        
        JTextField bgR = new JTextField();
        JTextField bgG = new JTextField();
        JTextField bgB = new JTextField();
        
        JTextField seR = new JTextField();
        JTextField seB = new JTextField();
        JTextField seG = new JTextField();
    }
}
