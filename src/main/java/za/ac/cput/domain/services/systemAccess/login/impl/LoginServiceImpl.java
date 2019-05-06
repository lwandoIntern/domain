package za.ac.cput.domain.services.systemAccess.login.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.sysemAccess.Login;
import za.ac.cput.domain.repository.sysAccess_repo.loginRepository.impl.LoginRepositoryImpl;
import za.ac.cput.domain.services.systemAccess.login.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

    private static LoginServiceImpl service = null;
    private LoginRepositoryImpl repository;

    private LoginServiceImpl(){
        this.repository = LoginRepositoryImpl.getRepository();
    }
    public static LoginServiceImpl getService(){
        if (service == null)service = new LoginServiceImpl();
        return service;
    }
    @Override
    public Login create(Login login) {
        return this.repository.create(login);
    }

    @Override
    public Login update(Login login) {
        return this.repository.update(login);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Login read(Login login) {
        return this.repository.read(login);
    }
}
