package za.ac.cput.factory.student;

import za.ac.cput.domain.student.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StudentFactory.class);
    public static Student createStudent(String firstName,String lastName,int studyLevel){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Student.Builder()
                .studentId(id)
                .firstName(firstName)
                .lastName(lastName)
                .studyLevel(studyLevel)
                .build();
    }
}
