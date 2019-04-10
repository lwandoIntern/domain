package model;

public class Staff {
    private String staffNum,name,lastName,phone,address,role;

    private Staff(){}
    public Staff(Builder builder){
        this.staffNum = builder.staffNum;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.address = builder.address;
        this.role = builder.role;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public static class Builder{
        private String staffNum,name,lastName,phone,address,role;

        public Builder staffNum(String value){
            this.staffNum = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }
        public Builder phone(String value){
            this.phone = value;
            return this;
        }
        public Builder address(String value){
            this.address = value;
            return this;
        }
        public Builder role(String value){
            this.role = value;
            return this;
        }
        public Builder copy(Staff emp){
            this.staffNum = emp.staffNum;
            this.name = emp.name;
            this.lastName =emp.lastName;
            this.phone = emp.phone;
            this.address = emp.address;
            this.role = emp.role;
            return this;
        }
        public Staff build(){
            return new Staff(this);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNum='" + staffNum + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
