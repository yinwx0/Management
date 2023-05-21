package panel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
public class LoginPanel extends JPanel{
    public JButton getLogin(){
        return login;
    }

    public void setLogin(JButton login){
        this.login = login;
    }

    public JButton getExit(){
        return exit;
    }

    public void setExit(JButton exit){
        this.exit = exit;
    }

    JLabel no = new JLabel("No");
    JLabel password = new JLabel("password");
    JButton login = new JButton("login");
    JButton exit = new JButton("exit");
    JTextField noi = new JTextField();
    JPasswordField passwordi = new JPasswordField();

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/img/1684150268080.gif").getImage(),0,-30,this);
//        g.setColor(new Color(0x0E0D0D));
//        g.fillRect(0,0,479,250);
    }

    public Integer no(){
        if(noi.getText().equals("")) return null;
        else return Integer.parseInt(noi.getText());
    }

    public String password(){
        return String.valueOf(passwordi.getPassword());
    }

    public LoginPanel(){
        setLayout(null);
        setSize(479,250);
        no.setBounds(50,40,80,30);
        password.setBounds(50,100,80,30);
        noi.setBounds(150,40,280,30);
        passwordi.setBounds(150,100,280,30);
        login.setBounds(150,160,80,30);
        exit.setBounds(250,160,80,30);
        no.setOpaque(false);
        no.setFont(new Font("微软雅黑",Font.BOLD,20));
        noi.setOpaque(false);
        noi.setFont(new Font("微软雅黑",Font.BOLD,20));
        password.setOpaque(false);
        password.setFont(new Font("微软雅黑",Font.BOLD,16));
        passwordi.setOpaque(false);
        passwordi.setFont(new Font("微软雅黑",Font.BOLD,20));
        login.setContentAreaFilled(false);
        login.setFont(new Font("微软雅黑",Font.BOLD,16));
        exit.setContentAreaFilled(false);
        exit.setFont(new Font("微软雅黑",Font.BOLD,20));
        add(no);
        no.setForeground(Color.WHITE);
        add(password);
        password.setForeground(Color.WHITE);
        add(noi);
        noi.setForeground(Color.white);
        add(passwordi);
        passwordi.setForeground(Color.white);
        add(login);
        login.setForeground(Color.WHITE);
        add(exit);
        exit.setForeground(Color.WHITE);
    }
}
