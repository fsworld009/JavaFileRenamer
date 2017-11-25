//FileListPanel.java
//import java.lang.String;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import java.io.File;



public class FileListPanel extends JPanel
{
	private Language lang = new Language();
	
    private JLabel titleText = new JLabel(lang.flptitleText);
    private DefaultListModel listModel = new DefaultListModel();
    private JList selectList = new JList(listModel);
    public FileListPanel()
	{
        setLayout(new BorderLayout());
        selectList = new JList(listModel ) ; 
		selectList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(selectList));//list, 提供捲動的功能
        add(titleText,BorderLayout.NORTH);
	}
	
    public File[] getListData(){
        //return current Files in the List;
        int size = selectList.getModel().getSize();
        if(size>0){  //if anything exist
            File[] returnFiles = new File[size];
            for(int i=0;i<size;i++){
                returnFiles[i] = (File) listModel.getElementAt(i);
            }
            return returnFiles;
        }
        return null;    //otherwise return null
        

	}
	
    public boolean addFile (File[] newAddedFiles)
    {
        /*File[] resultFiles = null;
        File[] currentListFiles = getListData();
        if(newAddedFiles == null){      //nothing to add
            return false;       
        }
        
        int currentListFilesLength=0;
        if(currentListFiles != null){                   //if the old Files is null, length is 0
            currentListFilesLength = currentListFiles.length;
        }
        int newAddedFilesLength = newAddedFiles.length;

        resultFiles = new File[currentListFilesLength+newAddedFilesLength];   //won't be 0 because newAddedFiles is not null
        int i=0;
        //copy the original data in the list
        if(currentListFiles != null){
            for(i=0;i<currentListFiles.length;i++){
                resultFiles[i] = currentListFiles[i];
            }
        }
        //copy the new data from this event
        for(i=currentListFilesLength;i<resultFiles.length;i++){
            resultFiles[i]=newAddedFiles[i-currentListFilesLength];
        }

      //update list
        selectList.setListData(resultFiles);   
        return true;*/
        
        if(newAddedFiles == null){      //nothing to add
            return false;       
        }
        
        for(int i=0;i<newAddedFiles.length;i++){
            
            listModel.addElement(newAddedFiles[i]);
        }
        selectList.setModel(listModel);
        return true;
    }
	
    //delete select File
    public boolean removeFile()
    {
      /*
        int removeIndex[] = selectList.getSelectedIndices();//get Index[] to delete File
 
        //nothing to delete
        if(removeIndex.equals(null)){
            return false;
        }
        
        File[] currentListFiles = getListData();
        File[] resultFiles = null;
        int i, j;
        int newlength = 0;
        if(currentListFiles != null){
            newlength = currentListFiles.length;//the new length after delete oldFile
        }
        
        //copy next data 
        for(i=0; i<removeIndex.length; i++)
        {
            for(j=removeIndex[i]; j<newlength-1; j++)
                currentListFiles[j]=currentListFiles[j+1];
            newlength--;
        }
        
        //creat
        resultFiles = new File[newlength];
        
         //copy the original data in the list
        if(currentListFiles != null){
            for(i=0;i<newlength;i++){
                resultFiles[i] = currentListFiles[i];
            }
        }
        
        //update list
        selectList.setListData(resultFiles);
        return true;
        
        */

        int removeIndex[] = selectList.getSelectedIndices();//get Index[] to delete File
        

        //nothing to delete
        if(removeIndex.equals(null)){
            return false;
        }
        
        for(int i=0;i<removeIndex.length;i++){
            listModel.removeElementAt(removeIndex[i]);
            //listModel is a vector, so all selectIndex  reduces 1
            for(int j=i+1;j<removeIndex.length;j++){
                removeIndex[j]--;
            }
       }
        selectList.setModel(listModel);
        return true;

    }
    
    public void clear(){
        //int size = selectList.getModel().getSize();
        listModel.removeAllElements();
        selectList.setModel(listModel);
    }
    
    public boolean moveUp(){
        int selectIndex[] = selectList.getSelectedIndices();//get Index[]

        //nothing to move
        if(selectIndex.equals(null)){
            return false;
        }
        for(int i=0;i<selectIndex.length;i++){
            if(selectIndex[i]>0){
                swap(selectIndex[i],selectIndex[i]-1);
                selectIndex[i]--;   //for later's re-select
            }
        }
        selectList.setModel(listModel);
        selectList.setSelectedIndices(selectIndex);
        return true;
    }
    
    public boolean moveDown(){
        int selectIndex[] = selectList.getSelectedIndices();//get Index[]

        //nothing to move
        if(selectIndex.equals(null)){
            return false;
        }
        for(int i=0;i<selectIndex.length;i++){
            if(selectIndex[i]<listModel.getSize()-1){
                swap(selectIndex[i],selectIndex[i]+1);
                selectIndex[i]++;   //for later's re-select
            }
        }
        selectList.setModel(listModel);
        selectList.setSelectedIndices(selectIndex);
        return true;
    }
    
    private void swap(int index1,int index2){
        File a = (File) listModel.getElementAt(index1);
        File b = (File) listModel.getElementAt(index2);
        listModel.setElementAt(a,index2);
        listModel.setElementAt(b,index1);
    }

}