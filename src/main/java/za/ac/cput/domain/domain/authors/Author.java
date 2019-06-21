package za.ac.cput.domain.domain.authors;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;
import za.ac.cput.domain.domain.value_objects.Names;

@EntityScan
public class Author{
    private String authId;
    private Names name;
    private Address address;
    private Contacts contacts;
    private int numOfBooksWritten;

    private Author(){}
    public Author(Builder builder){
        this.authId = builder.authId;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
        this.numOfBooksWritten = builder.numOfBooksWritten;
    }

    public String getAuthId() {
        return authId;
    }

    public int getNumOfBooksWritten(){
        return numOfBooksWritten;
    }

    public static class Builder{
        private String authId;
        private Names name;
        private Address address;
        private Contacts contacts;
        private int numOfBooksWritten;

        public Builder authId(String value){
            this.authId = value;
            return this;
        }
        public Builder numOfBooksWritten(int v){
            this.numOfBooksWritten = v;
            return this;
        }
        public Builder name(Names value){
            this.name = value;
            return this;
        }
        public Builder address(Address address){
            this.address = address;
            return this;
        }
        public Builder contacts(Contacts contacts){
            this.contacts = contacts;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }


}
