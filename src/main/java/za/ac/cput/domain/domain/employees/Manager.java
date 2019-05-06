package za.ac.cput.domain.domain.employees;

import javax.persistence.Entity;
import java.util.Objects;


public class Manager implements Employee{
    private String employeeId,name,surname,cellphone,telephone,city,suburb,province,positionName;
    private boolean hasSubordinates,hasSuperior;
    private int zipCode;

    private Manager(){}
    public Manager(Builder builder){
        this.employeeId = builder.employeeId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.cellphone = builder.cellphone;
        this.telephone = builder.telephone;
        this.zipCode = builder.zipCode;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
        this.positionName = builder.positionName;
        this.hasSubordinates = builder.hasSubordinates;
        this.hasSuperior = builder.hasSuperior;
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

    @Override
    public String getPosition() {
        return positionName;
    }

    @Override
    public boolean isSuperior() {
        return hasSuperior;
    }

    @Override
    public boolean isSubordinates() {
        return hasSubordinates;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    public static class Builder{
        private String employeeId,name,surname,cellphone,telephone,city,suburb,province,positionName;
        private boolean hasSuperior,hasSubordinates;
        private int zipCode;

        public Builder employeeId(String value){
            this.employeeId = value;
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
        public Builder positionName(String val){
            this.positionName = val;
            return this;
        }
        public Builder hasSuperior(boolean v){
            this.hasSuperior = v;
            return this;
        }
        public Builder hasSubordinates(boolean v){
            this.hasSubordinates = v;
            return this;
        }
        public Manager build(){
            return new Manager(this);
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                ", suburb='" + suburb + '\'' +
                ", province='" + province + '\'' +
                ", positionName='" + positionName + '\'' +
                ", hasSubordinates=" + hasSubordinates +
                ", hasSuperior=" + hasSuperior +
                ", zipCode=" + zipCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return employeeId.equals(manager.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
