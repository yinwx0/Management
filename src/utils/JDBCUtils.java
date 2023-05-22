package utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import factory.Factory;

import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhai Jinpei
 */
public class JDBCUtils{
    private Session session = null;
    private final Lock lock = new ReentrantLock();

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public JDBCUtils(){
    }

    @Deprecated
    public Connection getConn() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql:///sy","root","40273939zjpzjp");
    }

    public Connection getLocalConn(String database_name,String username,String password) throws SQLException{
        return DriverManager.getConnection("jdbc:mysql:///" + database_name,username,password);
    }

    /**
     * @param destination_host_username                "root"
     * @param destination_host_ip                      "8.130.86.187"
     * @param destination_host_port                    22
     * @param destination_host_password                "111111aA"
     * @param destination_host_mysql_username          "root"
     * @param destination_host_mysql_database_name     ""
     * @param destination_host_mysql_database_password "admin"
     * @param destination_host_mysql_host_ip           "127.0.0.1"
     * @param destination_host_mysql_host_port         3306
     * @return ssh connection
     */
    public Connection getRemoteConn(String destination_host_username,String destination_host_ip,int destination_host_port,String destination_host_password,String destination_host_mysql_username,String destination_host_mysql_database_name,String destination_host_mysql_database_password,String destination_host_mysql_host_ip,int destination_host_mysql_host_port){
        try{
            JSch jsch = new JSch();
            session = jsch.getSession(destination_host_username,destination_host_ip,destination_host_port);
            session.setPassword(destination_host_password);
            session.setConfig("StrictHostKeyChecking","no");
            session.connect();
            int bindPort = session.setPortForwardingL("localhost",destination_host_port,destination_host_mysql_host_ip,destination_host_mysql_host_port);
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:" + bindPort + "/" + destination_host_mysql_database_name + "?useSSL=false&autoReconnect=true",destination_host_mysql_username,destination_host_mysql_database_password);
        }catch(SQLException | JSchException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public Object[][] select(String sql,Object... objects) throws SQLException{
        lock.lock();
        try{
            if(Factory.state == 1){
                Connection connection = getRemoteConn("root","8.130.86.187",22,"111111aA","root","sy","admin","127.0.0.1",3306);
                PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                for(int j = 1;j <= objects.length;j++)
                    preparedStatement.setObject(j,objects[j - 1]);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int c = resultSetMetaData.getColumnCount();
                    resultSet.last();
                    int k = resultSet.getRow();
                    Object[][] objects1 = new Object[k][c];
                    int j = 0;
                    resultSet.first();
                    do{
                        for(int i = 0;i < c;i++){
                            objects1[j][i] = resultSet.getObject(i + 1);
                        }
                        j++;
                    }while(resultSet.next());
                    resultSet.close();
                    connection.close();
                    session.disconnect();
                    return objects1;
                }else{
                    resultSet.close();
                    connection.close();
                    session.disconnect();
                    return null;
                }
            }else{
                Connection connection = getLocalConn("sy","root","40273939zjpzjp");
                PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                for(int j = 1;j <= objects.length;j++)
                    preparedStatement.setObject(j,objects[j - 1]);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int c = resultSetMetaData.getColumnCount();
                    resultSet.last();
                    int k = resultSet.getRow();
                    Object[][] objects1 = new Object[k][c];
                    int j = 0;
                    resultSet.first();
                    do{
                        for(int i = 0;i < c;i++){
                            objects1[j][i] = resultSet.getObject(i + 1);
                        }
                        j++;
                    }while(resultSet.next());
                    resultSet.close();
                    connection.close();
                    return objects1;
                }else{
                    resultSet.close();
                    connection.close();
                    return null;
                }
            }
        }finally{
            lock.unlock();
        }
    }

    public int Update(String sql,Object... objects) throws SQLException{
        lock.lock();
        try{
            if(Factory.state == 1){
                Connection connection = getRemoteConn("root","8.130.86.187",22,"111111aA","root","sy","admin","127.0.0.1",3306);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for(int j = 1;j <= objects.length;j++)
                    preparedStatement.setObject(j,objects[j - 1]);
                int i = preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                session.disconnect();
                return i;
            }else{
                Connection connection = getLocalConn("sy","root","40273939zjpzjp");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for(int j = 1;j <= objects.length;j++)
                    preparedStatement.setObject(j,objects[j - 1]);
                int i = preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                return i;
            }
        }finally{
            lock.unlock();
        }
    }
}
