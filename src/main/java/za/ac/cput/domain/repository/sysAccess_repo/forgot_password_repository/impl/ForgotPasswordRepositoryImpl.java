package za.ac.cput.domain.repository.sysAccess_repo.forgot_password_repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;
import za.ac.cput.domain.repository.sysAccess_repo.forgot_password_repository.ForgotPasswordRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ForgotPasswordRepositoryImpl implements ForgotPasswordRepository {
    private static ForgotPasswordRepositoryImpl repository = null;
    private List<ForgotPassword> passwords;

    private ForgotPasswordRepositoryImpl(){
        this.passwords = new ArrayList<>();
    }

    public static ForgotPasswordRepositoryImpl getRepository() {
        if (repository == null)repository = new ForgotPasswordRepositoryImpl();
        return repository;
    }

    @Override
    public ForgotPassword create(ForgotPassword forgotPassword) {
        repository.passwords.add(forgotPassword);
        int x = passwords.indexOf(forgotPassword);
        return passwords.get(x);
    }

    @Override
    public ForgotPassword read(ForgotPassword forgotPassword) {
        int x = passwords.indexOf(forgotPassword);
        return repository.passwords.get(x);
    }

    @Override
    public ForgotPassword update(ForgotPassword forgotPassword) {
        repository.passwords.add(forgotPassword);
        int x = passwords.indexOf(forgotPassword);
        return repository.passwords.get(x);
    }

    @Override
    public void delete(String s) {
        repository.passwords.remove(s);
    }
}
