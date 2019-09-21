package za.ac.cput.repository.course.impl;

import za.ac.cput.domain.course.Course;
import za.ac.cput.repository.course.CourseRepository;

import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {
    private static CourseRepository courseRepository = null;
    private Set<Course> courses;

    private CourseRepositoryImpl(){
        this.courses = new HashSet<>();
    }

    public static CourseRepository getCourseRepository() {
        if (courseRepository == null)courseRepository = new CourseRepositoryImpl();
        return courseRepository;
    }

    private Course findCourse(String s){
        return this.courses.stream()
                .filter(course -> course.getCourseId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public Course create(Course course) {
        this.courses.add(course);
        return course;
    }

    @Override
    public Course read(String s) {
        Course course = findCourse(s);
        return course;
    }

    @Override
    public Course update(Course course) {
        Course toDelete = findCourse(course.getCourseId());
        if (toDelete != null){
            this.courses.remove(toDelete);
            return create(course);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Course course = findCourse(s);
        if (course != null)this.courses.remove(course);
    }

    @Override
    public Set<Course> getAll() {
        return this.courses;
    }
}
