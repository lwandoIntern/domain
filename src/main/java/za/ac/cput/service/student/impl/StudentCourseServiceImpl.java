package za.ac.cput.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentCourse;
import za.ac.cput.repository.student.StudentCourseRepository;

import za.ac.cput.service.student.StudentCourseService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private static StudentCourseService studentCourseService = null;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    private StudentCourseServiceImpl(){

    }

    public static StudentCourseService getStudentCourseService() {
        if (studentCourseService == null)studentCourseService = new StudentCourseServiceImpl();
        return studentCourseService;
    }

    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        return this.studentCourseRepository.save(studentCourse);
    }

    @Override
    public StudentCourse read(String s) {
        return this.studentCourseRepository.getOne(s);
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        return this.studentCourseRepository.save(studentCourse);
    }

    @Override
    public void delete(String s) {
        this.studentCourseRepository.deleteById(s);
    }

    @Override
    public Set<StudentCourse> getAll() {
        Set set = new HashSet();
        set.addAll(this.studentCourseRepository.findAll());
        return set;
    }
}
