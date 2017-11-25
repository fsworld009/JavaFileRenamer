//MainFrame.java
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.UnsupportedEncodingException;
import java.awt.Insets;
import javax.swing.*; 


//import java.awt.Color;
import java.io.File;

public class MainFrame extends JFrame
{
    final static public int FRAMEWIDTH = 900;
    final static public int FRAMEHEIGHT = 675;
    
	private Language lang = new Language(); 
   
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu fileMenu = new JMenu(lang.fileMenu);
    private JMenuItem fileShowLogItem = new JMenuItem(lang.fileShowLogItem);
    private JMenuItem fileExitItem = new JMenuItem(lang.fileExitItem);
    
    private JMenu langMenu = new JMenu(lang.langMenu);
    private JMenuItem langItem1 = new JMenuItem(lang.langItem1);
    private JMenuItem langItem2 = new JMenuItem(lang.langItem2);
    private JMenuItem langItem3 = new JMenuItem(lang.langItem3);
    private JMenuItem langItem4 = new JMenuItem(lang.langItem4);
    
    private JMenu aboutMenu = new JMenu(lang.aboutMenu);
    private JMenuItem aboutShowAboutItem = new JMenuItem(lang.aboutShowAboutItem);
    
    private FileChooserPanel fchooser = new FileChooserPanel();
    private FileListPanel flist = new FileListPanel();
    private FunctionSelectPanel functionSelect = new FunctionSelectPanel();
    private OutputPanel output = new OutputPanel();
    
    private JPanel fListButtonPanel = new JPanel(new GridLayout(5,1,5,5));
    private JButton addButton      = new JButton(lang.addButton);
    private JButton removeButton   = new JButton(lang.removeButton);
    private JButton moveUpButton   = new JButton(lang.moveUpButton);
    private JButton moveDownButton = new JButton(lang.moveDownButton);
    private JButton clearButton    = new JButton(lang.clearButton);
    private JButton startButton    = new JButton(lang.startButton);
    
    
    private ButtonHandeler listFunctionHandler = new ButtonHandeler();
    private RunHandeler runHandler = new RunHandeler();
    private MenuHandeler menuHandler = new MenuHandeler();
    
    private CoreFunction core = new CoreFunction();
    
    
    public MainFrame(){
        super("JFM - Java File Manager");
        setBak();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //MenuBar
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(langMenu);
        menuBar.add(aboutMenu);
        
        //"file" menu
        
        fileShowLogItem.addActionListener(menuHandler);
        fileMenu.add(fileShowLogItem);

        fileMenu.addSeparator();
        
        fileExitItem.addActionListener(menuHandler);
        fileMenu.add(fileExitItem);
        
        //"language" menu
        langItem1.addActionListener(menuHandler);
        langMenu.add(langItem1);
        langItem2.addActionListener(menuHandler);
        langMenu.add(langItem2);
        langItem3.addActionListener(menuHandler);
        langMenu.add(langItem3);
        langItem4.addActionListener(menuHandler);
        langMenu.add(langItem4);
        
        //"about" menu
        aboutShowAboutItem.addActionListener(menuHandler);
        aboutMenu.add(aboutShowAboutItem);
               
        //FileChooser
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=0.5;
        c.gridwidth=1;
        c.gridheight=1;
        fchooser.setOpaque(false);
        add(fchooser,c);
        fchooser.setPreferredSize(new Dimension( 365,260 ));
        
        
        
        //add button
        addButton.addActionListener(listFunctionHandler);
        fListButtonPanel.add(addButton);
        //mainPanel.add(addButton,380,50,120,30);
        
        //remove button   
        removeButton.addActionListener(listFunctionHandler);
        fListButtonPanel.add(removeButton);
        
        //moveUp button   
        moveUpButton.addActionListener(listFunctionHandler);
        fListButtonPanel.add(moveUpButton);
        
        //moveDown button   
        moveDownButton.addActionListener(listFunctionHandler);
        fListButtonPanel.add(moveDownButton);
        
        //clear button   
        clearButton.addActionListener(listFunctionHandler);
        fListButtonPanel.add(clearButton);
        
        
        //Button's Panel
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth=1;
        c.gridheight=1;
        c.anchor = GridBagConstraints.PAGE_END;
        fListButtonPanel.setOpaque(false);
        add(fListButtonPanel,c);
        fListButtonPanel.setPreferredSize(new Dimension( 120,240 ));
        
        //ScheduleList

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth=2;
        c.gridheight=1;
        c.anchor = GridBagConstraints.CENTER;
        flist.setOpaque(false);
        add(flist,c);
        flist.setPreferredSize(new Dimension( 365,260 ));
      
      
        //function select
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=4;
        c.gridheight=1;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        functionSelect.setOpaque(false);
        add(functionSelect,c);
        functionSelect.setPreferredSize(new Dimension( 700,150 ));
        
        //start Button
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0,0,0,10);
        startButton.setIcon(new javax.swing.ImageIcon("./pic/start_icon.jpg"));
		startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        add(startButton,c);
        startButton.setPreferredSize(new Dimension(150,80));
        startButton.addActionListener(runHandler);
        
