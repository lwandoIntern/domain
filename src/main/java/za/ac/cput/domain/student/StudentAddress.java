package za.ac.cput.domain.student;

import java.util.Objects;

public class StudentAddress {
    private String studentId,addressId;

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
        return studentId.equals(that.studentId) &&
                addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, addressId);
    }
}
