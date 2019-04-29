package za.ac.cput.domain.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.registration.LoginFactory;
import za.ac.cput.domain.domain.sysemAccess.Login;

public class LoginFactoryTest {

    private Login login;
    @Before
    public void setUp() throws Exception {
        login = LoginFactory.createLogin("xy#44","()mmYHll&*");
    }

    @Test
    public void createLogin() {
        Assert.assertEquals(login.getPassword(),login.getPassword());
    }
}