package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDAO{
    public ResultSet select(String sql,Object... objects) throws SQLException;

    public int insert(String sql,Object... objects) throws SQLException;

    public void modify(String sql,Object... objects) throws SQLException;

    public void delete(String sql,Object... objects) throws SQLException;
}
