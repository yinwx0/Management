package test.utils;

import factory.Factory;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class JDBCUtilsTest{
    JDBCUtils jdbc = Factory.JDBC();

    @Test
    public void getLocalConn() throws SQLException{
    }

    @Test
    public void getRemoteConn(){

        jdbc.getRemoteConn();
    }

    @Test
    public void select() throws SQLException{
        Factory.state = 1;
        Object[][] objects = jdbc.select("select * from stu");
        Object[][] objects2 = jdbc.select("select * from stu");
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
