package za.ac.cput.domain.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {
    @Id
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "town")
    private String town;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private int zipCode;

    private Address(){}
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
        private String addressId,town,city;
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
