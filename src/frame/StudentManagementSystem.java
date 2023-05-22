package frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends JFrame implements ActionListener{
    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField ageField;
    private final JTextField genderField;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton updateButton;
    private final JTable table;

    public StudentManagementSystem(){
        setTitle("学生信息管理系统");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建表格模型并添加数据
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("学号");
        tableModel.addColumn("姓名");
        tableModel.addColumn("年龄");
        tableModel.addColumn("性别");
        tableModel.addRow(new Object[]{"001","张三","20","男"});
        tableModel.addRow(new Object[]{"002","李四","21","女"});
        // 创建表格并设置模型
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);
        // 创建底部面板并添加组件
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600,100));
        JLabel idLabel = new JLabel("学号:");
        JLabel nameLabel = new JLabel("姓名:");
        JLabel ageLabel = new JLabel("年龄:");
        JLabel genderLabel = new JLabel("性别:");
        idField = new JTextField(10);
        nameField = new JTextField(10);
        ageField = new JTextField(10);
        genderField = new JTextField(10);
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        updateButton = new JButton("更新");
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        bottomPanel.add(idLabel);
        bottomPanel.add(idField);
        bottomPanel.add(nameLabel);
        bottomPanel.add(nameField);
        bottomPanel.add(ageLabel);
        bottomPanel.add(ageField);
        bottomPanel.add(genderLabel);
        bottomPanel.add(genderField);
        bottomPanel.add(addButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);
        add(bottomPanel,BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            // 添加学生信息
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            tableModel.addRow(new Object[]{idField.getText(),nameField.getText(),ageField.getText(),genderField.getText()});
        }else if(e.getSource() == deleteButton){
            // 删除选中行的学生信息
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                tableModel.removeRow(selectedRow);
            }
        }else if(e.getSource() == updateButton){
            // 更新选中行的学生信息
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                tableModel.setValueAt(idField.getText(),selectedRow,0);
                tableModel.setValueAt(nameField.getText(),selectedRow,1);
                tableModel.setValueAt(ageField.getText(),selectedRow,2);
                tableModel.setValueAt(genderField.getText(),selectedRow,3);
            }
        }
    }

    public static void main(String[] args){
        new StudentManagementSystem();
    }
}