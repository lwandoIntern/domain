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
        this.studentRepository.save(student);
        return read(student.getStudentEmail());
    }

    @Override
    public Student read(String s) {
        return this.studentRepository.getOne(s);
    }

    @Override
    public Student update(Student student) {
        Student student1 = read(student.getStudentEmail());
        if (student1 == student){
            delete(student1.getStudentEmail());
            return create(student);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.studentRepository.deleteById(s);
    }

    @Override
    public Set<Student> getAll() {
        Set<Student> students = new HashSet<>();
        students.addAll(this.studentRepository.findAll());
        return students;
    }
}
