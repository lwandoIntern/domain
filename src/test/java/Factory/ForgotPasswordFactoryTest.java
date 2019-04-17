package Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sysemAccess.ForgotPassword;

import static org.junit.Assert.*;

public class ForgotPasswordFactoryTest {

    private ForgotPassword forgotPassword;
    @Before
    public void setUp() throws Exception {
        forgotPassword = ForgotPasswordFactory.createForgotPassword("Lwa");
    }

    @Test
    public void createForgotPassword() {
        Assert.assertEquals(forgotPassword.getPassword(),forgotPassword.getPassword());
    }
}