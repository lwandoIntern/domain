package Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sysemAccess.Register;

import static org.junit.Assert.*;

public class RegisterFactoryTest {

    private Register register;
    @Before
    public void setUp() throws Exception {
        register = RegisterFactory.createRegister("x","s",null,
                "55444411",7421,"DBV","CPT","WC");
    }

    @Test
    public void createRegister() {
        Assert.assertEquals(register.getCellphone(), register.getCellphone());
    }
}