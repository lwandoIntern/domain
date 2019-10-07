package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentDemography implements Serializable {
    @Id
    @Column(name = "student_email")
    private String studentEmail;
    @Id
    @Column(name = "race_id")
    private String raceId;
    @Id
    @Column(name = "gender_id")
    private String genderId;

    private StudentDemography(){}
    public StudentDemography(String studentEmail, String raceId, String genderId) {
        this.studentEmail = studentEmail;
        this.raceId = raceId;
        this.genderId = genderId;
    }

    public String getStudentEmail() {
        return studentEmail;
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
        return studentEmail.equals(that.studentEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail);
    }

    @Override
    public String toString() {
        return "StudentDemography{" +
                "studentId='" + studentEmail + '\'' +
                ", raceId='" + raceId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
