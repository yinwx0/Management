package test.utils;

import factory.Factory;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class JDBCUtilsTest{
    JDBCUtils jdbcUtils = new JDBCUtils();

    @Test
    public void getConn() throws SQLException{
        jdbcUtils.getLocalConn("sy","root","40273939zjpzjp");
    }

    @Test
    public void getRemoteConn(){
        jdbcUtils.getRemoteConn(
                "root",
                "8.130.86.187",
                22,
                "111111aA",
                "root",
                "",
                "admin",
                "127.0.0.1",
                3306
        );
    }

    @Test
    public void select() throws SQLException{
        Factory.state = 1;
        Object[][] objects = jdbcUtils.select("select * from stu");
        Object[][] objects2 = jdbcUtils.select("select * from stu");
        p(objects);
        p(objects2);
    }

    public static void p(Object[][] objects){
        for(Object[] objects1: objects){
            for(Object o: objects1){
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}
