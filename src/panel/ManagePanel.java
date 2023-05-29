package panel;

import lombok.EqualsAndHashCode;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.regex.Pattern;

/**
 * @author Zhai Jinpei
 */
@EqualsAndHashCode(callSuper=true)

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
    String[] title1 = new String[]{"id","sno","cno","score"};
    String[] title2 = new String[]{"cno","avg score"};
    String[] title3 = new String[]{"id","ca","sno","name","sex"};
    String[] title4 = new String[]{"sno","all score"};
    String[] title5 = new String[]{"cno","avg score"};
    JTable jTable = new JTable(new DefaultTableModel(new Object[100][],title1));
    JScrollPane jScrollPane = new JScrollPane(jTable);


    public JButton getSelect(){
        return select;
    }

    public JComboBox<String> getJComboBox1(){
        return jComboBox1;
    }

    public JComboBox<String> getJComboBox2(){
        return jComboBox2;
    }

    public JComboBox<String> getJComboBox3(){
        return jComboBox3;
    }

    public JComboBox<String> getJComboBox4(){
        return jComboBox4;
    }

    public JComboBox<String> getJComboBox5(){
        return jComboBox5;
    }

    public JComboBox<String> getJComboBox6(){
        return jComboBox6;
    }

    public JButton getInsert(){
        return insert;
    }

    public JButton getModify(){
        return modify;
    }

    public JButton getDelete(){
        return delete;
    }

    public JButton getSort(){
        return sort;
    }

    public JButton getAvg(){
        return avg;
    }

    public JButton getAll(){
        return all;
    }

    public JButton getCls(){
        return cls;
    }

    public JTextField getSn(){
        return sn;
    }

    public JTextField getCn(){
        return cn;
    }

    public JTextField getSon(){
        return son;
    }

    public JTextField getIdt(){
        return idt;
    }

    public JTextField getNat(){
        return nat;
    }

    public JTextField getSt(){
        return st;
    }

    public String[] getTitle1(){
        return title1;
    }

    public String[] getTitle2(){
        return title2;
    }

    public String[] getTitle3(){
        return title3;
    }

    public String[] getTitle4(){
        return title4;
    }

    public String[] getTitle5(){
        return title5;
    }

    public JTable getJTable(){
        return jTable;
    }

    public JScrollPane getJScrollPane(){
        return jScrollPane;
    }

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
        jComboBox4.setBounds(525,0,70,30);
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
        sn.addActionListener(e->{
            try{
                double parsed = Double.parseDouble(sn.getText());
                if(parsed > 9_999_999_999d || parsed < 1_000_000_000d){
                    JOptionPane.showMessageDialog(this,"invalid input");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"invalid input");
                throw new RuntimeException(ex);
            }
        });
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
        idt.addActionListener(e->{
            String regex = "(?:(?:19[0-9]\\d)|(?:[2-9]\\d{3}))(?:0[1-9]|1[012])(?:0[1-9]|[12]\\d|3[01])\\d{3}[\\dXx]";
            if(!Pattern.matches(regex,idt.getText()) && !verifyIdCardCheckCode(idt.getText())){
                JOptionPane.showMessageDialog(this,"invalid input");
            }
        });
        add(name);
        add(nat);
        add(sex);
        add(st);
        add(jScrollPane);
    }

    /**
     * 验证身份证号码的校验码是否正确
     *
     * @param idCardNumber 身份证号码
     * @return 校验结果，true表示校验通过，false表示校验失败
     */
    public static boolean verifyIdCardCheckCode(String idCardNumber){
        // 身份证号码长度必须为18位
        if(idCardNumber.length() != 18){
            return false;
        }

        // 校验码只可能是0~9或X（大写）
        char lastChar = idCardNumber.charAt(17);
        if(!Character.isDigit(lastChar) && lastChar != 'X'){
            return false;
        }

        // 计算校验码
        int sum = 0;
        for(int i = 0;i < 17;i++){
            char c = idCardNumber.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
            int digit = c - '0';
            int weight = WEIGHT_FACTOR[i];
            sum += digit * weight;
        }
        int remainder = sum % 11;
        char expectedCheckCode = CHECK_CODE[remainder];

        // 检查校验码是否一致
        return expectedCheckCode == lastChar;
    }

    // 权重因子数组
    private static final int[] WEIGHT_FACTOR = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};

    // 校验码数组
    private static final char[] CHECK_CODE = {'1','0','X','9','8','7','6','5','4','3','2'};
}
