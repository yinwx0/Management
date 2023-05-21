package panel;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class ManagePanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0xF6F1F1));
        g.fillRect(0,0,610,150);
        g.setColor(new Color(0xDCFFD6));
        g.fillRect(0,150,610,450);
    }

    JButton select = new JButton("select");
    JComboBox<String> jComboBox1 = new JComboBox<>(new String[]{"stu","score"});
    JComboBox<String> jComboBox2 = new JComboBox<>(new String[]{"stu","score"});
    JComboBox<String> jComboBox3 = new JComboBox<>(new String[]{"stu","score"});
    JComboBox<String> jComboBox4 = new JComboBox<>(new String[]{"stu","score"});
    JComboBox<String> jComboBox5 = new JComboBox<>(new String[]{"stu","course"});
    JComboBox<String> jComboBox6 = new JComboBox<>(new String[]{"single","all"});
    JButton insert = new JButton("insert");
    JButton modify = new JButton("modify");
    JButton delete = new JButton("delete");
    JButton sort = new JButton("sort");
    JButton avg = new JButton("avg");
    JButton all = new JButton("all score");
    JButton cls = new JButton("clear");
    JLabel sno = new JLabel("sno");
    JLabel cno = new JLabel("cno");
    JLabel score = new JLabel("score");
    JLabel id = new JLabel("ca");
    JLabel name = new JLabel("name");
    JLabel sex = new JLabel("sex");
    JTextField sn = new JTextField();
    JTextField cn = new JTextField();
    JTextField son = new JTextField();
    JTextField idt = new JTextField();
    JTextField nat = new JTextField();
    JTextField st = new JTextField();
    String[] title1 = new String[]{"sno","cno","score"};
    String[] title2 = new String[]{"cno","avg score"};
    String[] title3 = new String[]{"ca","sno","name","sex"};
    String[] title4 = new String[]{"sno","all score"};
    String[] title5 = new String[]{"cno","avg score"};
    JTable jTable = new JTable(new DefaultTableModel(new Object[100][],title1));
    JScrollPane jScrollPane = new JScrollPane(jTable);

    public String sno(){
        return sn.getText();
    }

    public Integer cno(){
        if(cn.getText().equals("")) return null;
        else return Integer.parseInt(cn.getText());
    }

    public Double score(){
        if(son.getText().equals("")) return null;
        else return Double.parseDouble(son.getText());
    }

    public String id(){
        return idt.getText();
    }

    public String name(){
        return nat.getText();
    }

    public String sex(){
        return st.getText();
    }

    public ManagePanel(){
        setSize(620,600);
        setLayout(null);
        select.setBounds(0,0,75,30);
        jComboBox1.setBounds(75,0,75,30);
        insert.setBounds(150,0,75,30);
        jComboBox2.setBounds(225,0,75,30);
        modify.setBounds(300,0,75,30);
        jComboBox3.setBounds(375,0,75,30);
        delete.setBounds(450,0,75,30);
        jComboBox4.setBounds(525,0,60,30);
        sno.setBounds(0,30,50,30);
        sn.setBounds(50,30,150,30);
        cno.setBounds(200,30,50,30);
        cn.setBounds(250,30,150,30);
        score.setBounds(400,30,50,30);
        son.setBounds(450,30,150,30);
        sort.setBounds(0,60,100,30);
        jComboBox5.setBounds(100,60,100,30);
        avg.setBounds(200,60,100,30);
        jComboBox6.setBounds(300,60,100,30);
        all.setBounds(400,60,100,30);
        cls.setBounds(500,60,100,30);
        id.setBounds(0,90,50,30);
        idt.setBounds(50,90,150,30);
        name.setBounds(200,90,50,30);
        nat.setBounds(250,90,150,30);
        sex.setBounds(400,90,50,30);
        st.setBounds(450,90,150,30);
        jScrollPane.setViewportView(jTable);
        jScrollPane.setBounds(0,140,610,460);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jTable.setFont(new Font("微软雅黑",Font.BOLD,16));
        jTable.setOpaque(false);
        jTable.setOpaque(false);
        jTable.setForeground(new Color(0x960E0D0D,true));
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setOpaque(false);
        jTable.setDefaultRenderer(Object.class,render);
        add(select);
        add(jComboBox1);
        add(insert);
        add(jComboBox2);
        add(modify);
        add(jComboBox3);
        add(delete);
        add(jComboBox4);
        add(sno);
        add(sn);
        add(cno);
        add(cn);
        add(score);
        add(son);
        add(sort);
        add(jComboBox5);
        add(avg);
        add(jComboBox6);
        add(all);
        add(cls);
        add(id);
        add(idt);
        add(name);
        add(nat);
        add(sex);
        add(st);
        add(jScrollPane);
    }
}
