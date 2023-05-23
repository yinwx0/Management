package frame;

import factory.Factory;
import model.SC;
import model.Stu;
import panel.ManagePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class ManageFrame extends JFrame{
    public ManageFrame(){
        setTitle("management");
        setVisible(true);
        setBounds(500,100,620,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ManagePanel managePanel = new ManagePanel();
        getContentPane().add(managePanel);
        managePanel.setVisible(true);
        managePanel.getSelect().addActionListener(e->{
            switch(managePanel.getJComboBox1().getSelectedIndex()){
                case 0 -> {
                    try{
                        managePanel.getJTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().selectAllStu(
                                                new Stu(
                                                        managePanel.id(),
                                                        managePanel.sno(),
                                                        managePanel.name(),
                                                        managePanel.sex()
                                                )
                                        ),
                                        managePanel.getTitle3()
                                )
                        );
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getJTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().selectAllStuAllCourseScore(
                                                new SC(
                                                        managePanel.sno(),
                                                        managePanel.cno(),
                                                        managePanel.score()
                                                )
                                        ),
                                        managePanel.getTitle1()
                                )
                        );
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getInsert().addActionListener(e->{
            switch(managePanel.getJComboBox2().getSelectedIndex()){
                case 0 -> {
                    if(
                            !(
                                    ManagePanel.verifyIdCardCheckCode(
                                            managePanel.id()) &&
                                            (managePanel.sex().equals("男") ||
                                                    managePanel.sex().equals("女")
                                            )
                            )
                    ){
                        JOptionPane.showMessageDialog(null,"invalid input");
                    }else{
                        try{
                            Factory.Serv().insertStu(
                                    new Stu(
                                            managePanel.id(),
                                            managePanel.sno(),
                                            managePanel.name(),
                                            managePanel.sex()
                                    ));
                            managePanel.getJScrollPane().repaint();
                        }catch(SQLException ex){
                            throw new RuntimeException(ex);
                        }
                    }
                }
                case 1 -> {
                    try{
                        Factory.Serv().insertScore(
                                new SC(
                                        managePanel.sno(),
                                        managePanel.cno(),
                                        managePanel.score()
                                ));
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getModify().addActionListener(e->{
            switch(managePanel.getJComboBox3().getSelectedIndex()){
                case 0 -> {
                    if(!(ManagePanel.verifyIdCardCheckCode(managePanel.id()) && (managePanel.sex().equals("男") || managePanel.sex().equals("女")))){
                        JOptionPane.showMessageDialog(null,"invalid input");
                    }else{
                        if(managePanel.sno() != null){
                            try{
                                Factory.Serv().modifyStu(
                                        new Stu(
                                                managePanel.id(),
                                                managePanel.sno(),
                                                managePanel.name(),
                                                managePanel.sex()
                                        )
                                );
                            }catch(SQLException ex){
                                throw new RuntimeException(ex);
                            }
                        }
                        managePanel.getJScrollPane().repaint();
                    }
                }
                case 1 -> {
                    if(
                            managePanel.sno() != null &&
                                    managePanel.cno() != null &&
                                    managePanel.score() != null){
                        try{
                            Factory.Serv().modifySC(
                                    new SC(
                                            managePanel.sno(),
                                            managePanel.cno(),
                                            managePanel.score()
                                    )
                            );
                        }catch(SQLException ex){
                            throw new RuntimeException(ex);
                        }
                    }
                    managePanel.getJScrollPane().repaint();
                }
            }
        });
        managePanel.getDelete().addActionListener(e->{
            switch(managePanel.getJComboBox4().getSelectedIndex()){
                case 0 -> {
                    if(!(managePanel.sex().equals("男") || managePanel.sex().equals("女"))){
                        JOptionPane.showMessageDialog(null,"invalid input");
                    }else{
                        if(
                                managePanel.id().equals("") &&
                                        managePanel.sno().equals("") &&
                                        managePanel.name().equals("") &&
                                        managePanel.sex().equals("")
                        ){
                            JOptionPane.showMessageDialog(null,"null input");
                        }else{
                            try{
                                Factory.Serv().deleteStu(
                                        new Stu(
                                                managePanel.id(),
                                                managePanel.sno(),
                                                managePanel.name(),
                                                managePanel.sex()
                                        )
                                );
                                JOptionPane.showMessageDialog(this,"OK");
                            }catch(SQLException ex){
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
                case 1 -> {
                    try{
                        if(!managePanel.sno().equals("") || managePanel.cno() != null){
                            Factory.Serv().deleteScore(
                                    new SC(
                                            managePanel.sno(),
                                            managePanel.cno()
                                    )
                            );
                        }
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getSort().addActionListener(e->{
            switch(managePanel.getJComboBox5().getSelectedIndex()){
                case 0 -> {
                    try{
                        managePanel.getJTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().sortAllStuAllScore(
                                                new SC(
                                                        managePanel.sno(),
                                                        managePanel.cno(),
                                                        managePanel.score()
                                                )
                                        ),
                                        managePanel.getTitle4()
                                )
                        );
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getJTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().sortCourseAllStuScore(
                                                new SC(
                                                        managePanel.sno(),
                                                        managePanel.cno(),
                                                        managePanel.score()
                                                )
                                        ),
                                        managePanel.getTitle1()
                                )
                        );
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getAvg().addActionListener(e->{
            switch(managePanel.getJComboBox6().getSelectedIndex()){
                case 0 -> {
                    try{
                        if(managePanel.cno() != null){
                            managePanel.getJTable().setModel(
                                    new DefaultTableModel(
                                            Factory.Serv().selectAllCourseAvgScore(
                                                    new SC(
                                                            managePanel.cno()
                                                    )
                                            ),
                                            managePanel.getTitle5()
                                    )
                            );
                            managePanel.getJScrollPane().repaint();
                        }
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getJTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().selectAllCourseAvgScore(
                                                new SC(
                                                        managePanel.sno(),
                                                        managePanel.cno(),
                                                        managePanel.score()
                                                )
                                        ),
                                        managePanel.getTitle2()
                                )
                        );
                        managePanel.getJScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getAll().addActionListener(e->{
            try{
                managePanel.getJTable().setModel(
                        new DefaultTableModel(
                                Factory.Serv().selectAllStuAllScore(
                                        new SC(
                                                managePanel.sno(),
                                                managePanel.cno(),
                                                managePanel.score()
                                        )
                                ),
                                managePanel.getTitle4()
                        )
                );
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
            managePanel.getJScrollPane().repaint();
        });
        managePanel.getCls().addActionListener(e->{
            managePanel.getSn().setText("");
            managePanel.getCn().setText("");
            managePanel.getSt().setText("");
            managePanel.getIdt().setText("");
            managePanel.getSon().setText("");
            managePanel.getNat().setText("");
            managePanel.getJTable().setModel(new DefaultTableModel());
            managePanel.getJScrollPane().repaint();
        });
    }
}
