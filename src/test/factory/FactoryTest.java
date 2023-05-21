package test.factory;

import factory.Factory;
import org.junit.jupiter.api.Test;

/**
 * @author Zhai Jinpei
 */
public class FactoryTest{

    @Test
    public void adminDAO(){
        Factory.adminImpl();
    }
}
