package utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import factory.Factory;
import lombok.Data;

import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhai Jinpei
 */
@SuppressWarnings("all")
@Data
public class JDBCUtils{
    public static String getDatabase_name(){
        return database_name;
    }

    public static void setDatabase_name(String database_name){
        JDBCUtils.database_name = database_name;
    }

    public static String getUsername(){
        return username;
    }

    public static void setUsername(String username){
        JDBCUtils.username = username;
    }

    public static String getPassword(){
        return password;
    }

    public static void setPassword(String password){
        JDBCUtils.password = password;
    }

    public static String getDh_user(){
        return dh_user;
    }

    public static void setDh_user(String dh_user){
        JDBCUtils.dh_user = dh_user;
    }

    public static String getDh_ip(){
        return dh_ip;
    }

    public static void setDh_ip(String dh_ip){
        JDBCUtils.dh_ip = dh_ip;
    }

    public static String getDh_port(){
        return dh_port;
    }

    public static void setDh_port(String dh_port){
        JDBCUtils.dh_port = dh_port;
    }

    public static String getDh_pwd(){
        return dh_pwd;
    }

    public static void setDh_pwd(String dh_pwd){
        JDBCUtils.dh_pwd = dh_pwd;
    }

    public static String getDsqluser(){
        return dsqluser;
    }

    public static void setDsqluser(String dsqluser){
        JDBCUtils.dsqluser = dsqluser;
    }

    public static String getDsqldbname(){
        return dsqldbname;
    }

    public static void setDsqldbname(String dsqldbname){
        JDBCUtils.dsqldbname = dsqldbname;
    }

    public static String getDsqlpwd(){
        return dsqlpwd;
    }

    public static void setDsqlpwd(String dsqlpwd){
        JDBCUtils.dsqlpwd = dsqlpwd;
    }

    public static String getDsqlip(){
        return dsqlip;
    }

    public static void setDsqlip(String dsqlip){
        JDBCUtils.dsqlip = dsqlip;
    }

    public static String getDsqlport(){
        return dsqlport;
    }

    public static void setDsqlport(String dsqlport){
        JDBCUtils.dsqlport = dsqlport;
    }

    public Session getSession(){
        return session;
    }

    public void setSession(Session session){
        this.session = session;
    }

    public Lock getLock(){
        return lock;
    }

    private static volatile String database_name,
            username,
            password,
            dh_user,
            dh_ip,
            dh_port,
            dh_pwd,
            dsqluser,
            dsqldbname,
            dsqlpwd,
            dsqlip,
            dsqlport;
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

    Connection getLocalConn() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql:///" + database_name,username,password);
    }

    /**
     * @return ssh connection
     */
    public Connection getRemoteConn(){
        try{
            JSch jsch = new JSch();
            session = jsch.getSession(dh_user,dh_ip,Integer.parseInt(dh_port));
            session.setPassword(dh_pwd);
            session.setConfig("StrictHostKeyChecking","no");
            session.connect();
            int bindPort = session.setPortForwardingL(
                    "localhost",
                    Integer.parseInt(dh_port),
                    dsqlip,
                    Integer.parseInt(dsqlport));
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:" + bindPort + "/" + dsqldbname + "?useSSL=false&autoReconnect=true",
                    dsqluser,
                    dsqlpwd);
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
                Connection connection = getRemoteConn();
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
                Connection connection = getLocalConn();
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
                Connection connection = getRemoteConn();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for(int j = 1;j <= objects.length;j++)
                    preparedStatement.setObject(j,objects[j - 1]);
                int i = preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                session.disconnect();
                return i;
            }else{
                Connection connection = getLocalConn();
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
