package main;

import frame.LoginFrame;

import javax.swing.*;

/**
 * @author Zhai Jinpei
 */
public class MainThread extends Thread{
    public MainThread(){
        if(this.isInterrupted()) this.interrupt();
    }

    @Override
    public void run(){
        try{
            UIManager.setLookAndFeel(LoginFrame.getLookAndFeel());
            new LoginFrame();
        }catch(UnsupportedLookAndFeelException e){
            throw new RuntimeException(e);
        }
    }
}
