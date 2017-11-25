import java.io.File;
import java.util.Date;

public class CoreFunction 
{
	private Language lang = new Language();
	
    private String outputString = "";   //new class attribute to save message
    private File failFiles[] = null;           //save fail files
    
    public void rename(File[] targetFile, String startWord, int startNumber, int assignDigit)
    {
        String newFileName;
        File filemoveto;
        for(int i = 0; i < targetFile.length; i++)
        {
            //detemine assignDigit to set newFileName's number part
            int tempForRenameFileNumber = startNumber;
            int countDigit = tempForRenameFileNumber;
            int addZero = assignDigit - 1;
            while(countDigit >= 10)
            {
                countDigit = countDigit / 10;
                addZero--;
            }
            //set assignDigit to assigned format
            String numberPartString = Integer.toString(tempForRenameFileNumber);//convert int to string
            for(int j = 0; j < addZero; j++)
            {
                numberPartString = "0" + numberPartString;
            }
            newFileName = startWord + numberPartString;
            if(targetFile[i].exists())
            {
                if(targetFile[i].isFile()) //如果是檔案
                {
                        int startIndex = targetFile[i].getName().lastIndexOf(46) + 1;
                        int endIndex = targetFile[i].getName().length();
                        filemoveto = new File(targetFile[i].getParent() + File.separatorChar + newFileName + '.' + targetFile[i].getName().substring(startIndex, endIndex));
                        if(targetFile[i].renameTo(filemoveto))
                        {
                            addOutputString(String.format(lang.filerenamesuccess, new Date(), targetFile[i].getName(), filemoveto.getName()));
                            startNumber++;
                        }
                        else
                        {
                            addOutputString(String.format(lang.filerenamefail, new Date(), targetFile[i].getName()));
                            addFailFiles(targetFile[i]);
                        }
                            
                }
                
                else if(targetFile[i].isDirectory()) //如果是資料夾
                {
                        File dirmoveto = new File(targetFile[i].getParent() + File.separatorChar + newFileName);
                        if(targetFile[i].renameTo(dirmoveto))
                        {
                            addOutputString(String.format(lang.dirrenamesuccess, new Date(), targetFile[i].getName(), dirmoveto.getName()));
                            startNumber++;
                        }
                        else
                        {
                            addOutputString(String.format(lang.dirrenamefail, new Date(), targetFile[i].getName()));
                            addFailFiles(targetFile[i]);
                        }
                }
            }
            else
            {
                addOutputString(String.format(lang.notexist, new Date(), targetFile[i].getName()));
                addFailFiles(targetFile[i]);
            }
        }
    }
    
    public void replace(File targetFile[], String compareString, String changeString)
    {
        File filemoveto;
        for(int i = 0; i < targetFile.length; i++)
        {
            if(targetFile[i].exists())
            {
                if(targetFile[i].isFile()) //如果是檔案
                {
                        String fileName = targetFile[i].getName();
                        int dotPos = fileName.lastIndexOf(".");
                        String newname = fileName.substring(0, dotPos);
                        String newFileName = newname.replaceAll(compareString, changeString);
                    
                    
                        int startIndex = targetFile[i].getName().lastIndexOf(46) + 1;
                        int endIndex = targetFile[i].getName().length();
                        filemoveto = new File(targetFile[i].getParent() + File.separatorChar + newFileName + '.' + targetFile[i].getName().substring(startIndex, endIndex));
                        if(targetFile[i].renameTo(filemoveto))
                        {
                            addOutputString(String.format(lang.filereplacesuccess, new Date(), targetFile[i].getName(), filemoveto.getName()));
                        }
                        else{
                            addOutputString(String.format(lang.filereplacefail, new Date(), targetFile[i].getName()));
                            addFailFiles(targetFile[i]);
                        }
                }
                
                else if(targetFile[i].isDirectory()) //如果是資料夾
                {
                        String fileName = targetFile[i].getName();
                        String newFileName = fileName.replaceAll(compareString, changeString);
                    
                        File dirmoveto = new File(targetFile[i].getParent() + File.separatorChar + newFileName);
                        //System.out.printf("%s\n", dirmoveto.getPath());
                        if(targetFile[i].renameTo(dirmoveto))
                        {
                            addOutputString(String.format(lang.dirreplacesuccess, new Date(), targetFile[i].getName(), dirmoveto.getName()));
                        }
                        else{
                            addOutputString(String.format(lang.dirreplacefail, new Date(), targetFile[i].getName()));
                            addFailFiles(targetFile[i]);
                        }
                }
            }else{
                addOutputString(String.format(lang.notexist, new Date(), targetFile[i].getName()));
                addFailFiles(targetFile[i]);
            }
            
        }       
    }
    
