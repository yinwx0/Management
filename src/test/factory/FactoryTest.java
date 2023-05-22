package test.factory;

import factory.Factory;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class FactoryTest{

    @Test
    public void adminDAO() throws SQLException{
        Factory.adminImpl();
    }
}
