package frame;

/**
 * @author Zhai Jinpei
 */

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javax.swing.*;

public class SWTest{
    public SWTest(String url) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
        SwingUtilities.invokeLater(()->{
            Display display = new Display();
            Shell shell = new Shell(display);
            shell.setBounds(-8,-5,1936,1095);
            Browser browser = new Browser(shell,SWT.FILL);
            browser.setBounds(0,0,1936,1095);
            if(url == null || url.equals("")){
                browser.setUrl("https://www.bing.com");
            }else{
                browser.setUrl(url);
            }
            shell.open();
            while(!shell.isDisposed()){
                if(!display.readAndDispatch())
                    display.sleep();
            }
            display.dispose();
        });
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        new SWTest(null);
    }
}
