package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentDemography;

import java.util.Date;

public class StudentDemographyFactory {
    public static StudentDemography createStudentDemography(String studentId, String raceId, String genderId, String studentTitle, Date dob){
        return new StudentDemography(studentId,raceId,genderId,studentTitle,dob);
    }
}
