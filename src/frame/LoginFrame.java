package frame;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import factory.Factory;
import model.Admin;
import panel.LoginPanel;
import utils.JDBCUtils;

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
                if(loginPanel.getjComboBox().getSelectedIndex() == 1){
                    Factory.state = 1;
                    PropertiesFrame jFrame = new PropertiesFrame(0);
                    LoginFrame.this.dispose();
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
                                    }catch(SQLException ex){
                                        throw new RuntimeException(ex);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null,"please input");
                                }
                            }
                    );
                }else{
                    PropertiesFrame jFrame = new PropertiesFrame();
                    LoginFrame.this.dispose();
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
                                            JOptionPane.showMessageDialog(this,"Success");
                                            jFrame.dispose();
                                            dispose();
                                            new ManageFrame();
                                        }else{
                                            JOptionPane.showMessageDialog(this,"Failed");
                                        }
                                    }catch(SQLException ex){
                                        throw new RuntimeException(ex);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null,"please input");
                                }
                            }
                    );
                }
            });
            loginPanel.getExit().addActionListener(e->System.exit(0));
        });
    }
}
