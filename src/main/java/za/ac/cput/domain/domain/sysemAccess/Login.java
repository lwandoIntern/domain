package za.ac.cput.domain.domain.sysemAccess;

public class Login {
    private String username,password;

    private Login(){}
    public Login(Builder builder){
        this.password = builder.password;
        this.username = builder.username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private String username,password;

        public Builder username(String val){
            this.username = val;
            return this;
        }
        public Builder password(String val){
            this.password = val;
            return this;
        }
        public Builder copy(Login login){
            this.password = login.password;
            this.username = login.username;
            return this;
        }
        public Login build(){
            return new Login(this);
        }
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
