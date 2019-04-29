package za.ac.cput.domain.domain.members;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class StudentMember implements Member{
    private int borrowingAmountAllowed;

    private String memberId;
    private String name,surname,cellphone,telephone,suburb,city,province;
    private int zipCode;

    private StudentMember(){}
    public StudentMember(Builder builder){
        this.memberId = builder.memberId;
        this.name = builder.name;
        this.suburb = builder.suburb;
        this.surname = builder.surname;
        this.cellphone = builder.cellphone;
        this.telephone = builder.telephone;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;
        this.borrowingAmountAllowed = builder.borrowingAmountAllowed;
    }
    @Override
    public String getMemberId() {
        return memberId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSurname() {
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

    @Override
    public String getCellphone() {
        return null;
    }

    @Override
    public String getTelephone() {
        return null;
    }

    public static class Builder{
        private String memberId;
        private String name,surname,cellphone,telephone,suburb,city,province;
        private int zipCode;
        private int borrowingAmountAllowed;

        public Builder memberId(String id){
            this.memberId = memberId;
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
        public Builder cellphone(String val){
            this.cellphone = val;
            return this;
        }
        public Builder telephone(String val){
            this.telephone = val;
            return this;
        }
        public Builder zipCode(int code){
            this.zipCode = code;
            return this;
        }
        public Builder suburb(String val){
            this.suburb = val;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder province(String prov){
            this.province = prov;
            return this;
        }
        public Builder borrowingAmountAllowed(int amt){
            this.borrowingAmountAllowed = amt;
            return this;
        }
        public StudentMember build(){
            return new StudentMember(this);
        }
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "borrowingAmountAllowed=" + borrowingAmountAllowed +
                ", memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMember that = (StudentMember) o;
        return memberId.equals(that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
