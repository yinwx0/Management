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
        setBounds(500,100,600,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ManagePanel managePanel = new ManagePanel();
        getContentPane().add(managePanel);
        managePanel.setVisible(true);
        managePanel.getSelect().addActionListener(e->{
            switch(managePanel.getjComboBox1().getSelectedIndex()){
                case 0 -> {
                    try{
                        managePanel.getjTable().setModel(
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
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getjTable().setModel(
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
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getInsert().addActionListener(e->{
            switch(managePanel.getjComboBox2().getSelectedIndex()){
                case 0 -> {
                    try{
                        Factory.Serv().insertStu(
                                new Stu(
                                        managePanel.id(),
                                        managePanel.sno(),
                                        managePanel.name(),
                                        managePanel.sex()
                                ));
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
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
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getModify().addActionListener(e->{
            switch(managePanel.getjComboBox3().getSelectedIndex()){
                case 0 -> {
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
                    managePanel.getjScrollPane().repaint();
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
                    managePanel.getjScrollPane().repaint();
                }
            }
        });
        managePanel.getDelete().addActionListener(e->{
            switch(managePanel.getjComboBox4().getSelectedIndex()){
                case 0 -> {
                    managePanel.getjScrollPane().repaint();
                }
                case 1 -> {
                    managePanel.getjScrollPane().repaint();
                }
            }
        });
        managePanel.getSort().addActionListener(e->{
            switch(managePanel.getjComboBox5().getSelectedIndex()){
                case 0 -> {
                    try{
                        managePanel.getjTable().setModel(
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
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getjTable().setModel(
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
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getAvg().addActionListener(e->{
            switch(managePanel.getjComboBox6().getSelectedIndex()){
                case 0 -> {
                    try{
                        if(managePanel.cno() != null){
                            managePanel.getjTable().setModel(
                                    new DefaultTableModel(
                                            Factory.Serv().selectAllCourseAvgScore(
                                                    new SC(
                                                            managePanel.cno()
                                                    )
                                            ),
                                            managePanel.getTitle2()
                                    )
                            );
                            managePanel.getjScrollPane().repaint();
                        }
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
                case 1 -> {
                    try{
                        managePanel.getjTable().setModel(
                                new DefaultTableModel(
                                        Factory.Serv().selectAllCourseAvgScore(
                                                new SC()
                                        ),
                                        managePanel.getTitle2()
                                )
                        );
                        managePanel.getjScrollPane().repaint();
                    }catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        managePanel.getAll().addActionListener(e->{
            try{
                managePanel.getjTable().setModel(
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
            managePanel.getjScrollPane().repaint();
        });
        managePanel.getCls().addActionListener(e -> {
            managePanel.getSn().setText("");
            managePanel.getCn().setText("");
            managePanel.getSt().setText("");
            managePanel.getIdt().setText("");
            managePanel.getSon().setText("");
            managePanel.getNat().setText("");
        });
    }
}
