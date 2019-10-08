package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StudentSubject {
    @Id
    @Column(name = "student_id",nullable = false,columnDefinition = "VARCHAR(8)")
    private String studentId;
    private String subjectId;

    public StudentSubject(String studentId, String subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSubject that = (StudentSubject) o;
        return studentId == that.studentId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId);
    }
}
