package za.ac.cput.factory.subject;

import za.ac.cput.domain.subject.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SubjectFactory.class);
    public static Subject createSubject(String subjectName,String priority,String prerequisite,int duration){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Subject.Builder()
                .subjectId(id)
                .subjectName(subjectName)
                .priority(priority)
                .prerequisite(prerequisite)
                .duration(duration)
                .build();
    }
}
