package Factory;

import employees.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerFactoryTest {

    private Employee manager;
    @Before
    public void setUp() throws Exception {
        manager = ManagerFactory.createManager("x","y","z","a",4552,"DBN","DBN","KZN",
                "LBN",false,true);
    }

    @Test
    public void createManager() {
        Assert.assertEquals(manager.getCellphone(),manager.getCellphone());
    }
}