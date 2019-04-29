package za.ac.cput.domain.domain.authors;

import za.ac.cput.domain.domain.interfaces.Address;
import za.ac.cput.domain.domain.interfaces.Contact;
import za.ac.cput.domain.domain.interfaces.Names;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Author implements Names, Contact, Address {

    @Id
    private String authId;
    private String name,surname,cellphone,telephone,city,suburb,province;
    private int zipCode,numOfBooksWritten;

    private Author(){}
    public Author(Builder builder){
        this.authId = builder.authId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.cellphone = builder.cellphone;
        this.telephone = builder.telephone;
        this.zipCode = builder.zipCode;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
        this.numOfBooksWritten = builder.numOfBooksWritten;
    }

    public String getAuthId() {
        return authId;
    }

    public int getNumOfBooksWritten(){
        return numOfBooksWritten;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getCellphone() {
        return cellphone;
    }

    @Override
    public String getTelephone() {
        return telephone;
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
    public static class Builder{
        private String authId,name,surname,cellphone,telephone,city,suburb,province;
        private int zipCode,numOfBooksWritten;

        public Builder authId(String value){
            this.authId = value;
            return this;
        }
        public Builder numOfBooksWritten(int v){
            this.numOfBooksWritten = v;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder surname(String value){
            this.surname = value;
            return this;
        }
        public Builder cellphone(String value){
            this.cellphone = value;
            return this;
        }
        public Builder telephone(String v){
            this.telephone = v;
            return this;
        }
        public Builder zipCode(int v){
            this.zipCode = v;
            return this;
        }
        public Builder city(String a){
            this.city = a;
            return this;
        }
        public Builder suburb(String c){
            this.suburb = c;
            return this;
        }
        public Builder province(String x){
            this.province = x;
            return this;
        }
        /*public Builder copy(Author author){
            this.name = author.name;
            this.surname = author.surname;
            this.cellphone = author.cellphone;
            this.telephone = author.telephone;
            this.zipCode = author.zipCode;
            this.suburb = author.suburb;
            this.city = author.city;
            this.province = author.province;
            return this;
        }*/
        public Author build(){
            return new Author(this);
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                ", suburb='" + suburb + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                ", numOfBooksWritten=" + numOfBooksWritten +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authId.equals(author.authId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authId);
    }
}
