package publishers;

import book.Book;
import interfaces.Address;
import interfaces.Contact;
import authors.Author;

public class Publisher implements Contact, Address {
    private Author author;
    private Book book;
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
        private String name, cellphone, telephone, city, suburb, province;
        private int zipCode, numOfBooksWritten;

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
        public Builder copy(Publisher publisher){
            this.name = publisher.name;
            this.cellphone = publisher.cell;
            this.telephone = publisher.tel;
            this.zipCode = publisher.zipCode;
            this.suburb = publisher.suburb;
            this.city = publisher.city;
            this.province = publisher.province;
            this.book = publisher.book;
            this.author = publisher.author;
            this.numOfBooksWritten = publisher.numOfBooksWritten;
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
                ", book=" + book +
                ", name='" + name + '\'' +
                ", cell='" + cell + '\'' +
                ", tel='" + tel + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
