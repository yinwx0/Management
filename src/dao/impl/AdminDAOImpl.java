package dao.impl;

import dao.AdminDAO;
import factory.Factory;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class AdminDAOImpl implements AdminDAO{
    JDBCUtils jdbc = Factory.JDBC();


    @Override
    public Object[][] select(String sql,Object... objects) throws SQLException{
        return jdbc.select(sql,objects);
    }

    @Override
    public int insert(String sql,Object... objects) throws SQLException{
        return jdbc.Update(sql,objects);
    }

    @Override
    public void modify(String sql,Object... objects) throws SQLException{
        jdbc.Update(sql,objects);
    }

    @Override
    public void delete(String sql,Object... objects) throws SQLException{
        jdbc.Update(sql,objects);
    }

}
