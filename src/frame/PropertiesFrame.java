package frame;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
@SuppressWarnings("all")
@Data
public class PropertiesFrame extends JFrame{
    JPanel jPanel = new JPanel();
    JTextField databasename = new JTextField();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel data = new JLabel("本地mysql数据库名");
    JLabel user = new JLabel("本地mysql用户名");
    JLabel pwd = new JLabel("本地mysql密码");
    JLabel dh_user = new JLabel("目标主机用户名");
    JTextField destination_host_username = new JTextField("");
    JLabel dh_ip = new JLabel("目标主机IP");
    JTextField destination_host_ip = new JTextField("");
    JLabel dh_port = new JLabel("目标主机端口");
    JTextField destination_host_port = new JTextField();
    JLabel dh_pwd = new JLabel("目标主机密码");
    JPasswordField destination_host_password = new JPasswordField();
    JLabel d_sql_user = new JLabel("目标主机mysql用户名");
    JTextField destination_host_mysql_username = new JTextField();
    JLabel d_sql_dbname = new JLabel("目标主机mysql数据库名");
    JTextField destination_host_mysql_database_name = new JTextField();
    JLabel d_sql_pwd = new JLabel("目标主机mysql密码");
    JPasswordField destination_host_mysql_database_password = new JPasswordField();
    JLabel d_sql_ip = new JLabel("目标主机mysql地址ip");
    JTextField destination_host_mysql_host_ip = new JTextField();
    JLabel d_sql_port = new JLabel("目标主机mysql端口");
    JTextField destination_host_mysql_host_port = new JTextField();

    public PropertiesFrame(){
        setBounds(500,200,400,120);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jPanel.setSize(400,120);
        jPanel.setLayout(new GridLayout(3,2));
        jPanel.add(data);
        jPanel.add(databasename);
        jPanel.add(user);
        jPanel.add(username);
        jPanel.add(pwd);
        jPanel.add(password);
        setContentPane(jPanel);
        jPanel.setVisible(true);
    }

    public PropertiesFrame(int sta){
        if(sta == 0){
            setBounds(500,200,400,360);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jPanel.setSize(400,360);
            jPanel.setLayout(new GridLayout(9,2));
            jPanel.add(dh_user);
            jPanel.add(destination_host_username);
            jPanel.add(dh_ip);
            jPanel.add(destination_host_ip);
            jPanel.add(dh_port);
            jPanel.add(destination_host_port);
            jPanel.add(dh_pwd);
            jPanel.add(destination_host_password);
            jPanel.add(d_sql_user);
            jPanel.add(destination_host_mysql_username);
            jPanel.add(d_sql_dbname);
            jPanel.add(destination_host_mysql_database_name);
            jPanel.add(d_sql_pwd);
            jPanel.add(destination_host_mysql_database_password);
            jPanel.add(d_sql_ip);
            jPanel.add(destination_host_mysql_host_ip);
            jPanel.add(d_sql_port);
            jPanel.add(destination_host_mysql_host_port);
            setContentPane(jPanel);
            jPanel.setVisible(true);
        }
    }
}
