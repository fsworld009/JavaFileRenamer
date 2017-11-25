//MainProgram.java

import javax.swing.JFrame;

public class MainProgram
{
    public static void main(String args[])
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MainFrame.FRAMEWIDTH,MainFrame.FRAMEHEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}