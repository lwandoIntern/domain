package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentCourse;

public class StudentCourseFactory {
    public static StudentCourse createStudentCourse(String studentId,String courseId){
        return new StudentCourse(studentId,courseId);
    }
}
