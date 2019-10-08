package za.ac.cput.factory.student;

import za.ac.cput.domain.student.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {

    public static Student createStudent(String firstName,String lastName,int studyLevel){

        return new Student.Builder()

                .firstName(firstName)
                .lastName(lastName)
                .studyLevel(studyLevel)
                .build();
    }
}
