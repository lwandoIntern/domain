package Factory;

import sysemAccess.ForgotPassword;

public class ForgotPasswordFactory {
    public static ForgotPassword createForgotPassword(String pass){
        return new ForgotPassword.Builder()
                .password(pass)
                .build();
    }
}
