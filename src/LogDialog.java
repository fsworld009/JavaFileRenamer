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


public class LogDialog extends JDialog{
    JButton okButton = new JButton("Ãö³¬");
    JTextArea logText = new JTextArea();
    public LogDialog(Frame owner, String title, boolean modal){
        super(owner,title,modal);
        setLayout(new BorderLayout());
        loadLogFile();
        
        //set size
        setSize(new Dimension(600,500));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        logText.setEditable(false);
        
        add(new JScrollPane(logText),BorderLayout.CENTER);
        add(okButton,BorderLayout.SOUTH);   
        okButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event){
                    LogDialog.this.dispose();
                }
            }
        
        );
    }
    
    private void loadLogFile(){
        Scanner logInput=null;
        String logContents = "";
        try{
            logInput = new Scanner(new File("log.txt"),"UTF-8");    //exception may happen
            while(logInput.hasNext()){
                logContents = logContents + logInput.nextLine() + "\n";
            }
            logInput.close();
        }catch(FileNotFoundException fe){
            //input doesn't exist, do not load old text
            //logContents = "" at this case
        }
        
        logText.setText(logContents);
    }
    
}