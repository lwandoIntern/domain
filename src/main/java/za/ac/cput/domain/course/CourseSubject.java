package za.ac.cput.domain.course;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CourseSubject {
    @Id
    @Column(name = "course_id",nullable = false,columnDefinition = "VARCHAR(20)")
    private String courseId;
    private String subjectId;

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
        return courseId == that.courseId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, subjectId);
    }
}
