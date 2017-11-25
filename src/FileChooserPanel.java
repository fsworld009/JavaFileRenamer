//FileChooserPanel.java
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;

public class FileChooserPanel extends JPanel
{
	private Language lang = new Language();
	
    private JLabel titleText = new JLabel(lang.fcptitleText);
    private JFileChooser chooser = new JFileChooser();              //The File Chooser
    private JPanel chooserPanel = new JPanel(new BorderLayout());   //This Panel  put some component of the chooser
    public FileChooserPanel() {
        super();
        setLayout(new BorderLayout());
        //chooser's attributes
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        //Get chooser's component and add the components we want.
        Component old[] = chooser.getComponents();
        chooserPanel.add(old[0],BorderLayout.NORTH);           //tree
        chooserPanel.add(old[2],BorderLayout.CENTER);   //File Panel

        add(titleText,BorderLayout.NORTH);   //The Title Text
        add(chooserPanel,BorderLayout.CENTER);   //The Chooser's components
        
        chooserPanel.setOpaque(false);

    }
    
    public File[] getSelectedFiles(){
        return chooser.getSelectedFiles();
    }

    public void refresh(){
        chooser.rescanCurrentDirectory();
    }
}