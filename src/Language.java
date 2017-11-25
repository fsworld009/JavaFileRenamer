import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Language
{

    
	//MainFrame

    public final String fileMenu;// = "�ɮ�";
    public final String fileShowLogItem;// = "�ϥά���";
    public final String fileExitItem;// = "�����{��";
    
    public final String langMenu;
    public final String langItem1;
    public final String langItem2;
    public final String langItem3;
    public final String langItem4;
   	
    public final String aboutMenu;// = "����";
    public final String aboutShowAboutItem;// = "���󥻵{��";
   	
    public final String addButton;// = " �s�W >>> ";
    public final String removeButton;// = "<<<  ���� ";
    public final String moveUpButton;// = "  �V�W��  ";
    public final String moveDownButton;// = "  �V�U��  ";
    public final String clearButton;// = "   �M��   ";
    public final String startButton;// = "   �}�l   ";
    public final String error;// = "���~";
    public final String logout1;// = "�L�k�g�J������ ���ˬdlog.txt�ɮ��v���]�w";
    public final String logout2;// = "�䤣��B�L�k�إ�log.txt ���ˬd�D�{���ؿ���Ƨ��v���]�w";
    public final String nofile;// = "�S������ݳB�z�ɮ�";
    public final String uselog;// = "�ϥά���";
    public final String aboutpro;// = "���󥻵{��";
	
	//OutputPanel
    public final String optitletext;// = "���G����";
	
	//CoreFunction
    public final String filerenamesuccess;// = "%s  :    �ɮ� %s ���\��W�� %s\n";
    public final String filerenamefail;// = "%s  :    �ɮ� %s ��W����\n";
    public final String dirrenamesuccess;// = "%s  :    ��Ƨ� %s ���\��W�� %s\n";
    public final String dirrenamefail;// = "%s  :    ��Ƨ� %s ��W����\n";
    public final String notexist;// = "%s  :    �� %s �ɮשθ�Ƨ��ä��s�b\n";
    public final String filereplacesuccess;// = "%s  :    �ɮ� %s ���\��W�� %s\n";
    public final String filereplacefail;// = "%s  :    �ɮ� %s ��W����\n";
    public final String dirreplacesuccess;// = "%s  :    ��Ƨ� %s ���\��W�� %s\n";
    public final String dirreplacefail;// = "%s  :    ��Ƨ� %s ��W����\n";
    public final String replaceextsuccess;// = "%s  :    �ɮ� %s �ק���ɦW���\\n";
    public final String replaceextfail;// = "%s  :    �ɮ� %s �ק���ɦW����\n";
    public final String notfile;// = "%s  :    %s �ä��O�ɮ�\n";
    public final String notdir;// = "%s  :    �s���|�ëD���@�Ӹ�Ƨ�\n";
    public final String movefilesuccess;// = "%s  :    �ɮ� %s ���ʦ��\\n";
    public final String movefilefail;// = "%s  :    �ɮ� %s ���ʥ���\n";
    public final String movedirsuccess;// = "%s  :    ��Ƨ� %s ���ʦ��\\n";
    public final String movedirfail;// = "%s  :    ��Ƨ� %s ���ʥ���\n";
	
	//AboutDialog
    public final String okButton;// = "�T�w";
	
	//FileChooserPanel	
    public final String fcptitleText;// = "����ɮ�";
	
	//FileListPanel      
    public final String flptitleText;// = "�ɮײM��";
	
	//FunctionSelectPanel
    public final String renameLabel1;// = "���s�R�W";
    public final String renameLabel2;// = "�}�Y�r:";
    public final String renameLabel3;// = "�_�l�s��:";
    public final String renameStartNumber;// = "000";
    public final String renameLabel4;// = "�s�����:";
    public final String renameNumberDigit;// = "3";
    public final String replaceLabell;// = "�ɦW���N";
    public final String replaceLabel2;// = "���������r��:";
    public final String replaceLabel3;// = "��אּ:";
    public final String replaceExtLabel1;// = "�����ɦW";
    public final String replaceExtLabel2;// = "���ɦW:";
    public final String moveLabel;// = "�����ɮ�";
    public final String moveBrowser;// = "�s��";
    public final String datanotwell;// = "��Ƥ�����";
    public final String dataerror;// = "��ƿ��~";
    public final String noheadword;// = "�}�Y�r��쥼��";
    public final String nostartnum;// = "�_�l�s����쥼��";
    public final String nocountnum;// = "�s�������쥼��";
    public final String startnumnotcorrect;// = "�_�l�s��������D�Ʀr�ή榡�����T";
    public final String countnumnotcorrect;// = "�s��������D�Ʀr�ή榡�����T";
    public final String noreplacestr;// = "�������r����쥼��";
    public final String noreplaceto;// = "��אּ�@��쥼��";
    public final String noext;// = "���ɦW��쥼��";
	public final String nopath;// = "�ɮ׸��|��쥼��";
	
	//class Language
    public final String langReload;
		
		
    public Language(){
        //Load language.conf
        Scanner langFileName=null;
        try{
            langFileName = new Scanner(new File("./language/language.conf"));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog( null, "File not found: ./language/language.conf", "Error", JOptionPane.OK_OPTION );
            System.exit(0);
        }
        
        //Load langlist.conf
        Scanner langList=null;
        try{
            langList = new Scanner(new File("./language/langlist.conf"),"UTF-8");
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog( null, "File not found: ./language/langlist.conf", "Error", JOptionPane.OK_OPTION );
            System.exit(0);
        }
        
        //Load language file
        Scanner langFile=null;
        String langFileString = String.format("./language/%s.lang",langFileName.nextLine());
        try{
            
            langFile = new Scanner(new File(langFileString),"UTF-8");
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog( null, String.format("File not found: ./language/language file %s",langFileString), "Error", JOptionPane.OK_OPTION );
            System.exit(0);
        }
        
        
        //MainFrame
    
        fileMenu        = langFile.nextLine();
        fileShowLogItem = langFile.nextLine();
        fileExitItem    = langFile.nextLine();
        
        langMenu        = langFile.nextLine();
        

        langItem1       = langList.nextLine();
        langItem2       = langList.nextLine();
        langItem3       = langList.nextLine();
        langItem4       = langList.nextLine();
        
        aboutMenu          = langFile.nextLine();
        aboutShowAboutItem = langFile.nextLine();
        
        addButton      = langFile.nextLine();
        removeButton   = langFile.nextLine();
        moveUpButton   = langFile.nextLine();
        moveDownButton = langFile.nextLine();
        clearButton    = langFile.nextLine();
        startButton    = langFile.nextLine();
        error          = langFile.nextLine();
        logout1        = langFile.nextLine();
        logout2        = langFile.nextLine();
        nofile         = langFile.nextLine();
        uselog         = langFile.nextLine();
        aboutpro       = langFile.nextLine();
        
        //OutputPanel
        optitletext = langFile.nextLine();
        
        //CoreFunction
        filerenamesuccess  = String.format("%s\n",langFile.nextLine());
        filerenamefail     = String.format("%s\n",langFile.nextLine());
        dirrenamesuccess   = String.format("%s\n",langFile.nextLine());
        dirrenamefail      = String.format("%s\n",langFile.nextLine());
        notexist           = String.format("%s\n",langFile.nextLine());
        filereplacesuccess = String.format("%s\n",langFile.nextLine());
        filereplacefail    = String.format("%s\n",langFile.nextLine());
        dirreplacesuccess  = String.format("%s\n",langFile.nextLine());
        dirreplacefail     = String.format("%s\n",langFile.nextLine());
        replaceextsuccess  = String.format("%s\n",langFile.nextLine());
        replaceextfail     = String.format("%s\n",langFile.nextLine());
        notfile            = String.format("%s\n",langFile.nextLine());
        notdir             = String.format("%s\n",langFile.nextLine());
        movefilesuccess    = String.format("%s\n",langFile.nextLine());
        movefilefail       = String.format("%s\n",langFile.nextLine());
        movedirsuccess     = String.format("%s\n",langFile.nextLine());
        movedirfail        = String.format("%s\n",langFile.nextLine());
        
        //AboutDialog
        okButton = langFile.nextLine();
        
        //FileChooserPanel  
        fcptitleText = langFile.nextLine();
        
        //FileListPanel      
        flptitleText = langFile.nextLine();
        
        //FunctionSelectPanel
        renameLabel1       = langFile.nextLine();
        renameLabel2       = langFile.nextLine();
        renameLabel3       = langFile.nextLine();
        renameStartNumber  = langFile.nextLine();
        renameLabel4       = langFile.nextLine();
        renameNumberDigit  = langFile.nextLine();
        replaceLabell      = langFile.nextLine();
        replaceLabel2      = langFile.nextLine();
        replaceLabel3      = langFile.nextLine();
        replaceExtLabel1   = langFile.nextLine();
        replaceExtLabel2   = langFile.nextLine();
        moveLabel          = langFile.nextLine();
        moveBrowser        = langFile.nextLine();
        datanotwell        = langFile.nextLine();
        dataerror          = langFile.nextLine();
        noheadword         = langFile.nextLine();
        nostartnum         = langFile.nextLine();
        nocountnum         = langFile.nextLine();
        startnumnotcorrect = langFile.nextLine();
        countnumnotcorrect = langFile.nextLine();
        noreplacestr       = langFile.nextLine();
        noreplaceto        = langFile.nextLine();
        noext              = langFile.nextLine();
        nopath             = langFile.nextLine();
        
        //Message for class Language

       langReload = langFile.nextLine();;
        
        langFile.close();
        langList.close();
        langFileName.close();
    }
    
    public void changeLanguage(String newLanguageFileName){
        Formatter langFileName=null;
        try{
            langFileName = new Formatter(new File("./language/language.conf"));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog( null, "Can not load language.conf", "Error", JOptionPane.OK_OPTION );
        }
        
        langFileName.format("%s",newLanguageFileName);
        JOptionPane.showMessageDialog( null, langReload, "Message", JOptionPane.OK_OPTION );
        langFileName.close();
        
    }
}