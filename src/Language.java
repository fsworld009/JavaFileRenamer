import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Language
{

    
	//MainFrame

    public final String fileMenu;// = "檔案";
    public final String fileShowLogItem;// = "使用紀錄";
    public final String fileExitItem;// = "結束程式";
    
    public final String langMenu;
    public final String langItem1;
    public final String langItem2;
    public final String langItem3;
    public final String langItem4;
   	
    public final String aboutMenu;// = "關於";
    public final String aboutShowAboutItem;// = "關於本程式";
   	
    public final String addButton;// = " 新增 >>> ";
    public final String removeButton;// = "<<<  移除 ";
    public final String moveUpButton;// = "  向上移  ";
    public final String moveDownButton;// = "  向下移  ";
    public final String clearButton;// = "   清除   ";
    public final String startButton;// = "   開始   ";
    public final String error;// = "錯誤";
    public final String logout1;// = "無法寫入紀錄檔 請檢查log.txt檔案權限設定";
    public final String logout2;// = "找不到且無法建立log.txt 請檢查主程式目錄資料夾權限設定";
    public final String nofile;// = "沒有任何待處理檔案";
    public final String uselog;// = "使用紀錄";
    public final String aboutpro;// = "關於本程式";
	
	//OutputPanel
    public final String optitletext;// = "結果視窗";
	
	//CoreFunction
    public final String filerenamesuccess;// = "%s  :    檔案 %s 成功更名為 %s\n";
    public final String filerenamefail;// = "%s  :    檔案 %s 更名失敗\n";
    public final String dirrenamesuccess;// = "%s  :    資料夾 %s 成功更名為 %s\n";
    public final String dirrenamefail;// = "%s  :    資料夾 %s 更名失敗\n";
    public final String notexist;// = "%s  :    該 %s 檔案或資料夾並不存在\n";
    public final String filereplacesuccess;// = "%s  :    檔案 %s 成功更名為 %s\n";
    public final String filereplacefail;// = "%s  :    檔案 %s 更名失敗\n";
    public final String dirreplacesuccess;// = "%s  :    資料夾 %s 成功更名為 %s\n";
    public final String dirreplacefail;// = "%s  :    資料夾 %s 更名失敗\n";
    public final String replaceextsuccess;// = "%s  :    檔案 %s 修改附檔名成功\n";
    public final String replaceextfail;// = "%s  :    檔案 %s 修改附檔名失敗\n";
    public final String notfile;// = "%s  :    %s 並不是檔案\n";
    public final String notdir;// = "%s  :    新路徑並非為一個資料夾\n";
    public final String movefilesuccess;// = "%s  :    檔案 %s 移動成功\n";
    public final String movefilefail;// = "%s  :    檔案 %s 移動失敗\n";
    public final String movedirsuccess;// = "%s  :    資料夾 %s 移動成功\n";
    public final String movedirfail;// = "%s  :    資料夾 %s 移動失敗\n";
	
	//AboutDialog
    public final String okButton;// = "確定";
	
	//FileChooserPanel	
    public final String fcptitleText;// = "選擇檔案";
	
	//FileListPanel      
    public final String flptitleText;// = "檔案清單";
	
	//FunctionSelectPanel
    public final String renameLabel1;// = "重新命名";
    public final String renameLabel2;// = "開頭字:";
    public final String renameLabel3;// = "起始編號:";
    public final String renameStartNumber;// = "000";
    public final String renameLabel4;// = "編號位數:";
    public final String renameNumberDigit;// = "3";
    public final String replaceLabell;// = "檔名取代";
    public final String replaceLabel2;// = "欲替換的字串:";
    public final String replaceLabel3;// = "更改為:";
    public final String replaceExtLabel1;// = "更改副檔名";
    public final String replaceExtLabel2;// = "副檔名:";
    public final String moveLabel;// = "移動檔案";
    public final String moveBrowser;// = "瀏覽";
    public final String datanotwell;// = "資料不齊全";
    public final String dataerror;// = "資料錯誤";
    public final String noheadword;// = "開頭字欄位未填";
    public final String nostartnum;// = "起始編號欄位未填";
    public final String nocountnum;// = "編號位數欄位未填";
    public final String startnumnotcorrect;// = "起始編號欄位欄位非數字或格式不正確";
    public final String countnumnotcorrect;// = "編號位數欄位非數字或格式不正確";
    public final String noreplacestr;// = "欲替換字串欄位未填";
    public final String noreplaceto;// = "更改為　欄位未填";
    public final String noext;// = "副檔名欄位未填";
	public final String nopath;// = "檔案路徑欄位未填";
	
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