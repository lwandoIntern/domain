package za.ac.cput.service.course.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.course.Course;
import za.ac.cput.repository.course.CourseRepository;
import za.ac.cput.service.course.CourseService;


import java.util.HashSet;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    private static CourseService courseService = null;
    @Autowired
    private CourseRepository courseRepository;

    private CourseServiceImpl(){}

    public static CourseService getCourseService() {
        if (courseService == null)courseService = new CourseServiceImpl();
        return courseService;
    }

    @Override
    public Course create(Course course) {
        this.courseRepository.save(course);
        return this.courseRepository.getOne(course.getCourseId());
    }

    @Override
    public Course read(String s) {
        return this.courseRepository.getOne(s);
    }

    @Override
    public Course update(Course course) {
        Course course1 = read(course.getCourseId());
        if (course1 == course){
            this.courseRepository.delete(course1);
            this.courseRepository.save(course);
            return this.courseRepository.getOne(course.getCourseId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.courseRepository.deleteById(s);
    }

    @Override
    public Set<Course> getAll() {
        Set<Course> courses = new HashSet<>();
        courses.addAll(this.courseRepository.findAll());
        return courses;
    }

    @Override
    public Course getCourseByName(String courseName) {
        return getAll().stream()
                .filter(course -> course.getCourseName().equalsIgnoreCase(courseName))
                .findAny()
                .get();
    }
}
