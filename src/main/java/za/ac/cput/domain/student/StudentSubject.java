package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentSubject implements Serializable {
    @Id
    @Column(name = "student_email")
    private String studentEmail;
    @Id
    @Column(name = "subject_id")
    private String subjectId;

    private StudentSubject(){}
    public StudentSubject(String studentEmail, String subjectId) {
        this.studentEmail = studentEmail;
        this.subjectId = subjectId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getSubjectId() {
        return subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSubject that = (StudentSubject) o;
        return studentEmail.equals(that.studentEmail) &&
                subjectId.equals(that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail, subjectId);
    }
}
