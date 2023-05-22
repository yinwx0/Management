package test.service;

import factory.Factory;
import model.Stu;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class AdminServiceTest{
    @Test
    public void selectAllStu() throws SQLException{
        Object[][] objects = Factory.Serv().selectAllStu(new Stu());
        for(Object[] objects1: objects){
            for(Object o: objects1) System.out.print(o + " ");
            System.out.println();
        }
    }

    @Test
    public void selectAllStuAllScore() throws SQLException{
//        Object[][] objects = Factory.adminImpl().select("select sno from stu");
        Object[][] objects1 = Factory.adminImpl().select("select score from s_c where sno = '2205221123'");
//        JDBCUtilsTest.p(objects1);
        double c = 0;
        for(Object[] objects2: objects1){
            c += (double)objects2[0];
        }
        System.out.println(c);
    }
}
