package za.ac.cput.domain.student;

import java.util.Date;
import java.util.Objects;

public class StudentDemography {
    private String studentId,raceId,genderId;

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
        return studentId.equals(that.studentId);
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
