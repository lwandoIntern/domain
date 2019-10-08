package za.ac.cput.factory.course;

import za.ac.cput.domain.course.CourseSubject;

public class CourseSubjectFactory {
    public static CourseSubject createCourseSubject(String courseId, String subjectId){
        return new CourseSubject(courseId,subjectId);
    }
}
