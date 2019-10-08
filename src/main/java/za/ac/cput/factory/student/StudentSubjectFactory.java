package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentSubject;

public class StudentSubjectFactory {
    public static StudentSubject createStudentSubject(String studentId, String subjectId){
        return new StudentSubject(studentId,subjectId);
    }
}
