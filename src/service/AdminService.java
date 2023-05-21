package service;

import factory.Factory;
import model.Admin;
import model.SC;
import model.Stu;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Zhai Jinpei
 */
public class AdminService implements AdminServiceDAO{

    public boolean checkLogin(Admin admin) throws SQLException{
        return admin.getAno() != null && admin.getPassword() != null && adminDAO.select(
                "select *from admin where ano = ? and password = ?",
                admin.getAno(),
                admin.getPassword()
        ).next();
    }

    /**
     * select * from stu
     */
    @Override
    public Object[][] selectAllStu(Stu stu) throws SQLException{
        if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu")
            ){
                Object[][] objects = new Object[100][4];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("ca");
                    objects[i][1] = resultSet.getString("sno");
                    objects[i][2] = resultSet.getString("name");
                    objects[i++][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ?",
                            stu.getSno()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where ca = ?",
                            stu.getCA()
                    )
            ){
                Object[][] objects = new Object[50][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where name = ?",
                            stu.getName()
                    )
            ){
                Object[][] objects = new Object[100][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sex = ?",
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[100][4];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("ca");
                    objects[i][1] = resultSet.getString("sno");
                    objects[i][2] = resultSet.getString("name");
                    objects[i++][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and ca = ?",
                            stu.getSno(),
                            stu.getCA()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where name = ? and ca = ?",
                            stu.getName(),
                            stu.getCA()
                    )
            ){
                Object[][] objects = new Object[50][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCA(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where name = ? and sex = ?",
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and name = ?",
                            stu.getSno(),
                            stu.getName()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getCA(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and sex = ?",
                            stu.getSno(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sex = ? and ca = ?",
                            stu.getSex(),
                            stu.getCA()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSno(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(" select * from stu where ca = ? and name = ? and sex = ?",
                            stu.getCA(),
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and ca = ? and sex = ?",
                            stu.getSno(),
                            stu.getCA(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getCA(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and name = ? and sex = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else if(
                Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and name = ? and ca = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getCA()
                    )
            ){
                Object[][] objects = new Object[1][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }else{
            try(
                    ResultSet resultSet = adminDAO.select(
                            " select * from stu where sno = ? and name = ? and ca = ? and  sex = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getCA(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[10][4];
                while(resultSet.next()){
                    objects[0][0] = resultSet.getString("ca");
                    objects[0][1] = resultSet.getString("sno");
                    objects[0][2] = resultSet.getString("name");
                    objects[0][3] = resultSet.getString("sex");
                }
                return objects;
            }
        }
    }


    /**
     * select * from s_c
     */
    @Override
    public Object[][] selectAllStuAllCourseScore(SC sc) throws SQLException{
        if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null &&
                        sc.getScore() == null
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c"
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getScore() == null){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where cno = ?",
                            sc.getCno()
                    );
                    ResultSet resultSet1 = adminDAO.select(
                            "select count(*) from s_c where cno = ?",
                            sc.getCno()
                    )
            ){
                int l = 0;
                while(resultSet1.next()) l = resultSet1.getInt(1);
                Object[][] objects = new Object[l][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where score = ?",
                            sc.getScore()
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                sc.getScore() == null &&
                        sc.getCno() == null){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where sno = ?",
                            sc.getSno()

                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                Objects.equals(sc.getSno(),"")
        ){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where cno = ? and score = ?",
                            sc.getCno(),
                            sc.getScore()
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                sc.getCno() == null){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where sno = ? and score = ?",
                            sc.getSno(),
                            sc.getScore()
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                sc.getScore() == null){
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where sno = ? and cno = ?",
                            sc.getSno(),
                            sc.getCno()
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else{
            try(
                    ResultSet resultSet = adminDAO.select(
                            "select * from s_c where sno = ? and cno = ? and score = ?",
                            sc.getSno(),
                            sc.getCno(),
                            sc.getScore()
                    )
            ){
                Object[][] objects = new Object[1000][3];
                int i = 0;
                while(resultSet.next()){
                    objects[i][0] = resultSet.getString("sno");
                    objects[i][1] = resultSet.getString("cno");
                    objects[i++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }
    }

    /**
     * 先初始化一个String数组来存所有的 selectAllStu()的数组索引1,遍历该String数组 每次 调用selectStuAllScoreBySno（）
     */
    @Override
    public Object[][] selectAllStuAllScore(SC sc) throws SQLException{
        ResultSet resultSet = adminDAO.select("select sno from stu");
        ResultSet resultSet1 = adminDAO.select("select count(*) from stu");
        int c = 0;
        while(resultSet1.next()) c = resultSet1.getInt(1);
        Object[] r = new Object[c];
        int i = 0;
        while(resultSet.next())
            r[i++] = resultSet.getString("sno");
        resultSet.close();
        resultSet1.close();
        if(
                sc.getSno().equals("")
        ){
            Object[][] objects = new Object[c][2];
            int q = 0;
            for(Object o: r){
                ResultSet resultSet2 = adminDAO.select(
                        "select score from s_c where sno = ?",
                        o
                );
                double p = 0;
                while(resultSet2.next()){
                    p += resultSet2.getDouble("score");
                }
                objects[q][0] = o;
                objects[q++][1] = p;
            }
            return objects;
        }else{
            Object[][] objects = new Object[1][2];
            ResultSet resultSet3 = adminDAO.select(
                    "select score from s_c where sno = ?",
                    sc.getSno()
            );
            double p = 0;
            while(resultSet3.next()){
                p += resultSet3.getDouble("score");
            }
            objects[0][0] = sc.getSno();
            objects[0][1] = p;
            return objects;
        }
    }

    /**
     * 遍历cou，初始化object长度为15，object[i][1]=selectCourseAvgScoreByCno()的数组索引1
     */
    @Override
    public Object[][] selectAllCourseAvgScore(SC sc) throws SQLException{
        ResultSet resultSet = adminDAO.select("select cno from cou");
        ResultSet resultSet1 = adminDAO.select("select count(*) from cou");
        int i = 0;
        while(resultSet1.next()) i = resultSet1.getInt(1);
        Object[] objects = new Object[i];
        int j = 0;
        while(resultSet.next()) objects[j++] = resultSet.getString("cno");
        resultSet1.close();
        resultSet.close();
        if(sc.getCno() == null){
            Object[][] objects1 = new Object[i][2];
            int i1 = 0;
            for(Object o: objects){
                ResultSet resultSet2 = adminDAO.select(
                        "select count(*) from s_c where cno = ?",
                        o
                );
                int c = 0;
                while(resultSet2.next()) c = resultSet2.getInt(1);
                resultSet2.close();
                ResultSet resultset3 = adminDAO.select(
                        "select score from s_c where cno = ?",
                        o
                );
                double k = 0;
                while(resultset3.next()){
                    k += resultset3.getDouble("score");
                }
                resultset3.close();
                k /= c;
                objects1[i1][0] = o;
                objects1[i1++][1] = k;
            }
            return objects1;
        }else{
            Object[][] objects1 = new Object[1][2];
            ResultSet resultSet2 = adminDAO.select(
                    "select count(*) from s_c where cno = ?",
                    sc.getCno()
            );
            int c = 0;
            while(resultSet2.next()) c = resultSet2.getInt(1);
            resultSet2.close();
            ResultSet resultset3 = adminDAO.select(
                    "select score from s_c where cno = ?",
                    sc.getCno()
            );
            double k = 0;
            while(resultset3.next()){
                k += resultset3.getDouble("score");
            }
            resultset3.close();
            k /= c;
            objects1[0][0] = sc.getCno();
            objects1[0][1] = k;
            return objects1;
        }
    }

    /**
     * 调用selectAllStuAllScore()的数组
     */
    @Override
    public Object[][] sortAllStuAllScore(SC sc) throws SQLException{
        Object[][] objects = Factory.Serv().selectAllStuAllScore(new SC(""));
        for(int i = 0;i < objects.length - 1;i++){
            for(int j = i + 1;j < objects.length ;j++){
                if((Double)objects[i][1] < (Double)objects[j][1]){
                    double t = (Double)objects[i][1];
                    objects[i][1] = objects[j][1];
                    objects[j][1] = t;
                }
            }
        }
        return objects;
    }

    /**
     * 调用 selectCourseAllStuScoreByCno（）
     */
    @Override
    public Object[][] sortCourseAllStuScore(SC sc) throws SQLException{
        if(sc.getCno() != null){
            Object[][] objects = Factory.Serv().selectAllStuAllCourseScore(sc);
            for(int i = 0;i < objects.length - 1;i++){
                for(int j = i + 1;j < objects.length ;j++){
                    if((Double)objects[i][2] < (Double)objects[j][2]){
                        Object t = objects[i][2];
                        objects[i][2] = objects[j][2];
                        objects[j][2] = t;
                    }
                }
            }
            return objects;
        }else{
            return new Object[1][3];
        }
    }


    /**
     * insert into stu values(?,?,?,?)
     */
    @Override
    public void insertStu(Stu stu) throws SQLException{
        ResultSet resultSet = adminDAO.select(
                "select sno from stu where sno = ? ",
                stu.getSno()
        );
        boolean f = resultSet.next();
        if(
                !f &&
                        !stu.getSno().equals("") &&
                        !stu.getName().equals("") &&
                        !stu.getSex().equals("") &&
                        !stu.getCA().equals("")
        ){
            int i = Factory.AdminImpl().insert(
                    "insert into stu(ca,sno,name,sex) values(?,?,?,?)",
                    stu.getCA(),
                    stu.getSno(),
                    stu.getName(),
                    stu.getSex()
            );
            if(i > 0)
                JOptionPane.showMessageDialog(null,"success");
        }else
            JOptionPane.showMessageDialog(null,"failed");
    }

    /**
     * insert into s_c values(?,?,?)
     */
    @Override
    public void insertScore(SC sc) throws SQLException{
        ResultSet resultSet = adminDAO.select(
                "select sno,cno from s_c where sno = ? and cno = ?",
                sc.getSno(),
                sc.getCno()
        );
        boolean f = resultSet.next();
        if(
                !f &&
                        !sc.getSno().equals("") &&
                        sc.getCno() != null &&
                        sc.getScore() != null
        ){
            int i = adminDAO.insert(
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

    /**
     * update stu set id = ? where sno = ?
     */
    @Override
    public void modifyStu(Stu stu) throws SQLException{
        ResultSet resultSet = adminDAO.select(
                "select sno fom stu where sno = ?",
                stu.getSno()
        );
        if(
                resultSet.next() &&!(
                        stu.getCA().equals("") &&
                        stu.getName().equals("") &&
                        stu.getSex().equals("")
        )){
            resultSet.close();
            if(
                    stu.getCA().equals("") &&
                            stu.getName().equals("")
            ){
                adminDAO.modify(
                        "update stu set sex = ? where sno = ?",
                        stu.getSex(),
                        stu.getSno()
                );
            }else if(
                    stu.getCA().equals("") &&
                            stu.getSex().equals("")
            ){
                adminDAO.modify(
                        "update stu set name = ? where sno = ?",
                        stu.getName(),
                        stu.getSno()
                );
            }else if(
                    stu.getCA().equals("")
            ){
                adminDAO.modify(
                        "update stu set sex = ?,name = ? where sno = ?",
                        stu.getSex(),
                        stu.getName(),
                        stu.getSno()
                );
            }else if(
                    stu.getName().equals("")
            ){
                adminDAO.modify(
                        "update stu set sex = ?,ca = ? where sno = ?",
                        stu.getSex(),
                        stu.getCA(),
                        stu.getSno()
                );
            }else if(
                    stu.getSex().equals("")
            ){
                adminDAO.modify(
                        "update stu set ca = ?,name = ? where sno = ?",
                        stu.getCA(),
                        stu.getName(),
                        stu.getSno()
                );
            }
            JOptionPane.showMessageDialog(null,"success");
        }else{
            JOptionPane.showMessageDialog(null,"failed");
        }
    }


    /**
     * update s_c set sno = ? ,cno = ? ,score = ? where sno = ? and cno = ?
     */
    @Override
    public void modifySC(SC sc) throws SQLException{
        ResultSet resultSet = adminDAO.select(
                "select sno,cno from s_c where sno = ? and cno = ?",
                sc.getSno(),
                sc.getCno()
        );
        if(resultSet.next()){
            resultSet.close();
            adminDAO.modify(
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

    /**
     * delete from stu where sno = ?
     */
    @Override
    public void deleteStu(Stu stu) throws SQLException{
        adminDAO.delete("delete from stu where sno = ?",stu.getSno());
        adminDAO.delete("delete from s_c where sno = ?",stu.getSno());
        JOptionPane.showMessageDialog(null,"OK");
    }

    /**
     * delete from s_c where sno = ? and cno = ?
     */
    @Override
    public void deleteScore(SC sc) throws SQLException{
      if(sc.getCno()==null&&!sc.getSno().equals("")){
            adminDAO.delete("delete from s_c where sno = ?",sc.getSno());
        }else if(sc.getSno()==null&&sc.getCno()!=null){
            adminDAO.delete("delete from s_c where cno = ?",sc.getCno());
        }else {
            JOptionPane.showMessageDialog(null,"null input");
        }
    }

}
