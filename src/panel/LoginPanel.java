package panel;


import com.formdev.flatlaf.demo.LookAndFeelsComboBox;
import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
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
    LookAndFeelsComboBox comboBox = new LookAndFeelsComboBox();
    JLabel verify = new JLabel("验证码");
    JLabel look = new JLabel("Theme");
    JLabel phone = new JLabel("手机号");
    JButton get = new JButton("获取验证码");
    JTextField code = new JTextField("验证码");
    JTextField num = new JTextField("手机号");

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/img/1684150268080.gif").getImage(),0,-30,this);
    }

    public Integer no(){
        if(noi.getText().equals("")) return null;
        else return Integer.parseInt(noi.getText());
    }

    public LookAndFeelsComboBox getComboBox(){
        return comboBox;
    }

    public String password(){
        return String.valueOf(passwordi.getPassword());
    }

    public LoginPanel() throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatHiberbeeDarkIJTheme());
        comboBox.addLookAndFeel("NimbusLookAndFeel","javax.swing.plaf.nimbus.NimbusLookAndFeel");
        comboBox.addLookAndFeel("FlatGitHubContrastIJTheme","com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme");
        comboBox.addLookAndFeel("FlatGitHubDarkContrastIJTheme","com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme");
        comboBox.addLookAndFeel("FlatGitHubDarkIJTheme","com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme");
        comboBox.addLookAndFeel("FlatGitHubIJTheme","com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme");
        comboBox.addLookAndFeel("FlatHiberbeeDarkIJTheme","com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme");
        comboBox.addLookAndFeel("FlatNightOwlContrastIJTheme","com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme");
        comboBox.addLookAndFeel("FlatGruvboxDarkHardIJTheme","com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme");
        comboBox.addLookAndFeel("FlatCyanLightIJTheme","com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme");
        comboBox.addLookAndFeel("FlatCobalt2IJTheme","com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme");
        comboBox.addLookAndFeel("LiquidTheme","com.birosoft.liquid.LiquidLookAndFeel");
        setLayout(null);
        setSize(479,250);
        browser.setBounds(-15,0,65,30);
        no.setBounds(50,20,80,30);
        password.setBounds(50,60,80,30);
        noi.setBounds(150,20,280,30);
        passwordi.setBounds(150,60,280,30);
        verify.setBounds(50,135,80,30);
        look.setBounds(50,110,80,30);
        comboBox.setBounds(150,115,280,30);
        code.setBounds(150,135,170,30);
        get.setBounds(330,135,100,30);
        phone.setBounds(50,100,80,30);
        num.setBounds(150,100,280,30);
        login.setBounds(100,170,80,30);
        jComboBox.setBounds(200,170,80,30);
        exit.setBounds(300,170,80,30);
        browser.setOpaque(false);
        browser.setContentAreaFilled(false);
        browser.setFont(new Font("Comic Sans MS",Font.ITALIC,14));
        verify.setFont(new Font("宋体",Font.ITALIC,14));
        verify.setForeground(Color.yellow);
        phone.setFont(new Font("宋体",Font.ITALIC,14));
        phone.setForeground(Color.yellow);
//        add(phone);
//        add(num);
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
        look.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        look.setForeground(Color.CYAN);
        look.setOpaque(false);
        add(look);
        add(comboBox);
        add(browser);
        browser.setForeground(Color.CYAN);
        browser.addActionListener(e->{
            Runnable runnable = new Runnable(){
                @Override
                public void run(){
                    try{
                        new SWTest(null);
                    }catch(UnsupportedLookAndFeelException ex){
                        throw new RuntimeException(ex);
                    }
                }
            };
            runnable.run();
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
//        add(verify);
//        add(code);
//        add(get);
        add(login);
        login.setForeground(Color.yellow);
        add(jComboBox);
        add(exit);
        exit.setForeground(Color.yellow);
    }
}
