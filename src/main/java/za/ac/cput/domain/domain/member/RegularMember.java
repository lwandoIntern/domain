package za.ac.cput.domain.domain.member;

import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;

import java.util.Objects;


public class RegularMember implements Member{
    private String memberId;
    private Names name;
    private Address address;
    private Contacts contacts;

    private RegularMember(){}
    public RegularMember(Builder builder){
        this.memberId = builder.memberId;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
    }
    @Override
    public String getMemberId() {
        return memberId;
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
        private String memberId;
        private Names name;
        private Address address;
        private Contacts contacts;

        public Builder memberId(String id){
            this.memberId = memberId;
            return this;
        }
        public Builder name(Names value){
            this.name = value;
            return this;
        }
        public Builder address(Address value){
            this.address = value;
            return this;
        }
        public Builder contacts(Contacts value){
            this.contacts = value;
            return this;
        }
        public RegularMember build(){
            return new RegularMember(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularMember that = (RegularMember) o;
        return memberId.equals(that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
