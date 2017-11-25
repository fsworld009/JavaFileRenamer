import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AboutDialog extends JDialog
{
	private Language lang = new Language();
	
    JButton okButton = new JButton(lang.okButton);
    JTextArea aboutText = new JTextArea();
    public AboutDialog(Frame owner, String title, boolean modal)
    {
        super(owner,title,modal);
        setLayout(new BorderLayout());
        
        //set size
        setSize(new Dimension(400,300));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        aboutText.setEditable(false);
        String info = "";
        
        info += "※本程式為簡易檔案命名、移動管理系統\n\n";
        info += "※本程式僅供教學及個人用途，請勿以此程式進行任何商業行為\n\n";
       
        aboutText.setText(info);
        
        add(new JScrollPane(aboutText),BorderLayout.CENTER);
        add(okButton,BorderLayout.SOUTH);   
        okButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event){
                    AboutDialog.this.dispose();
                }
            }
        
        );
    }
    
}