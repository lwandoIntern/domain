package za.ac.cput.domain.course;

import java.util.Objects;

public class CourseSubject {
    private String courseId,subjectId;

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
