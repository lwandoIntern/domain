package za.ac.cput.service.course.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.course.Course;
import za.ac.cput.repository.course.CourseRepository;
import za.ac.cput.repository.course.impl.CourseRepositoryImpl;
import za.ac.cput.service.course.CourseService;

import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    private static CourseService courseService = null;
    private CourseRepository courseRepository;

    private CourseServiceImpl(){
        this.courseRepository = CourseRepositoryImpl.getCourseRepository();
    }

    public static CourseService getCourseService() {
        if (courseService == null)courseService = new CourseServiceImpl();
        return courseService;
    }

    @Override
    public Course create(Course course) {
        return this.courseRepository.create(course);
    }

    @Override
    public Course read(String s) {
        return this.courseRepository.read(s);
    }

    @Override
    public Course update(Course course) {
        return this.courseRepository.update(course);
    }

    @Override
    public void delete(String s) {
        this.courseRepository.delete(s);
    }

    @Override
    public Set<Course> getAll() {
        return this.courseRepository.getAll();
    }

    @Override
    public Course getCourseByName(String courseName) {
        return this.courseRepository.getCourseByName(courseName);
    }
}
