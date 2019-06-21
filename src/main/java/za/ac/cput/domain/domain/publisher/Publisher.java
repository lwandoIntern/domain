package za.ac.cput.domain.domain.publisher;

import za.ac.cput.domain.domain.value_objects.Address;
import za.ac.cput.domain.domain.value_objects.Contacts;

import java.util.Objects;


public class Publisher {
    private String publishId;
    private String name;
    private Address address;
    private Contacts contacts;
    private int numOfBooksPublished;

    private Publisher(){}
    public Publisher(Builder builder){
        this.publishId = builder.publishId;
        this.name = builder.name;
        this.address = builder.address;
        this.contacts = builder.contacts;
        this.numOfBooksPublished = builder.numOfBooksPublished;
    }
    public String getPublishId() {
        return publishId;
    }
    public Address getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }
    public int getNumOfBooksPublished(){
        return numOfBooksPublished;
    }
    public static class Builder {
        private String publishId;
        private String name;
        private Address address;
        private Contacts contacts;
        private int numOfBooksPublished;

        public Builder publishedId(String id){
            this.publishId = id;
            return this;
        }
        public Builder numOfBooksPublished(int v) {
            this.numOfBooksPublished = v;
            return this;
        }

        public Builder name(String value) {
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
        public Publisher build() {
            return new Publisher(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publishId.equals(publisher.publishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishId);
    }
}
