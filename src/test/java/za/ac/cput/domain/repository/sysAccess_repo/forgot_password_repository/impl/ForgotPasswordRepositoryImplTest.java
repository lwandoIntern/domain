package za.ac.cput.domain.repository.sysAccess_repo.forgot_password_repository.impl;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;
import za.ac.cput.domain.Factory.registration.ForgotPasswordFactory;
import za.ac.cput.domain.repository.sysAccess_repo.forgot_password_repository.ForgotPasswordRepository;

import static org.junit.Assert.*;

public class ForgotPasswordRepositoryImplTest {

    private ForgotPasswordRepository repository;
    private ForgotPassword forgotPassword;
    @Before
    public void setUp() throws Exception {
        forgotPassword = ForgotPasswordFactory.createForgotPassword("Patsy");
        repository = ForgotPasswordRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        assertEquals(repository.create(forgotPassword),repository.create(forgotPassword));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void read() {
        assertEquals(repository.read(forgotPassword),repository.read(forgotPassword));
    }

    @Test
    public void update() {
        assertEquals(repository.update(forgotPassword),repository.update(forgotPassword));
    }

    @Test
    public void delete() {
        repository.delete(forgotPassword.getPassword());
    }
}