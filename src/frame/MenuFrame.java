package frame;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import panel.MenuPanel;

import javax.swing.*;

/**
 * @author Zhai Jinpei
 */
public class MenuFrame extends JFrame{
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            try{
                new MenuFrame();
            }catch(UnsupportedLookAndFeelException e){
                throw new RuntimeException(e);
            }
        });
    }

    public MenuFrame() throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
        setBounds(500,200,600,600);
        setVisible(true);
        JPanel panel = new MenuPanel();
        setContentPane(panel);
        panel.setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
}
