package za.ac.cput.domain.domain.publishers;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.interfaces.Address;
import za.ac.cput.domain.domain.interfaces.Contact;
import za.ac.cput.domain.domain.authors.Author;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Publisher implements Contact, Address {
    private Author author;
    private Book book;
    @Id
    private String publishId;
    private String name,cell,tel,suburb,city,province;
    private int zipCode,numOfBooksWritten;

    private Publisher(){}
    public Publisher(Builder builder){
        this.name = builder.name;
        this.cell = builder.cellphone;
        this.tel = builder.telephone;
        this.zipCode = builder.zipCode;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
        this.author = builder.author;
        this.book = builder.book;
        this.numOfBooksWritten = builder.numOfBooksWritten;
    }
    public String getPublishId() {
        return publishId;
    }
    @Override
    public String getCellphone() {
        return cell;
    }

    @Override
    public String getTelephone() {
        return tel;
    }

    @Override
    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String getSurbub() {
        return suburb;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getProvince() {
        return province;
    }
    public int getNumOfBooksWritten(){
        return numOfBooksWritten;
    }
    public static class Builder {
        private Author author;
        private Book book;
        private String publishId;
        private String name, cellphone, telephone, city, suburb, province;
        private int zipCode, numOfBooksWritten;

        public Builder publishedId(String id){
            this.publishId = id;
            return this;
        }
        public Builder numOfBooksWritten(int v) {
            this.numOfBooksWritten = v;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder cellphone(String value) {
            this.cellphone = value;
            return this;
        }

        public Builder telephone(String v) {
            this.telephone = v;
            return this;
        }

        public Builder zipCode(int v) {
            this.zipCode = v;
            return this;
        }

        public Builder city(String a) {
            this.city = a;
            return this;
        }

        public Builder suburb(String c) {
            this.suburb = c;
            return this;
        }

        public Builder province(String x) {
            this.province = x;
            return this;
        }
        public Builder author(Author value){
            this.author = value;
            return this;
        }
        public Builder book(Book v){
            this.book = v;
            return this;
        }
        public Publisher build() {
            return new Publisher(this);
        }
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "author=" + author +
                ", za.ac.cput.domain.domain.author.book=" + book +
                ", publishId='" + publishId + '\'' +
                ", name='" + name + '\'' +
                ", cell='" + cell + '\'' +
                ", tel='" + tel + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                ", numOfBooksWritten=" + numOfBooksWritten +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return author.equals(publisher.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }
}
