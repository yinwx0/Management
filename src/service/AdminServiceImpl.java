package service;

import model.Admin;
import model.SC;
import model.Stu;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author Zhai Jinpei
 */
@SuppressWarnings("all")
public class AdminServiceImpl implements AdminService{

    public boolean checkLogin(@NotNull Admin admin) throws SQLException{
        return admin.getAno() != null && admin.getPassword() != null && adminDAO.select(
                "select *from admin where ano = ? and password = ?",
                admin.getAno(),
                admin.getPassword()
        ).next();
    }

    @Override
    public Object[][] selectAllStu(@NotNull Stu stu) throws SQLException{
        if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu")
            ){
                Object[][] objects = new Object[100][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ?",
                            stu.getSno()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where Ca = ?",
                            stu.getCa()
                    )
            ){
                Object[][] objects = new Object[50][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where name = ?",
                            stu.getName()
                    )
            ){
                Object[][] objects = new Object[100][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sex = ?",
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[100][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and Ca = ?",
                            stu.getSno(),
                            stu.getCa()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where name = ? and Ca = ?",
                            stu.getName(),
                            stu.getCa()
                    )
            ){
                Object[][] objects = new Object[50][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where name = ? and sex = ?",
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and name = ?",
                            stu.getSno(),
                            stu.getName()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and sex = ?",
                            stu.getSno(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sex = ? and Ca = ?",
                            stu.getSex(),
                            stu.getCa()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSno(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(" select * from stu where Ca = ? and name = ? and sex = ?",
                            stu.getCa(),
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getName(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and Ca = ? and sex = ?",
                            stu.getSno(),
                            stu.getCa(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getCa(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and name = ? and sex = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else if(
                Objects.equals(stu.getSex(),"")
        ){
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and name = ? and Ca = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getCa()
                    )
            ){
                Object[][] objects = new Object[1][4];
                return getStuObjects(resultSet,objects);
            }
        }else{
            try(
                    ResultSet resultSet = stuDAO.select(
                            " select * from stu where sno = ? and name = ? and Ca = ? and  sex = ?",
                            stu.getSno(),
                            stu.getName(),
                            stu.getCa(),
                            stu.getSex()
                    )
            ){
                Object[][] objects = new Object[10][4];
                return getStuObjects(resultSet,objects);
            }
        }
    }

    private Object[][] getStuObjects(ResultSet resultSet,Object[][] objects) throws SQLException{
        int i = 0;
        while(resultSet.next()){
            objects[i][0] = resultSet.getString("Ca");
            objects[i][1] = resultSet.getString("sno");
            objects[i][2] = resultSet.getString("name");
            objects[i++][3] = resultSet.getString("sex");
        }
        return objects;
    }

    @Override
    public Object[][] selectAllStuAllCourseScore(SC sc) throws SQLException{
        if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null &&
                        sc.getScore() == null
        ){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c"
                    )
            ){
                return getScObjects(resultSet);
            }
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getScore() == null){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where cno = ?",
                            sc.getCno()
                    );
                    ResultSet resultSet1 = scDAO.select(
                            "select count(*) from s_c where cno = ?",
                            sc.getCno()
                    )
            ){
                int l = 0;
                while(resultSet1.next()) l = resultSet1.getInt(1);
                Object[][] objects = new Object[l][3];
                int j = 0;
                while(resultSet.next()){
                    objects[j][0] = resultSet.getString("sno");
                    objects[j][1] = resultSet.getString("cno");
                    objects[j++][2] = resultSet.getDouble("score");
                }
                return objects;
            }
        }else if(
                Objects.equals(sc.getSno(),"") &&
                        sc.getCno() == null){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where score = ?",
                            sc.getScore()
                    )
            ){
                return getScObjects(resultSet);
            }
        }else if(
                sc.getScore() == null &&
                        sc.getCno() == null){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where sno = ?",
                            sc.getSno()

                    )
            ){
                return getScObjects(resultSet);
            }
        }else if(
                Objects.equals(sc.getSno(),"")
        ){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where cno = ? and score = ?",
                            sc.getCno(),
                            sc.getScore()
                    )
            ){
                return getScObjects(resultSet);
            }
        }else if(
                sc.getCno() == null){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where sno = ? and score = ?",
                            sc.getSno(),
                            sc.getScore()
                    )
            ){
                return getScObjects(resultSet);
            }
        }else if(
                sc.getScore() == null){
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where sno = ? and cno = ?",
                            sc.getSno(),
                            sc.getCno()
                    )
            ){
                return getScObjects(resultSet);
            }
        }else{
            try(
                    ResultSet resultSet = scDAO.select(
                            "select * from s_c where sno = ? and cno = ? and score = ?",
                            sc.getSno(),
                            sc.getCno(),
                            sc.getScore()
                    )
            ){
                return getScObjects(resultSet);
            }
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
        ResultSet resultSet = scDAO.select("select sno from stu");
        ResultSet resultSet1 = scDAO.select("select count(*) from stu");
        int c = 0;
        while(resultSet1.next()) c = resultSet1.getInt(1);
        Object[] r = new Object[c];
        int i = 0;
        while(resultSet.next())
            r[i++] = resultSet.getString("sno");
        resultSet.close();
        resultSet1.close();
        Object[][] objects;
        if(
                sc.getSno().equals("")
        ){
            objects = new Object[c][2];
            int q = 0;
            for(Object o: r){
                ResultSet resultSet2 = scDAO.select(
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
        }else{
            objects = new Object[1][2];
            ResultSet resultSet3 = scDAO.select(
                    "select score from s_c where sno = ?",
                    sc.getSno()
            );
            double p = 0;
            while(resultSet3.next()){
                p += resultSet3.getDouble("score");
            }
            objects[0][0] = sc.getSno();
            objects[0][1] = p;
        }
        return objects;
    }

    @Override
    public Object[][] selectAllCourseAvgScore(SC sc) throws SQLException{
        ResultSet resultSet = scDAO.select("select cno from cou");
        ResultSet resultSet1 = couDAO.select("select count(*) from cou");
        int i = 0;
        while(resultSet1.next()) i = resultSet1.getInt(1);
        Object[] objects = new Object[i];
        int j = 0;
        while(resultSet.next()) objects[j++] = resultSet.getString("cno");
        resultSet1.close();
        resultSet.close();
        Object[][] objects1;
        if(sc.getCno() == null){
            objects1 = new Object[i][2];
            int i1 = 0;
            for(Object o: objects){
                ResultSet resultSet2 = scDAO.select(
                        "select count(*) from s_c where cno = ?",
                        o
                );
                int c = 0;
                while(resultSet2.next()) c = resultSet2.getInt(1);
                resultSet2.close();
                ResultSet resultset3 = scDAO.select(
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
        }else{
            objects1 = new Object[1][2];
            ResultSet resultSet2 = scDAO.select(
                    "select count(*) from s_c where cno = ?",
                    sc.getCno()
            );
            int c = 0;
            while(resultSet2.next()) c = resultSet2.getInt(1);
            resultSet2.close();
            ResultSet resultset3 = scDAO.select(
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
        }
        return objects1;
    }

    @Override
    public Object[][] sortAllStuAllScore(SC sc) throws SQLException{
        Object[][] objects = selectAllStuAllScore(new SC());
        for(int i = 0;i < objects.length - 1;i++){
            for(int j = i + 1;j < objects.length;j++){
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
            for(int i = 0;i < objects.length - 1;i++){
                for(int j = i + 1;j < objects.length;j++){
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

    @Override
    public void insertStu(Stu stu) throws SQLException{
        ResultSet resultSet = stuDAO.select(
                "select sno from stu where sno = ? ",
                stu.getSno()
        );
        boolean f = resultSet.next();
        if(
                !f &&
                        !stu.getSno().equals("") &&
                        !stu.getName().equals("") &&
                        !stu.getSex().equals("") &&
                        !stu.getCa().equals("")
        ){
            int i = stuDAO.insert(
                    "insert into stu(Ca,sno,name,sex) values(?,?,?,?)",
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
        ResultSet resultSet = scDAO.select(
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
        ResultSet resultSet = stuDAO.select(
                "select sno fom stu where sno = ?",
                stu.getSno()
        );
        if(
                resultSet.next() && !(
                        stu.getCa().equals("") &&
                                stu.getName().equals("") &&
                                stu.getSex().equals("")
                )){
            resultSet.close();
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
                        "update stu set sex = ?,Ca = ? where sno = ?",
                        stu.getSex(),
                        stu.getCa(),
                        stu.getSno()
                );
            }else if(
                    stu.getSex().equals("")
            ){
                stuDAO.modify(
                        "update stu set Ca = ?,name = ? where sno = ?",
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
    public void modifySC(@NotNull SC sc) throws SQLException{
        ResultSet resultSet = scDAO.select(
                "select sno,cno from s_c where sno = ? and cno = ?",
                sc.getSno(),
                sc.getCno()
        );
        if(resultSet.next()){
            resultSet.close();
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
    public void deleteStu(@NotNull Stu stu) throws SQLException{
        if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            JOptionPane.showMessageDialog(null,"null input");
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ?",
                    stu.getSno()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where Ca = ?",
                    stu.getCa()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ?",
                    stu.getName()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sex = ?"
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getName(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and Ca = ?",
                    stu.getSno(),
                    stu.getCa()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ? and Ca = ?",
                    stu.getName(),
                    stu.getCa()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getCa(),"")
        ){
            stuDAO.delete(
                    "delete from stu where name = ? and sex = ?",
                    stu.getName(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and name = ?",
                    stu.getSno(),
                    stu.getName()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getCa(),"") &&
                        Objects.equals(stu.getName(),"")){
            stuDAO.delete(
                    "delete from stu where sno = ? and sex = ?",
                    stu.getSno(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"") &&
                        Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where Ca = ? and sex = ?",
                    stu.getCa(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSno(),"")
        ){
            stuDAO.delete(
                    "delete from stu where Ca = ? and name = ? and sex = ?",
                    stu.getCa(),
                    stu.getName(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getName(),"")
        ){
            stuDAO.delete(
                    "delete from stu where sno = ? and Ca = ? and sex = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getCa(),"")
        ){
            stuDAO.delete(
                    "delete from dtu where sno = ? and sex = ? and name = ?",
                    stu.getSno(),
                    stu.getSex(),
                    stu.getName()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else if(
                Objects.equals(stu.getSex(),"")
        ){
            stuDAO.delete(
                    "delete from dtu where sno = ? and Ca = ? and name = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getName()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }else{
            stuDAO.delete(
                    "delete from dtu where sno = ? and Ca = ? and name = ? and sex = ?",
                    stu.getSno(),
                    stu.getCa(),
                    stu.getName(),
                    stu.getSex()
            );
            JOptionPane.showMessageDialog(null,"OK");
        }
    }

    @Override
    public void deleteScore(@NotNull SC sc) throws SQLException{
        if(sc.getCno() == null && !sc.getSno().equals("")){
            scDAO.delete("delete from s_c where sno = ?",sc.getSno());
        }else if(sc.getSno() == null){
            scDAO.delete("delete from s_c where cno = ?",sc.getCno());
        }else if(sc.getCno() != null){
            scDAO.delete("delete from s_c where cno = ? and sno = ?",sc.getCno(),sc.getSno());
        }else{
            JOptionPane.showMessageDialog(null,"null input");
        }
    }
}
