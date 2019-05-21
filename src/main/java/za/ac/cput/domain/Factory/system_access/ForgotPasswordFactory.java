package za.ac.cput.domain.Factory.system_access;

import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;

public class ForgotPasswordFactory {
    public static ForgotPassword createForgotPassword(String pass){
        return new ForgotPassword.Builder()
                .password(pass)
                .build();
    }
}