package za.ac.cput.service.student.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.student.StudentRepository;
import za.ac.cput.repository.student.impl.StudentRepositoryImpl;
import za.ac.cput.service.student.StudentService;

import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
    private static StudentService studentService = null;
    private StudentRepository studentRepository;

    private StudentServiceImpl(){
        this.studentRepository = StudentRepositoryImpl.getStudentRepository();
    }

    public static StudentService getStudentService() {
        if (studentService == null)studentService = new StudentServiceImpl();
        return studentService;
    }

    @Override
    public Student create(Student student) {
        return this.studentRepository.create(student);
    }

    @Override
    public Student read(String s) {
        return this.studentRepository.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.update(student);
    }

    @Override
    public void delete(String s) {
        this.studentRepository.delete(s);
    }

    @Override
    public Set<Student> getAll() {
        return this.studentRepository.getAll();
    }
}
