package test.factory;

import factory.Factory;
import org.junit.jupiter.api.Test;

/**
 * @author Zhai Jinpei
 */
public class ReturnClassFactoryTest{
    Factory returnClassFactory = new Factory();

    @Test
    public void adminDAO(){
        returnClassFactory.AdminImpl();
    }
}