    public void replaceExt(File[] targetFile, String extension)
    {
        for(int i = 0; i < targetFile.length; i++)
        {
            if(targetFile[i].exists())
            {
                if(targetFile[i].isFile())
                {
                    String name = targetFile[i].getName();
                    int dotPos = name.lastIndexOf(".");
                    String newname = name.substring(0, dotPos);
                    File extensionto = new File(targetFile[i].getParent() + File.separatorChar + newname + '.' + extension);
                    if(targetFile[i].renameTo(extensionto))
                        addOutputString(String.format(lang.replaceextsuccess, new Date(), targetFile[i].getName()));
                    else{
                        addOutputString(String.format(lang.replaceextfail, new Date(), targetFile[i].getName()));
                        addFailFiles(targetFile[i]);
                    }
                }
                else
                {
                    addOutputString(String.format(lang.notfile, new Date(), targetFile[i].getName()));
                    addFailFiles(targetFile[i]);
                }
            }
            else
            {
                addOutputString(String.format(lang.notexist, new Date(), targetFile[i].getName()));
                addFailFiles(targetFile[i]);
            }
        }
    }
    
	
    public void move(File targetFile[], String path)
    {
        File newpath = new File(path);
            
        if(newpath.exists()) //要先確定該new path是否存在
        {
            if(!newpath.isDirectory()) //如果存在，就要檢查是否為資料夾
            {
                addOutputString(String.format(lang.notdir, new Date()));
                //all of the target is the failFiles
                for(int i = 0; i < targetFile.length; i++)
                {
                    addFailFiles(targetFile[i]);
                }
                return;
            }
        }
        else
        {      //if new path does not exist
            newpath.mkdirs();   //make it
        }
            
            
        for(int i = 0; i < targetFile.length; i++)
        {
            if(targetFile[i].exists()) //先確定是否存在
            {

                
                if(targetFile[i].isFile()) //如果是檔案
                {
                    File filemoveto = new File(newpath.getPath() + File.separatorChar + targetFile[i].getName());
                    if(targetFile[i].renameTo(filemoveto)){
                        addOutputString(String.format(lang.movefilesuccess, new Date() , targetFile[i].getName()));
                    }else{
                        addOutputString(String.format(lang.movefilefail, new Date() , targetFile[i].getName()));
                        addFailFiles(targetFile[i]);
                    }
                }
                else if(targetFile[i].isDirectory())//如果是資料夾
                {
                    File dirmoveto = new File(newpath.getPath() + File.separatorChar + targetFile[i].getName());
                    if(targetFile[i].renameTo(dirmoveto)){
                        addOutputString(String.format(lang.movedirsuccess, new Date() , targetFile[i].getName(), newpath.getPath()));
                    }else{
                        addOutputString(String.format(lang.movedirfail, new Date() , targetFile[i].getName(), newpath.getPath()));
                        addFailFiles(targetFile[i]);
                    }
                }
            }
            else
            {
                addOutputString(String.format(lang.notexist, new Date() , targetFile[i].getName()));
                addFailFiles(targetFile[i]);
            }
        }
        

    }
    

    


	public String getOutputString()
	{
        String returnString = outputString;
        //clear output string
        outputString = "";
        return returnString;
	}
	
	private void addOutputString(String message)
	{
		outputString += message;
	}
	
	public File[] getFailFiles()
	{
        File[] retunnFiles = failFiles;
        //clear fail files list
        failFiles = null;
        return retunnFiles;
	}
	
	private void addFailFiles(File newFailFile)
	{
        if(newFailFile==null){
            return;
        }
        int oldLength = 0;
        if(failFiles != null){
            oldLength = failFiles.length;
        }
        File[] tempFailFiles = new File[oldLength+1];
        if(failFiles != null){
            //if old fail files exist, copy them
            System.arraycopy(failFiles,0,tempFailFiles,0,oldLength);
        }
        tempFailFiles[oldLength] = newFailFile;
        failFiles = tempFailFiles;
            
	}
	

}