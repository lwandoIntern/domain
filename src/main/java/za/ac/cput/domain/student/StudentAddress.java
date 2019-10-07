package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress implements Serializable {
    @Id
    @Column(name = "student_email")
    private String studentEmail;
    @Id
    @Column(name = "address_id")
    private String addressId;

    private StudentAddress(){}
    public StudentAddress(String studentId, String addressId) {
        this.studentEmail = studentId;
        this.addressId = addressId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentEmail.equals(that.studentEmail) &&
                addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail, addressId);
    }
}
