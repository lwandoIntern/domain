package za.ac.cput.domain.student;

import java.util.Date;
import java.util.Objects;

public class StudentDemography {
    private String studentId,raceId,genderId,studentTitle;
    private Date dateOfBirth;

    public StudentDemography(String studentId, String raceId, String genderId, String studentTitle, Date dateOfBirth) {
        this.studentId = studentId;
        this.raceId = raceId;
        this.genderId = genderId;
        this.studentTitle = studentTitle;
        this.dateOfBirth = dateOfBirth;
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

    public String getStudentTitle() {
        return studentTitle;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
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
                ", studentTitle='" + studentTitle + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
