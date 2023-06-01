package test.utils;

import factory.Factory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Zhai Jinpei
 */
@Slf4j
public class JDBCUtilsTest{
    JDBCUtils jdbc = Factory.JDBC();

    static{
        Scanner scanner = new Scanner(System.in);
        log.info("setDatabase_name");
        JDBCUtils.setDatabase_name(scanner.next());
        log.info("setUsername");
        JDBCUtils.setUsername(scanner.next());
        log.info("setPassword");
        JDBCUtils.setPassword(scanner.next());
        scanner.close();
    }

    @Test
    public void getLocalConn() throws SQLException{
        Connection connection = jdbc.getLocalConn();
        if(connection != null){
            log.info("OK");
            connection.close();
        }else{
            log.info("NO");
        }
    }

    @Test
    public void getRemoteConn() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        log.info("getDestination_host_username");
        JDBCUtils.setDh_user(scanner.next());
        log.info("getDestination_host_ip");
        JDBCUtils.setDh_ip(scanner.next());
        log.info("getDestination_host_port");
        JDBCUtils.setDh_port(scanner.next());
        log.info("getDestination_host_password");
        JDBCUtils.setDh_pwd(scanner.next());
        log.info("getDestination_host_mysql_username");
        JDBCUtils.setDsqluser(scanner.next());
        JDBCUtils.setDsqldbname("getDestination_host_mysql_database_password");
        JDBCUtils.setDsqlpwd(scanner.next());
        log.info("getDestination_host_mysql_host_ip");
        JDBCUtils.setDsqlip(scanner.next());
        log.info("getDestination_host_mysql_host_port");
        JDBCUtils.setDsqlport(scanner.next());
        Connection connection = jdbc.getRemoteConn();
        if(connection != null){
            log.info("OK");
            connection.close();
        }else{
            log.info("NO");
        }
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
