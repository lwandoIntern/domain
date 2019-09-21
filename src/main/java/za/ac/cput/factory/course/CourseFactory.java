package za.ac.cput.factory.course;

import za.ac.cput.domain.course.Course;
import za.ac.cput.util.Helper;

public class CourseFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(CourseFactory.class);
    public static Course createCourse(String courseName,String type,int duration,int numOfSubjects){
        String id = Helper.generateRandomGivenSuffix(SUFFIX);
        return new Course.Builder()
                .courseId(id)
                .courseName(courseName)
                .courseType(type)
                .duration(duration)
                .numOfSubjects(numOfSubjects)
                .build();
    }
}
