package factory;

import dao.impl.AdminDAOImpl;
import dao.impl.CouDAOImpl;
import dao.impl.ScDAOImpl;
import dao.impl.StuDAOImpl;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import service.AdminServiceImpl;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class Factory{
    public static int state;

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl adminImpl(){
        return new AdminDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl stuImpl() throws SQLException{
        return new StuDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl scImpl() throws SQLException{
        return new ScDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl couImpl() throws SQLException{
        return new CouDAOImpl();
    }

    @Contract(value=" -> new", pure=true)
    public static @NotNull JDBCUtils JDBC(){
        return new JDBCUtils();
    }

    @Contract(value=" -> new", pure=true)
    public static @NotNull AdminServiceImpl Serv() throws SQLException{
        return new AdminServiceImpl();
    }
}
