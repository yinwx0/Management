package factory;

import dao.impl.AdminDAOImpl;
import dao.impl.CouDAOImpl;
import dao.impl.ScDAOImpl;
import dao.impl.StuDAOImpl;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import service.AdminServiceImpl;
import utils.JDBCUtils;

/**
 * @author Zhai Jinpei
 */
public class Factory{
    @Contract(" -> new")
    public static @NotNull AdminDAOImpl adminImpl(){
        return new AdminDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl stuImpl(){
        return new StuDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl scImpl(){
        return new ScDAOImpl();
    }

    @Contract(" -> new")
    public static @NotNull AdminDAOImpl couImpl(){
        return new CouDAOImpl();
    }

    @Contract(value=" -> new", pure=true)
    public static @NotNull JDBCUtils JDBC(){
        return new JDBCUtils();
    }

    @Contract(value=" -> new", pure=true)
    public static @NotNull AdminServiceImpl Serv(){
        return new AdminServiceImpl();
    }
}
