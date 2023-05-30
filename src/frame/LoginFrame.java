package frame;

import com.birosoft.liquid.LiquidLookAndFeel;
import com.formdev.flatlaf.demo.LookAndFeelsComboBox;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import factory.Factory;
import main.MainThread;
import model.Admin;
import panel.LoginPanel;
import utils.JDBCUtils;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class LoginFrame extends JFrame{
    private volatile static LookAndFeel lookAndFeel = new NimbusLookAndFeel();
    private final Thread thread = new MainThread();

    public static LookAndFeel getLookAndFeel(){
        return lookAndFeel;
    }

    LoginPanel loginPanel = new LoginPanel();

    public LoginFrame() throws UnsupportedLookAndFeelException{
        SwingUtilities.invokeLater(()->{
            setTitle("login");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);
            setBounds(500,300,479,250);
            setContentPane(loginPanel);
            loginPanel.setVisible(true);
            LookAndFeelsComboBox comboBox = loginPanel.getComboBox();
            comboBox.addActionListener(e->{
                switch(comboBox.getSelectedIndex()){
                    case 0 -> lookAndFeel = new NimbusLookAndFeel();
                    case 1 -> lookAndFeel = new FlatGitHubContrastIJTheme();
                    case 2 -> lookAndFeel = new FlatGitHubDarkContrastIJTheme();
                    case 3 -> lookAndFeel = new FlatGitHubDarkIJTheme();
                    case 4 -> lookAndFeel = new FlatGitHubIJTheme();
                    case 5 -> lookAndFeel = new FlatHiberbeeDarkIJTheme();
                    case 6 -> lookAndFeel = new FlatNightOwlContrastIJTheme();
                    case 7 -> lookAndFeel = new FlatGruvboxDarkHardIJTheme();
                    case 8 -> lookAndFeel = new FlatCyanLightIJTheme();
                    case 9 -> lookAndFeel = new FlatCobalt2IJTheme();
                    case 10 -> lookAndFeel = new LiquidLookAndFeel();
                    //TODO:add corresponding LookAndFeel instance
                }
                LoginFrame.this.dispose();
                thread.start();
            });
            loginPanel.getLogin().addActionListener(e->{
                try{
                    if(loginPanel.getjComboBox().getSelectedIndex() == 1){
                        Factory.state = 1;
                        LoginFrame.this.dispose();
                        UIManager.setLookAndFeel(lookAndFeel);
                        PropertiesFrame jFrame = new PropertiesFrame(0);
                        jFrame.getDestination_host_mysql_host_port().addActionListener(e1->{
                                    if(!(
                                            jFrame.getDestination_host_username().getText().equals("") &&
                                                    jFrame.getDestination_host_ip().getText().equals("") &&
                                                    jFrame.getDestination_host_port().getText().equals("") &&
                                                    String.valueOf(jFrame.getDestination_host_password().getPassword()).equals("") &&
                                                    jFrame.getDestination_host_mysql_username().getText().equals("") &&
                                                    jFrame.getDestination_host_mysql_database_name().getText().equals("") &&
                                                    String.valueOf(jFrame.getDestination_host_mysql_database_password().getPassword()).equals("") &&
                                                    jFrame.getDestination_host_mysql_host_ip().getText().equals("") &&
                                                    jFrame.getDestination_host_mysql_host_port().getText().equals("")
                                    )){
                                        JDBCUtils.setDh_user(jFrame.getDestination_host_username().getText());
                                        JDBCUtils.setDh_ip(jFrame.getDestination_host_ip().getText());
                                        JDBCUtils.setDh_port(jFrame.getDestination_host_port().getText());
                                        JDBCUtils.setDh_pwd(String.valueOf(jFrame.getDestination_host_password().getPassword()));
                                        JDBCUtils.setDsqluser(jFrame.getDestination_host_mysql_username().getText());
                                        JDBCUtils.setDsqldbname(jFrame.getDestination_host_mysql_database_name().getText());
                                        JDBCUtils.setDsqlpwd(String.valueOf(jFrame.getDestination_host_mysql_database_password().getPassword()));
                                        JDBCUtils.setDsqlip(jFrame.getDestination_host_mysql_host_ip().getText());
                                        JDBCUtils.setDsqlport(jFrame.getDestination_host_mysql_host_port().getText());
                                        try{
                                            if(Factory.Serv().checkLogin(new Admin(loginPanel.no(),loginPanel.password()))){
                                                JOptionPane.showMessageDialog(this,"Success");
                                                jFrame.dispose();
                                                dispose();
                                                new ManageFrame();
                                            }else{
                                                JOptionPane.showMessageDialog(this,"Failed");
                                            }
                                        }catch(SQLException | UnsupportedLookAndFeelException ex){
                                            throw new RuntimeException(ex);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"please input");
                                    }
                                }
                        );
                    }else{
                        LoginFrame.this.dispose();
                        UIManager.setLookAndFeel(lookAndFeel);
                        PropertiesFrame jFrame = new PropertiesFrame();
                        jFrame.getPassword().addActionListener(e1->{
                                    if(!(
                                            jFrame.getDatabasename().getText().equals("") &&
                                                    jFrame.getUsername().getText().equals("") &&
                                                    String.valueOf(jFrame.getPassword().getPassword()).equals("")
                                    )
                                    ){
                                        JDBCUtils.setDatabase_name(jFrame.getDatabasename().getText());
                                        JDBCUtils.setUsername(jFrame.getUsername().getText());
                                        JDBCUtils.setPassword(String.valueOf(jFrame.getPassword().getPassword()));
                                        try{
                                            if(Factory.Serv().checkLogin(new Admin(loginPanel.no(),loginPanel.password()))){
                                                JOptionPane.showMessageDialog(null,"Success");
                                                jFrame.dispose();
                                                new ManageFrame();
                                            }else{
                                                JOptionPane.showMessageDialog(null,"Failed");
                                            }
                                        }catch(SQLException | UnsupportedLookAndFeelException ex){
                                            throw new RuntimeException(ex);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"please input");
                                    }
                                }
                        );
                    }
                }catch(UnsupportedLookAndFeelException ex){
                    throw new RuntimeException(ex);
                }
            });
            loginPanel.getExit().addActionListener(e->System.exit(0));
        });
    }
}
