package factory;

import dao.impl.AdminDAOImpl;
import service.AdminService;
import utils.JDBCUtils;

/**
 * @author Zhai Jinpei
 */
public class Factory{
    public static AdminDAOImpl AdminImpl(){
        return new AdminDAOImpl();
    }

    public static JDBCUtils JDBC(){
        return new JDBCUtils();
    }

    public static AdminService Serv(){
        return new AdminService();
    }
}
