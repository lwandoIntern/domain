package za.ac.cput.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentSubject;
import za.ac.cput.repository.student.StudentSubjectRepository;

import za.ac.cput.service.student.StudentSubjectService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {
    private static StudentSubjectService studentSubjectService = null;
    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    private StudentSubjectServiceImpl(){

    }

    public static StudentSubjectService getStudentSubjectService() {
        if (studentSubjectService == null)studentSubjectService = new StudentSubjectServiceImpl();
        return studentSubjectService;
    }


    @Override
    public StudentSubject create(StudentSubject studentSubject) {
        return this.studentSubjectRepository.save(studentSubject);
    }

    @Override
    public StudentSubject read(String s) {
        return this.studentSubjectRepository.getOne(s);
    }

    @Override
    public StudentSubject update(StudentSubject studentSubject) {
        return this.studentSubjectRepository.save(studentSubject);
    }

    @Override
    public void delete(String s) {
        this.studentSubjectRepository.deleteById(s);
    }

    @Override
    public Set<StudentSubject> getAll() {
        Set set = new HashSet();
        set.addAll(this.studentSubjectRepository.findAll());
        return set;
    }
}
