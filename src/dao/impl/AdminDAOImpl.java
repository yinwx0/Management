package dao.impl;

import dao.AdminDAO;
import factory.Factory;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class AdminDAOImpl implements AdminDAO{
    JDBCUtils jdbc = Factory.JDBC();

    @Override
    public ResultSet select(String sql,Object... objects) throws SQLException{
        return jdbc.select(jdbc.getLocalConn("sy","root","40273939zjpzjp"),sql,objects);
    }

    @Override
    public int insert(String sql,Object... objects) throws SQLException{
        return jdbc.Update(jdbc.getLocalConn("sy","root","40273939zjpzjp"),sql,objects);
    }

    @Override
    public void modify(String sql,Object... objects) throws SQLException{
        jdbc.Update(jdbc.getLocalConn("sy","root","40273939zjpzjp"),sql,objects);
    }

    @Override
    public void delete(String sql,Object... objects) throws SQLException{
        jdbc.Update(jdbc.getLocalConn("sy","root","40273939zjpzjp"),sql,objects);
    }

}
