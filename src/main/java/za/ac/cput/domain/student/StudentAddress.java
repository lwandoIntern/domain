package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class StudentAddress {
    @Id
    @Column(name = "student_id",nullable = false,columnDefinition = "VARCHAR(8)")
    private String studentId;
    private String addressId;

    public StudentAddress(String studentId, String addressId) {
        this.studentId = studentId;
        this.addressId = addressId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId == that.studentId &&
                addressId == that.addressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, addressId);
    }
}
