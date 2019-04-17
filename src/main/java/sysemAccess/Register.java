package sysemAccess;


import interfaces.Address;
import interfaces.Contact;
import interfaces.Names;


public class Register implements Names,Contact,Address{

    private String name,surname,cellphone,telephone,suburb,city,province;
    private int zipCode;

    private Register(){}
    public Register(Builder builder){
        this.name = builder.name;
        this.suburb = builder.suburb;
        this.surname = builder.surname;
        this.cellphone = builder.cellphone;
        this.telephone = builder.telephone;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;
    }
    @Override
    public int getZipCode() {
        return 0;
    }

    @Override
    public String getSurbub() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getProvince() {
        return null;
    }

    @Override
    public String getCellphone() {
        return null;
    }

    @Override
    public String getTelephone() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    public static class Builder{
        private String name,surname,cellphone,telephone,suburb,city,province;
        private int zipCode;
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder surname(String value){
            this.surname = value;
            return this;
        }
        public Builder cellphone(String val){
            this.cellphone = val;
            return this;
        }
        public Builder telephone(String val){
            this.telephone = val;
            return this;
        }
        public Builder zipCode(int code){
            this.zipCode = code;
            return this;
        }
        public Builder suburb(String val){
            this.suburb = val;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder province(String prov){
            this.province = prov;
            return this;
        }
        public Builder copy(Register member){
            this.name = member.name;
            this.suburb = member.suburb;
            this.surname = member.surname;
            this.cellphone = member.cellphone;
            this.telephone = member.telephone;
            this.city =member.city;
            this.province = member.province;
            this.zipCode = member.zipCode;
            return this;
        }
        public Register build(){
            return new Register(this);
        }
    }
}
