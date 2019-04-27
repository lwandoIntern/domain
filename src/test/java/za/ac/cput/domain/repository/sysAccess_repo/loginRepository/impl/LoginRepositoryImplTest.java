package za.ac.cput.domain.repository.sysAccess_repo.loginRepository.impl;

import org.junit.Before;
import org.junit.Test;
import sysemAccess.Login;
import za.ac.cput.domain.Factory.LoginFactory;
import za.ac.cput.domain.repository.sysAccess_repo.loginRepository.LoginRepository;

import static org.junit.Assert.*;

public class LoginRepositoryImplTest {

    private LoginRepository repository;
    private Login login;
    @Before
    public void setUp() throws Exception {
        login = LoginFactory.createLogin("as43@ff","Lwa@7834");
        repository = LoginRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        assertEquals(repository.create(login),repository.create(login));
    }

    @Test
    public void read() {
        assertEquals(repository.read(login),repository.read(login));
    }

    @Test
    public void update() {
        assertEquals(repository.update(login),repository.update(login));
    }

    @Test
    public void delete() {
        repository.delete(login.getUsername());
    }
}