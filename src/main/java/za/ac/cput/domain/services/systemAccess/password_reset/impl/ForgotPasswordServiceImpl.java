package za.ac.cput.domain.services.systemAccess.password_reset.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;
import za.ac.cput.domain.repository.sysAccess_repo.forgot_password_repository.impl.ForgotPasswordRepositoryImpl;
import za.ac.cput.domain.services.systemAccess.password_reset.ForgotPasswordService;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    private static ForgotPasswordServiceImpl service = null;
    private ForgotPasswordRepositoryImpl repository;

    private ForgotPasswordServiceImpl(){
        this.repository = ForgotPasswordRepositoryImpl.getRepository();
    }
    public static ForgotPasswordServiceImpl getService(){
        if (service == null)service = new ForgotPasswordServiceImpl();
        return service;
    }
    @Override
    public ForgotPassword create(ForgotPassword forgotPassword) {
        return this.repository.create(forgotPassword);
    }

    @Override
    public ForgotPassword update(ForgotPassword forgotPassword) {
        return this.repository.update(forgotPassword);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public ForgotPassword read(ForgotPassword forgotPassword) {
        return this.repository.read(forgotPassword);
    }
}
