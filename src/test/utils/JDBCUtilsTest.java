package test.utils;

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
    }
}
