package frame;


import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
public class JWebBrowserExample extends JFrame{
    JWebBrowser webBrowser = new JWebBrowser();

    public JWebBrowserExample() throws UnsupportedLookAndFeelException{
        NativeInterface.open();
        UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
        SwingUtilities.invokeLater(()->{
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800,600);
            setLocationByPlatform(true);
            webBrowser.navigate("https://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html");
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(webBrowser);
            setVisible(true);
        });
        NativeInterface.runEventPump();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        new JWebBrowserExample();
    }
}