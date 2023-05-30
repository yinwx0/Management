package frame;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * @author Zhai Jinpei
 */
public class Browser2 extends JPanel{
    public Browser2(){
        super(new BorderLayout());
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Native Web Browser component"));
        final JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.navigate("https://www.baidu.com");
        webBrowserPanel.add(webBrowser,BorderLayout.CENTER);
        add(webBrowserPanel,BorderLayout.CENTER);
        // Create an additional bar allowing to show/hide the menu bar of the web browser.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,4,4));
        JCheckBox menuBarCheckBox = new JCheckBox("Menu Bar",webBrowser.isMenuBarVisible());
        menuBarCheckBox.addItemListener(e->webBrowser.setMenuBarVisible(e.getStateChange() == ItemEvent.SELECTED));
        buttonPanel.add(menuBarCheckBox);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    /* Standard main method to try that test as a standalone application. */
    public static void main(String[] args){
        UIUtils.setPreferredLookAndFeel();
        NativeInterface.open();
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("DJ Native Swing Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Browser2(),BorderLayout.CENTER);
            //不显示标题栏,最大化,最小化,退出按钮
            frame.setUndecorated(true);
            frame.setSize(800,600);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
        NativeInterface.runEventPump();
    }
}