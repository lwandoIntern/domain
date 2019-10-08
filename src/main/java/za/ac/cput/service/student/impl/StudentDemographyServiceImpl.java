package za.ac.cput.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentDemography;
import za.ac.cput.repository.student.StudentDemographyRepository;

import za.ac.cput.service.student.StudentDemographyService;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentDemographyServiceImpl implements StudentDemographyService {
    private static StudentDemographyService studentDemographyService = null;
    @Autowired
    private StudentDemographyRepository studentDemographyRepository;

    private StudentDemographyServiceImpl(){

    }

    public static StudentDemographyService getStudentDemographyService() {
        if (studentDemographyService == null)studentDemographyService = new StudentDemographyServiceImpl();
        return studentDemographyService;
    }

    @Override
    public StudentDemography create(StudentDemography studentDemography) {
        return this.studentDemographyRepository.save(studentDemography);
    }

    @Override
    public StudentDemography read(String s) {
        return this.studentDemographyRepository.getOne(s);
    }

    @Override
    public StudentDemography update(StudentDemography studentDemography) {
        return this.studentDemographyRepository.save(studentDemography);
    }

    @Override
    public void delete(String s) {
        this.studentDemographyRepository.deleteById(s);
    }

    @Override
    public Set<StudentDemography> getAll() {
        Set set = new HashSet();
        set.addAll(this.studentDemographyRepository.findAll());
        return set;
    }
}
