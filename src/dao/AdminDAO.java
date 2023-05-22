package dao;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public interface AdminDAO{
    Object[][] select(String sql,Object... objects) throws SQLException;

    int insert(String sql,Object... objects) throws SQLException;

    void modify(String sql,Object... objects) throws SQLException;

    void delete(String sql,Object... objects) throws SQLException;
}
