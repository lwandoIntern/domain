package za.ac.cput.repository.course.impl;

import za.ac.cput.domain.course.CourseSubject;
import za.ac.cput.repository.course.CourseSubjectRepository;

import java.util.HashSet;
import java.util.Set;

public class CourseSubjectRepositoryImpl implements CourseSubjectRepository {
    private static CourseSubjectRepository courseSubjectRepository = null;
    private Set<CourseSubject> courseSubjects;

    private CourseSubjectRepositoryImpl(){
        this.courseSubjects = new HashSet<>();
    }

    public static CourseSubjectRepository getCourseSubjectRepository() {
        if (courseSubjectRepository == null)courseSubjectRepository = new CourseSubjectRepositoryImpl();
        return courseSubjectRepository;
    }

    private CourseSubject findCourseSubject(String s){
        return this.courseSubjects.stream()
                .filter(courseSubject -> courseSubject.getCourseId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public CourseSubject create(CourseSubject courseSubject) {
        this.courseSubjects.add(courseSubject);
        return courseSubject;
    }

    @Override
    public CourseSubject read(String s) {
        CourseSubject courseSubject = findCourseSubject(s);
        return courseSubject;
    }

    @Override
    public CourseSubject update(CourseSubject courseSubject) {
        CourseSubject toDelete = findCourseSubject(courseSubject.getCourseId());
        if (toDelete != null){
            this.courseSubjects.remove(toDelete);
            return create(courseSubject);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        CourseSubject courseSubject = findCourseSubject(s);
        if (courseSubject != null)this.courseSubjects.remove(courseSubject);
    }

    @Override
    public Set<CourseSubject> getAll() {
        return this.courseSubjects;
    }
}
