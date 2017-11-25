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
	private JLabel renameLabel1;	//���s�R�W
	private JLabel renameLabel2;	//�}�Y�r
	private JLabel renameLabel3;	//�_�l�s��
	private JLabel renameLabel4;	//�s�����
	private JTextField renameBeginWord;	//�}�Y�rTextField
	private JTextField renameStartNumber;	//�_�l�s��TextField
	private JTextField renameNumberDigit;	//�s�����TextField

	
    private JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton replaceRadioButton = new JRadioButton("",false);
	private JLabel replaceLabell;	//�ɦW���N
	private JLabel replaceLabel2;	//���������r��
	private JLabel replaceLabel3;	//��אּ
	private JTextField replaceOldSting;	//���������r��TextField
	private JTextField replaceNewSting;	//��אּTextField
	
    private JPanel replaceExtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton replaceExtRadioButton = new JRadioButton("",false);
    private JLabel replaceExtLabel1;    //�����ɦW
    private JLabel replaceExtLabel2;    //���ɦW
    private JTextField replaceExt;  //�һݰ��ɦW
	
    private JPanel movePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JRadioButton moveRadioButton = new JRadioButton("",false);
	private JLabel moveLabel;	//�����ɮ�
	private JTextField movePath;	//�ɮײ��ʸ��|TextField
	private JButton moveBrowser;	//�s���ɮ׫��s
	
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
		
		moveBrowser = new JButton(lang.moveBrowser);	//�s���ɮ׫��s
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

	public boolean Check()	//�ˬd�U���\���ƬO�_����
	{
        if( renameRadioButton.isSelected() )	//�ˬd���s�R�W��ƬO�_����
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
        else if( replaceRadioButton.isSelected() )	//�ˬd�ɦW���N��ƬO�_����
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
        else if( replaceExtRadioButton.isSelected() )	//�ˬd�����ɦW��ƬO�_����
        {
        	if( replaceExt.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.noext, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        }
        else if( moveRadioButton.isSelected() )	//�ˬd�����ɮ׸�ƬO�_����
        {
        	if( movePath.getText().equals("") )
        	{
        		JOptionPane.showMessageDialog( this, lang.nopath, lang.datanotwell, JOptionPane.OK_OPTION );
                return false;
        	}
        }		
		return true;
	}
	
	public int getFunctionId()	//���o�ثe�ҿ�ܪ��\��  �Y�^��0 �h�����~
	{
		if( renameRadioButton.isSelected() )	//���s�R�W�\��
            return RENAME;
		else if( replaceRadioButton.isSelected() )	//�ɦW���N�\��
			return REPLACE;
		else if( replaceExtRadioButton.isSelected() )	//�����ɦW�\��
			return REPLACEEXT;
		else if( moveRadioButton.isSelected() )	//�����ɮץ\��
			return MOVE;
		else
			return 0;
	}
	
    private boolean setFunctionId(int id)  //���o�ثe�ҿ�ܪ��\��  �Y�^��0 �h�����~
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
				fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );	//�]�w�u���ܸꧨ
                int returnVal = fileChooser.showOpenDialog( fileChooser );	//��ܶ}�����ɪ�����
                if(returnVal == JFileChooser.APPROVE_OPTION)
				    movePath.setText( fileChooser.getSelectedFile().getAbsolutePath() );	//���o���|	
			}

		}	
	}
	
	
	public String getRenameBeginWord()	//���o'�}�Y�r'
	{
		return renameBeginWord.getText();
	}
	
	public int getRenameStartNumber()	//���o'�_�l�s��'
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
	
	public int getRenameNumberDigit()	//���o'�s�����'
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
	
	public String getReplaceOldSting()	//���o'���������r��'
	{
		return replaceOldSting.getText();
	}
	
	public String getReplaceNewSting()	//���o'��אּ'
	{
		return replaceNewSting.getText();
	}
	
	public String getReplaceExt()	//���o'�һݰ��ɦW'
	{
		return replaceExt.getText();
	}
	
	public String getMovePath()	//���o'�ɮײ��ʸ��|'
	{
		return movePath.getText();
	}
}