        //output Panel
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth=4;
        c.gridheight=1;
        output.setOpaque(false);
        add(output,c);
        output.setPreferredSize(new Dimension( 880,200 ));
        
    }
    
    private void writeLog(String newRecord){
        Scanner logInput=null;
        String oldLogContents = "";
        
        try{
            logInput = new Scanner(new File("log.txt"),"UTF-8");    //exception may happen
            while(logInput.hasNext()){
                oldLogContents = oldLogContents + logInput.nextLine() + "\n";
            }
            logInput.close();
        }catch(FileNotFoundException fe){
            //input doesn't exist, do not load old text
            //Formmater will create a new file at this case
        }
        
        Formatter logOutput = null;
        try{
            logOutput = new Formatter("log.txt","UTF-8");    //exception may happen
            logOutput.format("%s%s",oldLogContents,newRecord);
            logOutput.close();
        }catch(SecurityException se){
            //do not have permission to write this file
            JOptionPane.showMessageDialog( this, lang.logout1, lang.error, JOptionPane.OK_OPTION );
            return;
        }catch(FileNotFoundException fe){
            //file not found and cannot create
            JOptionPane.showMessageDialog( this, lang.logout2, lang.error, JOptionPane.OK_OPTION );
            return;
        }catch(UnsupportedEncodingException ue){
            //charset error,never occurs
            
        }
        
    }
    
    private class ButtonHandeler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
            if(event.getSource() == addButton){
                File[] newAddedFiles;
                newAddedFiles = fchooser.getSelectedFiles();
                flist.addFile(newAddedFiles);
                
            }else if(event.getSource() == removeButton){
                flist.removeFile();
                
            }else if(event.getSource() == moveDownButton){
                flist.moveDown();
                
            }else if(event.getSource() == moveUpButton){
                flist.moveUp();
                
            }else if(event.getSource() == clearButton){
                flist.clear();
            }
        }
    }
    
    private class RunHandeler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        { 
            File[] processFiles = flist.getListData();
            if(processFiles==null){
                JOptionPane.showMessageDialog( MainFrame.this, lang.nofile, lang.error, JOptionPane.OK_OPTION );
            }else if(functionSelect.Check()){
                switch(functionSelect.getFunctionId()){
                    case FunctionSelectPanel.RENAME:
                        core.rename(processFiles,functionSelect.getRenameBeginWord(),functionSelect.getRenameStartNumber(),functionSelect.getRenameNumberDigit());
                        break;
                    case FunctionSelectPanel.REPLACE:
                        core.replace(processFiles,functionSelect.getReplaceOldSting(),functionSelect.getReplaceNewSting());
                        break;
                    case FunctionSelectPanel.REPLACEEXT:
                        core.replaceExt(processFiles,functionSelect.getReplaceExt());
                        break;
                    case FunctionSelectPanel.MOVE:
                        core.move(processFiles,functionSelect.getMovePath());
                        break;
                    default:
                        break;    
                }
                //get output String
                String newRecord = core.getOutputString();
                output.setOutputString(newRecord);
                //refresh the file chooser
                fchooser.refresh();
                //schedule list clear
                flist.clear();
                //re-add files that rename fails
                File[] failFiles = core.getFailFiles();
                if(failFiles != null){
                    flist.addFile(failFiles);
                }
                //update log
                MainFrame.this.writeLog(newRecord);
            }
        }
            
    }
    
    private class MenuHandeler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        { 
            if(event.getSource() == fileExitItem){
                System.exit(0);
            }else if(event.getSource() == fileShowLogItem){
                LogDialog logDialog = new LogDialog(MainFrame.this, lang.uselog, true);
                logDialog.setVisible(true);   
            }else if(event.getSource() == langItem1){
                lang.changeLanguage("English");
            }else if(event.getSource() == langItem2){
                lang.changeLanguage("TranditionalChinese");
            }else if(event.getSource() == langItem3){
                lang.changeLanguage("SimplifiedChinese");
            }else if(event.getSource() == langItem4){
                lang.changeLanguage("Japanese");
            }else if(event.getSource() == aboutShowAboutItem){
                AboutDialog aboutDialog = new AboutDialog(MainFrame.this, lang.aboutpro, true);
                aboutDialog.setVisible(true);
            }
        }
            
    }
	public void setBak()
	{ 
		((JPanel)this.getContentPane()).setOpaque(false); 
		ImageIcon img = new ImageIcon("./pic/bg.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
	} 
}
