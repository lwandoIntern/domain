package za.ac.cput.service.student.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentSubject;
import za.ac.cput.repository.student.StudentSubjectRepository;
import za.ac.cput.repository.student.impl.StudentSubjectRepositoryImpl;
import za.ac.cput.service.student.StudentSubjectService;

import java.util.Set;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {
    private static StudentSubjectService studentSubjectService = null;
    private StudentSubjectRepository studentSubjectRepository;

    private StudentSubjectServiceImpl(){
        this.studentSubjectRepository = StudentSubjectRepositoryImpl.getStudentSubjectRepository();
    }

    public static StudentSubjectService getStudentSubjectService() {
        if (studentSubjectService == null)studentSubjectService = new StudentSubjectServiceImpl();
        return studentSubjectService;
    }

    @Override
    public StudentSubject create(StudentSubject studentSubject) {
        return this.studentSubjectRepository.create(studentSubject);
    }

    @Override
    public StudentSubject read(String s) {
        return this.studentSubjectRepository.read(s);
    }

    @Override
    public StudentSubject update(StudentSubject studentSubject) {
        return this.studentSubjectRepository.update(studentSubject);
    }

    @Override
    public void delete(String s) {
        this.studentSubjectRepository.delete(s);
    }

    @Override
    public Set<StudentSubject> getAll() {
        return this.studentSubjectRepository.getAll();
    }
}
