package za.ac.cput.domain.Factory.registration;

import za.ac.cput.domain.domain.sysemAccess.Login;

public class LoginFactory {
    public static Login createLogin(String username,String pass){
        return new Login.Builder()
                .username(username)
                .password(pass)
                .build();
    }
}
