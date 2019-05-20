package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.employee.AdminFactory;
import za.ac.cput.domain.domain.employee.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminFactoryTest {

    private Employee admin;
    @Before
    public void setUp() throws Exception {
        admin = AdminFactory.createAdmin("Me","You","0740740918",null,7441,"Dunoon",
                "CPT","WC","MNG",false,true);
    }

    @Test
    public void createAdmin() {
        Assert.assertNotNull(admin);
    }
}