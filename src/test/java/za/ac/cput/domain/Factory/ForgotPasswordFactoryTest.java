package za.ac.cput.domain.Factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.system_access.ForgotPasswordFactory;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;

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