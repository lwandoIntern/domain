package za.ac.cput.domain.repository.system_access.login.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.domain.sysemAccess.Login;
import za.ac.cput.domain.repository.system_access.login.LoginRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
    private static LoginRepositoryImpl repository = null;
    private Map<String,Login> logins;

    private LoginRepositoryImpl(){
        this.logins = new HashMap<>();
    }

    public static LoginRepositoryImpl getRepository() {
        if (repository == null)repository = new LoginRepositoryImpl();
        return repository;
    }

    @Override
    public Login create(Login login) {
        repository.logins.put(login.getUsername(),login);
        return repository.logins.get(login.getUsername());
    }

    @Override
    public Login read(Login login) {
        return repository.logins.get(login.getUsername());
    }

    @Override
    public Login update(Login login) {
        repository.logins.put(login.getUsername(),login);
        return repository.logins.get(login.getUsername());
    }

    @Override
    public void delete(String s) {
        repository.logins.remove(s);
    }
}