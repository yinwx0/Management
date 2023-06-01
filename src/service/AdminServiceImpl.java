package service;

import dao.impl.AdminDAOImpl;
import factory.Factory;
import model.Admin;
import model.SC;
import model.Stu;
import panel.ManagePanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhai Jinpei
 */
@SuppressWarnings("all")
public class AdminServiceImpl implements AdminService{
    private Lock lock = new ReentrantLock();
    AdminDAOImpl adminDAO = Factory.adminImpl();
    AdminDAOImpl stuDAO = Factory.stuImpl();
    AdminDAOImpl scDAO = Factory.scImpl();
    AdminDAOImpl couDAO = Factory.couImpl();

    public AdminServiceImpl() throws SQLException{
    }

    public boolean checkLogin(Admin admin) throws SQLException{
        Object[][] a = adminDAO.select(
                "select * from admin where ano = ? and password = ?",
                admin.getAno(),
                admin.getPassword());
        return admin.getAno() != null && admin.getPassword() != null && a.length > 0;
    }

    @Override
    public Object[][] selectAllStu(Stu stu) throws SQLException{
        if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(" select * from stu");
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ?",
                    stu.getSno()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where ca = ?",
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where name = ?",
                    stu.getName()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sex = ?",
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and ca = ?",
                    stu.getSno(),
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where name = ? and ca = ?",
                    stu.getName(),
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"")
        ){
            return stuDAO.select(
                    " select * from stu where name = ? and sex = ?",
                    stu.getName(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and name = ?",
                    stu.getSno(),
                    stu.getName()
            );
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and sex = ?",
                    stu.getSno(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sex = ? and ca = ?",
                    stu.getSex(),
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"")
        ){
            return stuDAO.select(" select * from stu where ca = ? and name = ? and sex = ?",
                    stu.getCa(),
                    stu.getName(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getName(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and ca = ? and sex = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getCa(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and name = ? and sex = ?",
                    stu.getSno(),
                    stu.getName(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getSex(),"")
        ){
            return stuDAO.select(
                    " select * from stu where sno = ? and name = ? and ca = ?",
                    stu.getSno(),
                    stu.getName(),
                    stu.getCa()
            );
        }else{
            return stuDAO.select(
                    " select * from stu where sno = ? and name = ? and ca = ? and  sex = ?",
                    stu.getSno(),
                    stu.getName(),
                    stu.getCa(),
                    stu.getSex()
            );
        }
    }

    @Override
    public Object[][] selectAllStuAllCourseScore(SC sc) throws SQLException{
        if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null &&
                        sc.getScore() == null
        ){
            return scDAO.select(
                    "select * from s_c"
            );
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getScore() == null){
            return scDAO.select(
                    "select * from s_c where cno = ?",
                    sc.getCno()
            );
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null){
            return scDAO.select(
                    "select * from s_c where score = ?",
                    sc.getScore()
            );
        }else if(
                sc.getScore() == null &&
                        sc.getCno() == null){
            return scDAO.select(
                    "select * from s_c where sno = ?",
                    sc.getSno()
            );
        }else if(
                Objects.equals(sc.getSno(),"")
        ){
            return scDAO.select(
                    "select * from s_c where cno = ? and score = ?",
                    sc.getCno(),
                    sc.getScore()
            );
        }else if(
                sc.getCno() == null){
            return scDAO.select(
                    "select * from s_c where sno = ? and score = ?",
                    sc.getSno(),
                    sc.getScore()
            );
        }else if(
                sc.getScore() == null){
            return scDAO.select(
                    "select * from s_c where sno = ? and cno = ?",
                    sc.getSno(),
                    sc.getCno()
            );
        }else{
            return scDAO.select(
                    "select * from s_c where sno = ? and cno = ? and score = ?",
                    sc.getSno(),
                    sc.getCno(),
                    sc.getScore()
            );
        }
    }

    private Object[][] getScObjects(ResultSet resultSet) throws SQLException{
        Object[][] objects = new Object[1000][3];
        int i = 0;
        while(resultSet.next()){
            objects[i][0] = resultSet.getString("sno");
            objects[i][1] = resultSet.getString("cno");
            objects[i++][2] = resultSet.getDouble("score");
        }
        return objects;
    }

    @Override
    public Object[][] selectAllStuAllScore(SC sc) throws SQLException{
        Object[][] objects = scDAO.select("select sno from stu");
        Object[][] objects1 = new Object[1][2];
        if(
                sc.getSno().equals("") && objects.length >= 1
        ){
            objects1 = new Object[objects.length][2];
            int q = 0;
            for(Object[] o: objects){
                objects1[q][0] = o[0];
                Object[][] o1 = scDAO.select(
                        "select score from s_c where sno = ?",
                        o[0]
                );
                double c = 0;
                if(o1 != null){
                    for(Object[] objects2: o1) c += (double)objects2[0];
                    objects1[q][1] = c;
                }
                q++;
            }
        }else{
            Object[][] o1 = scDAO.select(
                    "select score from s_c where sno = ?",
                    sc.getSno()
            );
            objects1[0][0] = sc.getSno();
            double c = 0;
            for(Object[] objects2: o1) c += (double)objects2[0];
            objects1[0][1] = c;
        }
        return objects1;
    }

    @Override
    public Object[][] selectAllCourseAvgScore(SC sc) throws SQLException{
        Object[][] objects = scDAO.select("select cno from cou");
        int i = objects.length;
        Object[][] objects1 = new Object[i][2];
        if(sc.getCno() == null){
            int k = 0;
            for(Object[] o: objects){
                objects1[k][0] = o[0];
                Object[][] objects2 = scDAO.select(
                        "select score from s_c where cno = ?",
                        o[0]
                );
                double s = 0d;
                if(objects2 != null){
                    for(Object[] objects3: objects2){
                        s += (double)objects3[0];
                    }
                    s /= objects2.length;
                    objects1[k++][1] = s;
                }
            }
        }else{
            Object[][] objects2 = scDAO.select(
                    "select score from s_c where cno = ?",
                    sc.getCno()
            );
            double s = 0d;
            objects1[0][0] = sc.getCno();
            if(objects2 != null){
                for(Object[] objects3: objects2){
                    s += (double)objects3[0];
                }
                s /= objects2.length;

                objects1[0][1] = s;
            }
        }
        return objects1;
    }

    @Override
    public Object[][] sortAllStuAllScore(SC sc) throws SQLException{
        Object[][] objects = selectAllStuAllScore(sc);
        O:
        for(int i = 0;i < objects.length - 1;i++){
            if(objects[i][1] == null) continue O;
            I:
            for(int j = i + 1;j < objects.length;j++){
                if(objects[j][1] == null) continue I;
                if((Double)objects[i][1] < (Double)objects[j][1]){
                    double t = (Double)objects[i][1];
                    objects[i][1] = objects[j][1];
                    objects[j][1] = t;
                }
            }
        }
        return objects;
    }

    @Override
    public Object[][] sortCourseAllStuScore(SC sc) throws SQLException{
        if(sc.getCno() != null){
            Object[][] objects = selectAllStuAllCourseScore(sc);
            if(objects != null){
                for(int i = 0;i < objects.length - 1;i++){
                    for(int j = i + 1;j < objects.length;j++){
                        if((Double)objects[i][2] < (Double)objects[j][2]){
                            Object t = objects[i][2];
                            objects[i][2] = objects[j][2];
                            objects[j][2] = t;
                        }
                    }
                }
            }
            return objects;
        }else{
            return new Object[1][3];
        }
    }

    @Override
    public void insertStu(Stu stu) throws SQLException{
        Object[][] objects = stuDAO.select(
                "select sno from stu where sno = ? ",
                stu.getSno()
        );
        boolean f = objects != null && objects.length > 0;
        if(
                !f &&
                        !stu.getSno().equals("") &&
                        !stu.getName().equals("") &&
                        !stu.getSex().equals("") &&
                        !stu.getCa().equals("")
        ){
            int i = stuDAO.insert(
                    "insert into stu(ca,sno,name,sex) values(?,?,?,?)",
                    stu.getCa(),
                    stu.getSno(),
                    stu.getName(),
                    stu.getSex()
            );
            if(i > 0)
                JOptionPane.showMessageDialog(null,"success");
        }else
            JOptionPane.showMessageDialog(null,"failed");
    }

    @Override
    public void insertScore(SC sc) throws SQLException{
        Object[][] objects = scDAO.select(
                "select sno,cno from s_c where sno = ? and cno = ?",
                sc.getSno(),
                sc.getCno()
        );
        boolean f = objects != null && objects.length > 0;
        if(
                !f &&
                        !sc.getSno().equals("") &&
                        sc.getCno() != null &&
                        sc.getScore() != null
        ){
            int i = scDAO.insert(
                    "insert into s_c (sno,cno,score) values(?,?,?)",
                    sc.getSno(),
                    sc.getCno(),
                    sc.getScore()
            );
            if(i > 0)
                JOptionPane.showMessageDialog(null,"success");
        }else
            JOptionPane.showMessageDialog(null,"failed");
    }

    @Override
    public void modifyStu(Stu stu) throws SQLException{
        if(!(stu.getCa().equals("") || stu.getSex().equals(""))){
            if(!(ManagePanel.verifyIdCardCheckCode(stu.getCa()) && (stu.getSex().equals("男") || stu.getSex().equals("女")))){
                JOptionPane.showMessageDialog(null,"invalid input");
                return;
            }
        }
        Object[][] objects = stuDAO.select(
                "select sno from stu where sno = ?",
                stu.getSno()
        );
        if(
                objects != null && objects.length > 0 && !(
                        stu.getCa().equals("") &&
                                stu.getName().equals("") &&
                                stu.getSex().equals("")
                )){
            if(
                    stu.getCa().equals("") &&
                            stu.getName().equals("")
            ){
                stuDAO.modify(
                        "update stu set sex = ? where sno = ?",
                        stu.getSex(),
                        stu.getSno()
                );
            }else if(
                    stu.getCa().equals("") &&
                            stu.getSex().equals("")
            ){
                stuDAO.modify(
                        "update stu set name = ? where sno = ?",
                        stu.getName(),
                        stu.getSno()
                );
            }else if(
                    stu.getCa().equals("")
            ){
                stuDAO.modify(
                        "update stu set sex = ?,name = ? where sno = ?",
                        stu.getSex(),
                        stu.getName(),
                        stu.getSno()
                );
            }else if(
                    stu.getName().equals("")
            ){
                stuDAO.modify(
                        "update stu set sex = ?,ca = ? where sno = ?",
                        stu.getSex(),
                        stu.getCa(),
                        stu.getSno()
                );
            }else if(
                    stu.getSex().equals("")
            ){
                stuDAO.modify(
                        "update stu set ca = ?,name = ? where sno = ?",
                        stu.getCa(),
                        stu.getName(),
                        stu.getSno()
                );
            }
            JOptionPane.showMessageDialog(null,"success");
        }else{
            JOptionPane.showMessageDialog(null,"failed");
        }
    }

    @Override
    public void modifySC(SC sc) throws SQLException{
        Object[][] objects = scDAO.select(
                "select sno,cno from s_c where sno = ? and cno = ?",
                sc.getSno(),
                sc.getCno()
        );
        if(objects != null && objects.length > 0){
            scDAO.modify(
                    "update s_c set score = ? where sno = ? and cno = ?",
                    sc.getScore(),
                    sc.getSno(),
                    sc.getCno()
            );
            JOptionPane.showMessageDialog(null,"success");
        }else{
            JOptionPane.showMessageDialog(null,"failed");
        }
    }

    @Override
    public void deleteStu(Stu stu) throws SQLException{
        if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ?",
                    stu.getSno()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where ca = ?",
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ?",
                    stu.getName()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sex = ?"
            );
        }else if(
                Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and ca = ?",
                    stu.getSno(),
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ? and ca = ?",
                    stu.getName(),
                    stu.getCa()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ? and sex = ?",
                    stu.getName(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and name = ?",
                    stu.getSno(),
                    stu.getName()
            );
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")){
            stuDAO.delete(
                    "delete from stu where sno = ? and sex = ?",
                    stu.getSno(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where ca = ? and sex = ?",
                    stu.getCa(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getSno(),"")
        ){
            stuDAO.delete(
                    "delete from stu where ca = ? and name = ? and sex = ?",
                    stu.getCa(),
                    stu.getName(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and ca = ? and sex = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getSex()
            );
        }else if(
                Objects.equals(stu.getCa(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and sex = ? and name = ?",
                    stu.getSno(),
                    stu.getSex(),
                    stu.getName()
            );
        }else if(
                Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and ca = ? and name = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getName()
            );
        }else{
            stuDAO.delete(
                    "delete from stu where sno = ? and ca = ? and name = ? and sex = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getName(),
                    stu.getSex()
            );
        }
    }

    @Override
    public void deleteScore(SC sc) throws SQLException{
        if(sc.getCno() == null && !sc.getSno().equals("")){
            scDAO.delete("delete from s_c where sno = ?",sc.getSno());
            JOptionPane.showMessageDialog(null,"OK");
        }else if(sc.getSno() == null && sc.getCno() != null){
            scDAO.delete("delete from s_c where cno = ?",sc.getCno());
            JOptionPane.showMessageDialog(null,"OK");
        }else if(sc.getCno() != null && !sc.getSno().equals("")){
            scDAO.delete("delete from s_c where cno = ? and sno = ?",sc.getCno(),sc.getSno());
            JOptionPane.showMessageDialog(null,"OK");
        }else{
            JOptionPane.showMessageDialog(null,"null input");
        }
    }
}
