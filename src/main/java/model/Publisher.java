package model;

import interfaces.Address;
import interfaces.Contact;

public class Publisher implements Contact, Address {
    private Author author;
    private Book book;
    private String name,cell,tel,suburb,city,province;
    private int zipCode;

    private Publisher(){}
    public Publisher(Builder builder){
        this.name = builder.name;
        this.cell = builder.cellphone;
        this.tel = builder.telephone;
        this.zipCode = builder.zipCode;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
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
    public static class Builder {
        private Author author;
        private Book book;
        private String name, surname, cellphone, telephone, city, suburb, province;
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

        public Publisher build() {
            return new Publisher(this);
        }
    }
}
