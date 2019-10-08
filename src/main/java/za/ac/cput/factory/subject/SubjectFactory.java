package za.ac.cput.factory.subject;

import za.ac.cput.domain.subject.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {

    public static Subject createSubject(String subjectName,String priority,String prerequisite,int duration){

        return new Subject.Builder()

                .subjectName(subjectName)
                .priority(priority)
                .prerequisite(prerequisite)
                .duration(duration)
                .build();
    }
}
