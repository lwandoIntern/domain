package za.ac.cput.factory.course;

import za.ac.cput.domain.course.Course;
import za.ac.cput.util.Helper;

public class CourseFactory {

    public static Course createCourse(String courseName,String type,int duration,int numOfSubjects){

        return new Course.Builder()

                .courseName(courseName)
                .courseType(type)
                .duration(duration)
                .numOfSubjects(numOfSubjects)
                .build();
    }
}
