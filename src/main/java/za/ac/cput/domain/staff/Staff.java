package za.ac.cput.domain.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Staff implements Serializable {
    @Id
    @Column(name = "staff_number")
    private String staffNum;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;


    private Staff(){}
    public Staff(Builder builder) {
        this.staffNum = builder.staffNum;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password = builder.password;
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
    public String getPassword() {
        return password;
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
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String staffNum,name,surname,password;
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
        public Builder password(String psw){
            this.password = psw;
            return this;
        }
        public Staff build(){
            return new Staff(this);
        }
    }
}
