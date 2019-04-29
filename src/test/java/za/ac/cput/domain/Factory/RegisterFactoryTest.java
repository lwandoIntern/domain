package za.ac.cput.domain.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.registration.RegisterFactory;
import za.ac.cput.domain.domain.sysemAccess.Register;

public class RegisterFactoryTest {

    private Register register;
    @Before
    public void setUp() throws Exception {
        register = RegisterFactory.createRegister("100x","x","s",null,
                "55444411",7421,"DBV","CPT","WC");
    }

    @Test
    public void createRegister() {
        Assert.assertEquals(register.getCellphone(), register.getCellphone());
    }
}