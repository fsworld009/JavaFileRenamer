//FileChooserPanel.java
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
//import java.io.File;
import java.awt.BorderLayout;
import javax.swing.JPanel;


public class OutputPanel extends JPanel
{
	private Language lang = new Language();
	
    JTextArea outputText = new JTextArea("");
    JLabel titleText = new JLabel(lang.optitletext);
    //private JButton addButton = new JButton("ADD>>>");
    //private ButtonHandeler addHandler = new ButtonHandeler();
    public OutputPanel()
    {
        super();
        setLayout(new BorderLayout());
        add(new JScrollPane(outputText),BorderLayout.CENTER);   //File Panel
        add(titleText,BorderLayout.NORTH);   //File Panel
        
        outputText.setEditable(false);
    }
    
    public void setOutputString(String output)
    {
        String oldOutput = outputText.getText();
        outputText.setText(String.format("%s%s",oldOutput,output));
    }
}