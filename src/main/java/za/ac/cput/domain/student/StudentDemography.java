package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StudentDemography {
    @Id
    @Column(name = "student_id",nullable = false,columnDefinition = "VARCHAR(8)")
    private String studentId;
    private String raceId;
    private String genderId;

    public StudentDemography(String studentId, String raceId, String genderId) {
        this.studentId = studentId;
        this.raceId = raceId;
        this.genderId = genderId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDemography that = (StudentDemography) o;
        return studentId == that.studentId &&
                raceId == that.raceId &&
                genderId == that.genderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "StudentDemography{" +
                "studentId='" + studentId + '\'' +
                ", raceId='" + raceId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
