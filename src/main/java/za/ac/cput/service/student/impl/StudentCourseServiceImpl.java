package za.ac.cput.service.student.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentCourse;
import za.ac.cput.repository.student.StudentCourseRepository;
import za.ac.cput.repository.student.impl.StudentCourseRepositoryImpl;
import za.ac.cput.service.student.StudentCourseService;

import java.util.Set;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private static StudentCourseService studentCourseService = null;
    private StudentCourseRepository studentCourseRepository;

    private StudentCourseServiceImpl(){
        this.studentCourseRepository = StudentCourseRepositoryImpl.getStudentCourseRepository();
    }

    public static StudentCourseService getStudentCourseService() {
        if (studentCourseService == null)studentCourseService = new StudentCourseServiceImpl();
        return studentCourseService;
    }

    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        return this.studentCourseRepository.create(studentCourse);
    }

    @Override
    public StudentCourse read(String s) {
        return this.studentCourseRepository.read(s);
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        return this.studentCourseRepository.update(studentCourse);
    }

    @Override
    public void delete(String s) {
        this.studentCourseRepository.delete(s);
    }

    @Override
    public Set<StudentCourse> getAll() {
        return this.studentCourseRepository.getAll();
    }
}
