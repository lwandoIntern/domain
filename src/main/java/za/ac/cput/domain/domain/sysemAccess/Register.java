package za.ac.cput.domain.domain.sysemAccess;


import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;

import java.util.Objects;

public class Register{

    private String regNum;
    private Names name;
    private Address address;
    private Contacts contacts;

    private Register(){}
    public Register(Builder builder){
        this.regNum = builder.regNum;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
    }

    public String getRegNum() {
        return regNum;
    }

    public Names getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public static class Builder{
        private String regNum;
        private Names name;
        private Address address;
        private Contacts contacts;

        public Builder regNum(String r){
            this.regNum = r;
            return this;
        }
        public Builder name(Names value){
            this.name = value;
            return this;
        }
        public Builder contacts(Contacts value){
            this.contacts = value;
            return this;
        }
        public Builder address(Address val){
            this.address = val;
            return this;
        }

        public Register build(){
            return new Register(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return regNum.equals(register.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNum);
    }
}
