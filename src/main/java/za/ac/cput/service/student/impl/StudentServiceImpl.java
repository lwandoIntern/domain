package za.ac.cput.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.student.StudentRepository;

import za.ac.cput.service.student.StudentService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
    private static StudentService studentService = null;
    @Autowired
    private StudentRepository studentRepository;

    private StudentServiceImpl(){}

    public static StudentService getStudentService() {
        if (studentService == null)studentService = new StudentServiceImpl();
        return studentService;
    }


    @Override
    public Student create(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student read(String s) {
        return this.studentRepository.getOne(s);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public void delete(String s) {
        this.studentRepository.deleteById(s);
    }

    @Override
    public Set<Student> getAll() {
        Set set = new HashSet();
        set.addAll(this.studentRepository.findAll());
        return set;
    }
}
