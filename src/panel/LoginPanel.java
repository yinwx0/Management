package panel;

import frame.SWTest;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
@SuppressWarnings("all")
@Data
public class LoginPanel extends JPanel{
    public JComboBox<String> getjComboBox(){
        return jComboBox;
    }

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

    JButton browser = new JButton("help");
    JLabel no = new JLabel("User");
    JLabel password = new JLabel("password");
    JButton login = new JButton("login");
    JButton exit = new JButton("exit");
    JTextField noi = new JTextField();
    JPasswordField passwordi = new JPasswordField();
    JComboBox<String> jComboBox = new JComboBox<>(new String[]{"本地","远程"});

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/img/1684150268080.gif").getImage(),0,-30,this);
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
        browser.setBounds(0,0,80,30);
        no.setBounds(50,40,80,30);
        password.setBounds(50,100,80,30);
        noi.setBounds(150,40,280,30);
        passwordi.setBounds(150,100,280,30);
        login.setBounds(100,160,80,30);
        jComboBox.setBounds(200,160,80,30);
        exit.setBounds(300,160,80,30);
        browser.setOpaque(false);
        browser.setContentAreaFilled(false);
        browser.setFont(new Font("Comic Sans MS",Font.ITALIC,14));
        no.setOpaque(false);
        no.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        noi.setOpaque(false);
        noi.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        password.setOpaque(false);
        password.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        passwordi.setOpaque(false);
        passwordi.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        login.setContentAreaFilled(false);
        login.setForeground(Color.CYAN);
        login.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        exit.setForeground(Color.CYAN);
        exit.setContentAreaFilled(false);
        exit.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        add(browser);
        browser.setForeground(Color.CYAN);
        browser.addActionListener(e->{
            try{
                SWTest swTest = new SWTest(null);
            }catch(UnsupportedLookAndFeelException ex){
                throw new RuntimeException(ex);
            }
        });
        no.setForeground(new Color(0x79FF67));
        add(no);
        no.setForeground(Color.YELLOW);
        add(password);
        password.setForeground(Color.YELLOW);
        add(noi);
        noi.setForeground(Color.black);
        add(passwordi);
        passwordi.setForeground(Color.black);
        add(login);
        login.setForeground(Color.yellow);
        add(jComboBox);
        add(exit);
        exit.setForeground(Color.yellow);
    }
}
