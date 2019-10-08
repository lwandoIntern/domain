package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentDemography;

public class StudentDemographyFactory {
    public static StudentDemography createStudentDemography(String studentId, String raceId, String genderId){
        return new StudentDemography(studentId,raceId,genderId);
    }
}
