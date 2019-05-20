package za.ac.cput.domain.services.systemAccess.forgot_password.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;
import za.ac.cput.domain.repository.system_access.forgot_password.impl.ForgotPasswordRepositoryImpl;
import za.ac.cput.domain.services.systemAccess.forgot_password.ForgotPasswordService;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    @Autowired
    private ForgotPasswordRepositoryImpl repository;

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
