package za.ac.cput.domain.location;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String addressId;
    private String town;
    private String city;
    private int zipCode;

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.town = builder.town;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getTown() {
        return town;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
    public static class Builder{
        private String addressId;
        private String town;
        private String city;
        private int zipCode;
        public Builder addressId(String id){
            this.addressId = id;
            return this;
        }
        public Builder town(String town){
            this.town = town;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder zipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}
