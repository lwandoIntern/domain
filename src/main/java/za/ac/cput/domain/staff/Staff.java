package za.ac.cput.domain.staff;

import java.util.Objects;

public class Staff {
    private String staffNum,name,surname;

    public Staff(Builder builder) {
        this.staffNum = builder.staffNum;
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffNum.equals(staff.staffNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNum);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNum='" + staffNum + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    public static class Builder{
        private String staffNum,name,surname;
        public Builder staffNum(String staffId){
            this.staffNum = staffId;
            return this;
        }
        public Builder name(String firstName){
            this.name = firstName;
            return this;
        }
        public Builder surname(String lastName){
            this.surname = lastName;
            return this;
        }
        public Staff build(){
            return new Staff(this);
        }
    }
}
