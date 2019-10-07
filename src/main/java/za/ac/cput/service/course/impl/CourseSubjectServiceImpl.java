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

    private CourseSubjectServiceImpl(){}

    public static CourseSubjectService getCourseSubjectService() {
        if (courseSubjectService == null)courseSubjectService = new CourseSubjectServiceImpl();
        return courseSubjectService;
    }

    @Override
    public CourseSubject create(CourseSubject courseSubject) {
        this.courseSubjectRepository.save(courseSubject);
        return this.courseSubjectRepository.getOne(courseSubject.getCourseId());
    }

    @Override
    public CourseSubject read(String s) {
        return this.courseSubjectRepository.getOne(s);
    }

    @Override
    public CourseSubject update(CourseSubject courseSubject) {
        CourseSubject courseSubject1 = this.courseSubjectRepository.getOne(courseSubject.getCourseId());
        if (courseSubject1 == courseSubject){
            this.courseSubjectRepository.delete(courseSubject1);
            this.courseSubjectRepository.save(courseSubject);
            return this.courseSubjectRepository.getOne(courseSubject.getCourseId());
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.courseSubjectRepository.deleteById(s);
    }

    @Override
    public Set<CourseSubject> getAll() {
        Set<CourseSubject> courseSubjects = new HashSet<>();
        courseSubjects.addAll(this.courseSubjectRepository.findAll());
        return courseSubjects;
    }
}
