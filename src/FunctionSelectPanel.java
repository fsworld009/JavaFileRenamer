//FunctionSelectPanel.java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class FunctionSelectPanel extends JPanel 
{
	private Language lang = new Language();

    public static final int RENAME = 1000;
    public static final int REPLACE = 1001;
    public static final int REPLACEEXT = 1002;
    public static final int MOVE = 1003;
	
	private JPanel renamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton renameRadioButton = new JRadioButton("",true);
	private JLabel renameLabel1;	//重新命名
	private JLabel renameLabel2;	//開頭字
	private JLabel renameLabel3;	//起始編號
	private JLabel renameLabel4;	//編號位數
	private JTextField renameBeginWord;	//開頭字TextField
	private JTextField renameStartNumber;	//起始編號TextField
	private JTextField renameNumberDigit;	//編號位數TextField

	
    private JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton replaceRadioButton = new JRadioButton("",false);
	private JLabel replaceLabell;	//檔名取代
	private JLabel replaceLabel2;	//欲替換的字串
	private JLabel replaceLabel3;	//更改為
	private JTextField replaceOldSting;	//欲替換的字串TextField
	private JTextField replaceNewSting;	//更改為TextField
	
    private JPanel replaceExtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton replaceExtRadioButton = new JRadioButton("",false);
    private JLabel replaceExtLabel1;    //更改副檔名
    private JLabel replaceExtLabel2;    //副檔名
    private JTextField replaceExt;  //所需副檔名
	
    private JPanel movePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton moveRadioButton = new JRadioButton("",false);
	private JLabel moveLabel;	//移動檔案
	private JTextField movePath;	//檔案移動路徑TextField
	private JButton moveBrowser;	//瀏覽檔案按鈕
	
    private ButtonGroup radioGroup = new ButtonGroup();
    
    CoreFunction CoreFunction = new CoreFunction();
    
 
	
	public FunctionSelectPanel()
	{
		setLayout(new GridLayout(4,1));
        radioGroup.add(renameRadioButton);
        radioGroup.add(replaceRadioButton);
        radioGroup.add(replaceExtRadioButton);
        radioGroup.add(moveRadioButton);
        
		
		ButtonHandler handler = new ButtonHandler(); //ButtonHandler
		
		//Start Rename
        renamePanel.add(renameRadioButton);
		renamePanel.setOpaque(false);
        renameRadioButton.setOpaque(false);
		
		renameLabel1 = new JLabel(lang.renameLabel1);
        renamePanel.add(renameLabel1);
		
		renameLabel2 = new JLabel(lang.renameLabel2);
        renamePanel.add(renameLabel2);
		
		renameBeginWord = new JTextField(6);	//RenameBeginWord TextField
        renamePanel.add(renameBeginWord);
		
		renameLabel3 = new JLabel(lang.renameLabel3);
        renamePanel.add(renameLabel3);
		
		renameStartNumber = new JTextField(lang.renameStartNumber, 6 );	//RenameStartNumber TextField
        renamePanel.add( renameStartNumber);
		
		renameLabel4 = new JLabel(lang.renameLabel4);
        renamePanel.add( renameLabel4);
		
		renameNumberDigit = new JTextField(lang.renameNumberDigit, 3 );	//RenameNumberDigit TextField
        renamePanel.add( renameNumberDigit);
		
        
        add(renamePanel);
		//End Rename
		
		
		//Start Replace
        replacePanel.add(replaceRadioButton);
        replacePanel.setOpaque(false);
        replaceRadioButton.setOpaque(false);
		
		replaceLabell = new JLabel(lang.replaceLabell);
        replacePanel.add( replaceLabell);
		
		replaceLabel2 = new JLabel(lang.replaceLabel2);
        replacePanel.add( replaceLabel2);
		
		replaceOldSting = new JTextField(9);	//ReplaceOldSting TextField
        replacePanel.add( replaceOldSting );
		
		replaceLabel3 = new JLabel(lang.replaceLabel3);
        replacePanel.add( replaceLabel3 );
		
		replaceNewSting = new JTextField(9);
        replacePanel.add( replaceNewSting );

		

        add(replacePanel);
		//End Replace
		
        //Start ReplaceExtLabel1
        replaceExtPanel.add(replaceExtRadioButton);
        replaceExtPanel.setOpaque(false);
        replaceExtRadioButton.setOpaque(false);
        
        replaceExtLabel1 = new JLabel(lang.replaceExtLabel1);
        replaceExtPanel.add( replaceExtLabel1 );
        
        replaceExtLabel2 = new JLabel(lang.replaceExtLabel2);
        replaceExtPanel.add( replaceExtLabel2 );
        
        replaceExt = new JTextField (5);    //ReplaceExt TextField
        replaceExtPanel.add( replaceExt );
        

        add(replaceExtPanel);
        //End ReplaceExtLabel1
		
		//Start Move
        movePanel.add(moveRadioButton);
        movePanel.setOpaque(false);
        moveRadioButton.setOpaque(false);
		
		moveLabel = new JLabel(lang.moveLabel);
        movePanel.add( moveLabel);
		
		movePath = new JTextField(30);	//MovePath movePath
        movePanel.add( movePath );
		
		moveBrowser = new JButton(lang.moveBrowser);	//瀏覽檔案按鈕
        movePanel.add( moveBrowser);
		
		
        moveBrowser.addActionListener( handler );
        
        add(movePanel);
		//End Move
		
		/*
		 JFileChooser fileChooser = new JFileChooser();
		 fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
		 fileChooser.showOpenDialog(this);
		 */
		 

	}

	public boolean Check()	//檢查各項功能資料是否齊全
	{
        if( renameRadioButton.isSelected() )	//檢查重新命名資料是否齊全
        {
        	if( renameBeginWord.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.noheadword, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        	if( renameStartNumber.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.nostartnum, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        	if( renameNumberDigit.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.nocountnum, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	} 	
            if( getRenameStartNumber()==-1 )
            {
                JOptionPane.showMessageDialog( this, lang.startnumnotcorrect, lang.dataerror, JOptionPane.OK_OPTION );
                return false;
            }   
            if( getRenameNumberDigit()==-1 )
            {
                JOptionPane.showMessageDialog( this, lang.countnumnotcorrect, lang.dataerror, JOptionPane.OK_OPTION );
                return false;
            }   
        }
        else if( replaceRadioButton.isSelected() )	//檢查檔名取代資料是否齊全
        {
        	if( replaceOldSting.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.noreplacestr, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        	if( replaceNewSting.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.noreplaceto, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}        	
        }
        else if( replaceExtRadioButton.isSelected() )	//檢查更改副檔名資料是否齊全
        {
        	if( replaceExt.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.noext, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        }
        else if( moveRadioButton.isSelected() )	//檢查移動檔案資料是否齊全
        {
        	if( movePath.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.nopath, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        }		
		return true;
	}
	
	public int getFunctionId()	//取得目前所選擇的功能  若回傳0 則有錯誤
	{
		if( renameRadioButton.isSelected() )	//重新命名功能
            return RENAME;
		else if( replaceRadioButton.isSelected() )	//檔名取代功能
			return REPLACE;
		else if( replaceExtRadioButton.isSelected() )	//更改副檔名功能
			return REPLACEEXT;
		else if( moveRadioButton.isSelected() )	//移動檔案功能
			return MOVE;
		else
			return 0;
	}
	
    private boolean setFunctionId(int id)  //取得目前所選擇的功能  若回傳0 則有錯誤
    {
        switch(id){
            case RENAME:
                renameRadioButton.setSelected(true);
                return true;
            case REPLACE:
                replaceRadioButton.setSelected(true);
                return true;
            case REPLACEEXT:
                replaceExtRadioButton.setSelected(true);
                return true;
            case MOVE:
                moveRadioButton.setSelected(true);
                return true;
            default:
                return false;
        }
    }
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			if(event.getSource() == moveBrowser )
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );	//設定只能選擇資夾
                int returnVal = fileChooser.showOpenDialog( fileChooser );	//顯示開啟舊檔的介面
                if(returnVal == JFileChooser.APPROVE_OPTION)
				    movePath.setText( fileChooser.getSelectedFile().getAbsolutePath() );	//取得路徑	
			}

		}	
	}
	
	
	public String getRenameBeginWord()	//取得'開頭字'
	{
		return renameBeginWord.getText();
	}
	
	public int getRenameStartNumber()	//取得'起始編號'
	{
        try
        {
            int returnValue = Integer.parseInt(renameStartNumber.getText());
            return returnValue;
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
	}
	
	public int getRenameNumberDigit()	//取得'編號位數'
	{
        try
        {
            int returnValue = Integer.parseInt(renameNumberDigit.getText());
            return returnValue;
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
	}
	
	public String getReplaceOldSting()	//取得'欲替換的字串'
	{
		return replaceOldSting.getText();
	}
	
	public String getReplaceNewSting()	//取得'更改為'
	{
		return replaceNewSting.getText();
	}
	
	public String getReplaceExt()	//取得'所需副檔名'
	{
		return replaceExt.getText();
	}
	
	public String getMovePath()	//取得'檔案移動路徑'
	{
		return movePath.getText();
	}
}
