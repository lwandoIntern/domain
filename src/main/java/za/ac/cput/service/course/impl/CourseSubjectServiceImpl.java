package za.ac.cput.service.course.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.course.CourseSubject;
import za.ac.cput.repository.course.CourseSubjectRepository;
import za.ac.cput.repository.course.impl.CourseSubjectRepositoryImpl;
import za.ac.cput.service.course.CourseSubjectService;

import java.util.Set;

@Service
public class CourseSubjectServiceImpl implements CourseSubjectService {
    private static CourseSubjectService courseSubjectService = null;
    private CourseSubjectRepository courseSubjectRepository;

    private CourseSubjectServiceImpl(){
        this.courseSubjectRepository = CourseSubjectRepositoryImpl.getCourseSubjectRepository();
    }

    public static CourseSubjectService getCourseSubjectService() {
        if (courseSubjectService == null)courseSubjectService = new CourseSubjectServiceImpl();
        return courseSubjectService;
    }

    @Override
    public CourseSubject create(CourseSubject courseSubject) {
        return this.courseSubjectRepository.create(courseSubject);
    }

    @Override
    public CourseSubject read(String s) {
        return this.courseSubjectRepository.read(s);
    }

    @Override
    public CourseSubject update(CourseSubject courseSubject) {
        return this.courseSubjectRepository.update(courseSubject);
    }

    @Override
    public void delete(String s) {
        this.courseSubjectRepository.delete(s);
    }

    @Override
    public Set<CourseSubject> getAll() {
        return this.courseSubjectRepository.getAll();
    }
}
