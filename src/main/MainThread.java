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

    /**
     * If this thread was constructed using a separate
     * {@code Runnable} run object, then that
     * {@code Runnable} object's {@code run} method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of {@code Thread} should override this method.
     *
     * @see #start()
     */
    @Override
    public void run(){
        super.run();
        try{
            new LoginFrame();
        }catch(UnsupportedLookAndFeelException e){
            throw new RuntimeException(e);
        }
    }
}
