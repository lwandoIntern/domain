package Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sysemAccess.Login;

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