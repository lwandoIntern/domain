package za.ac.cput.domain.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class CourseSubject implements Serializable {
    @Id
    @Column(name = "course_id")
    private String courseId;
    @Id
    @Column(name = "subject_id")
    private String subjectId;

    private CourseSubject(){}
    public CourseSubject(String courseId, String subjectId) {
        this.courseId = courseId;
        this.subjectId = subjectId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSubject that = (CourseSubject) o;
        return courseId.equals(that.courseId) &&
                subjectId.equals(that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, subjectId);
    }
}
