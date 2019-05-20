package za.ac.cput.domain.services.systemAccess.registration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.sysemAccess.Register;
import za.ac.cput.domain.repository.system_access.registration.impl.RegisterRepositoryImpl;
import za.ac.cput.domain.services.systemAccess.registration.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepositoryImpl repository;

    @Override
    public Register create(Register register) {
        return this.repository.create(register);
    }

    @Override
    public Register update(Register register) {
        return this.repository.update(register);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Register read(Register register) {
        return this.repository.read(register);
    }
}
