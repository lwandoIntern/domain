package za.ac.cput.service.course.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.course.CourseSubject;
import za.ac.cput.repository.course.CourseSubjectRepository;

import za.ac.cput.service.course.CourseSubjectService;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseSubjectServiceImpl implements CourseSubjectService {
    private static CourseSubjectService courseSubjectService = null;
    @Autowired
    private CourseSubjectRepository courseSubjectRepository;

    private CourseSubjectServiceImpl(){

    }

    public static CourseSubjectService getCourseSubjectService() {
        if (courseSubjectService == null)courseSubjectService = new CourseSubjectServiceImpl();
        return courseSubjectService;
    }


    @Override
    public CourseSubject create(CourseSubject courseSubject) {
        return this.courseSubjectRepository.save(courseSubject);
    }

    @Override
    public CourseSubject read(String s) {
        return this.courseSubjectRepository.getOne(s);
    }

    @Override
    public CourseSubject update(CourseSubject courseSubject) {
        return this.courseSubjectRepository.save(courseSubject);
    }

    @Override
    public void delete(String s) {
        this.courseSubjectRepository.deleteById(s);
    }

    @Override
    public Set<CourseSubject> getAll() {
        Set set = new HashSet();
        set.addAll(this.courseSubjectRepository.findAll());
        return set;
    }
}
