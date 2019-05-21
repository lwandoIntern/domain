package za.ac.cput.domain.repository.system_access.registration.impl;

import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.sysemAccess.Register;
import za.ac.cput.domain.Factory.system_access.RegisterFactory;
import za.ac.cput.domain.repository.system_access.registration.RegisterRepository;

import static org.junit.Assert.*;

public class RegisterRepositoryImplTest {

    private RegisterRepository repository;
    private Register register;
    @Before
    public void setUp() throws Exception {
        repository = RegisterRepositoryImpl.getRepository();
        register = RegisterFactory.createRegister("Nceba","Goniwe","0740740918","0117149333",7441,
                "MLN","CPT","WC");
    }

    @Test
    public void create() {
        assertEquals(repository.create(register),repository.create(register));
    }

    @Test
    public void read() {
        assertEquals(repository.read(register),repository.read(register));
    }

    @Test
    public void update() {
        assertEquals(repository.update(register),repository.update(register));
    }

    @Test
    public void delete() {
        repository.delete(register.getRegNum());
    }
}