package za.ac.cput.domain.repository.sysAccess_repo.register_repository.impl;

import za.ac.cput.domain.domain.sysemAccess.Register;
import za.ac.cput.domain.repository.sysAccess_repo.register_repository.RegisterRepository;

import java.util.HashMap;
import java.util.Map;

public class RegisterRepositoryImpl implements RegisterRepository {
    private static RegisterRepositoryImpl repository = null;
    private Map<String,Register> registrations;

    private RegisterRepositoryImpl(){
        this.registrations = new HashMap<>();
    }

    public static RegisterRepositoryImpl getRepository() {
        if (repository == null)repository = new RegisterRepositoryImpl();
        return repository;
    }

    @Override
    public Register create(Register register) {
        repository.registrations.put(register.getCellphone(),register);
        return repository.registrations.get(register.getCellphone());
    }

    @Override
    public Register read(Register register) {
        return repository.registrations.get(register.getCellphone());
    }

    @Override
    public Register update(Register register) {
        repository.registrations.put(register.getCellphone(),register);
        return registrations.get(register.getCellphone());
    }

    @Override
    public void delete(String s) {
        registrations.remove(s);
    }
}
