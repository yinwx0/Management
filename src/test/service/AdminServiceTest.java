package test.service;

import factory.Factory;
import model.Stu;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author Zhai Jinpei
 */
public class AdminServiceTest{
    @Test
    public void selectAllStu() throws SQLException{
        Object[][] objects = Factory.Serv().selectAllStu(new Stu());
        for(Object[] objects1: objects){
            for(Object o: objects1) System.out.print(o + " ");
            System.out.println();
        }
    }
}
