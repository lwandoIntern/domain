package sysemAccess;

import book.Book;

public class ForgotPassword {
    private String password;

    private ForgotPassword(){}
    public ForgotPassword(Builder builder){
        this.password = builder.password;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private String password;

        public Builder password(String value){
            this.password = value;
            return this;
        }
        public Builder copy(ForgotPassword forgotPassword){
            this.password = forgotPassword.password;
            return this;
        }
        public ForgotPassword build(){
            return new ForgotPassword(this);
        }
    }
}
