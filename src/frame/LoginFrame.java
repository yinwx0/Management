package frame;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import factory.Factory;
import model.Admin;
import panel.LoginPanel;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class LoginFrame extends JFrame{
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        new LoginFrame();
    }

    public LoginFrame() throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
        SwingUtilities.invokeLater(()->{
            setTitle("login");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);
            setBounds(500,300,479,250);
            LoginPanel loginPanel = new LoginPanel();
            setContentPane(loginPanel);
            loginPanel.setVisible(true);
            loginPanel.getLogin().addActionListener(e->{
                try{
                    if(Factory.Serv().checkLogin(new Admin(loginPanel.no(),loginPanel.password()))){
                        JOptionPane.showMessageDialog(this,"Success");
                        dispose();
                        new ManageFrame();
                    }else{
                        JOptionPane.showMessageDialog(this,"Failed");
                    }
                }catch(SQLException ex){
                    throw new RuntimeException(ex);
                }
            });
        });
    }
}
