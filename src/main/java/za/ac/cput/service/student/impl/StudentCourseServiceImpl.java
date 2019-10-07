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

    private StudentCourseServiceImpl(){}

    public static StudentCourseService getStudentCourseService() {
        if (studentCourseService == null)studentCourseService = new StudentCourseServiceImpl();
        return studentCourseService;
    }

    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        this.studentCourseRepository.save(studentCourse);
        return read(studentCourse.getStudentEmail());
    }

    @Override
    public StudentCourse read(String s) {
        return this.studentCourseRepository.getOne(s);
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        StudentCourse studentCourse1 = read(studentCourse.getStudentEmail());
        if (studentCourse1 == studentCourse){
            delete(studentCourse1.getStudentEmail());
            return create(studentCourse);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.studentCourseRepository.deleteById(s);
    }

    @Override
    public Set<StudentCourse> getAll() {
        Set<StudentCourse> studentCourses = new HashSet<>();
        studentCourses.addAll(this.studentCourseRepository.findAll());
        return studentCourses;
    }
}
