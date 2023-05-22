package service;

import model.Admin;
import model.SC;
import model.Stu;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public interface AdminService{
    int state = 0;


    boolean checkLogin(Admin admin) throws SQLException;

    Object[][] selectAllStu(Stu stu) throws SQLException;

    Object[][] selectAllStuAllCourseScore(SC sc) throws SQLException;

    Object[][] selectAllStuAllScore(SC sc) throws SQLException;

    Object[][] selectAllCourseAvgScore(SC sc) throws SQLException;

    Object[][] sortAllStuAllScore(SC sc) throws SQLException;

    Object[][] sortCourseAllStuScore(SC sc) throws SQLException;

    void insertStu(Stu stu) throws SQLException;

    void insertScore(SC sc) throws SQLException;

    void modifyStu(Stu stu) throws SQLException;

    void modifySC(SC sc) throws SQLException;

    void deleteStu(Stu stu) throws SQLException;

    void deleteScore(SC sc) throws SQLException;
}
