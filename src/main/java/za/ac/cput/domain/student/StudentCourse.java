package za.ac.cput.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentCourse implements Serializable {
    @Id
    @Column(name = "student_email")
    private String studentEmail;
    @Id
    @Column(name = "course_id")
    private String courseId;

    private StudentCourse(){}
    public StudentCourse(String studentEmail, String courseId) {
        this.studentEmail = studentEmail;
        this.courseId = courseId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        return studentEmail.equals(that.studentEmail) &&
                courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentEmail, courseId);
    }
}
