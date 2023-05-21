package utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.*;

/**
 * @author Zhai Jinpei
 */
public class JDBCUtils{
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public JDBCUtils(){
    }

    public Connection getConn() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql:///sy","root","40273939zjpzjp");
    }

    public Connection getRemoteConn(
            String destination_host_username,
            String destination_host_ip,
            int destination_host_port,
            String destination_host_password,
            String destination_host_mysql_username,
            String destination_host_mysql_database_name,
            String destination_host_mysql_database_password,
            String destination_host_mysql_host_ip,
            int destination_host_mysql_host_port
            ){
        Connection connection = null;
        try{
            JSch jsch = new JSch();
//            String detionnation_name = "root";
//            String detionnation_host = "8.130.86.187";
//            int detionnation_port = 22;
            Session session = jsch.getSession(
                    destination_host_username,
                    destination_host_ip,
                    destination_host_port
            );
//            String detionnation_pwd = "111111aA";
            session.setPassword(destination_host_password);
            session.setConfig("StrictHostKeyChecking","no");
            session.connect();
//                int forward_mysql_port = 22;
            String mysql_host = "127.0.0.1";
            int mysql_port = 3306;
            int bindPort = session.setPortForwardingL(
                    "localhost",
                    destination_host_port,
                    destination_host_mysql_host_ip,
                    destination_host_mysql_host_port
            );
//                String mysql_database = "tutorials";
//                String mysql_user = "root";
//                String mysql_pwd = "admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:" + bindPort + "/" + destination_host_mysql_database_name + "?useSSL=false&autoReconnect=true",
                    destination_host_mysql_username,
                    destination_host_mysql_database_password);
            if(connection.isValid(3)){
                System.out.println("************数据库连接成功***********");
                return connection;
            }else{
                System.out.println("************数据库连接失败***********");
                return connection;
            }
        }catch(SQLException | JSchException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

    public ResultSet select(Connection connection,String sql,Object... objects) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int j = 1;j <= objects.length;j++)
            preparedStatement.setObject(j,objects[j - 1]);
        return preparedStatement.executeQuery();
    }

    public int Update(Connection connection,String sql,Object... objects) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int j = 1;j <= objects.length;j++)
            preparedStatement.setObject(j,objects[j - 1]);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return i;
    }
}
