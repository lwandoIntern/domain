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

    private StudentDemographyServiceImpl(){}

    public static StudentDemographyService getStudentDemographyService() {
        if (studentDemographyService == null)studentDemographyService = new StudentDemographyServiceImpl();
        return studentDemographyService;
    }

    @Override
    public StudentDemography create(StudentDemography studentDemography) {
        this.studentDemographyRepository.save(studentDemography);
        return read(studentDemography.getStudentEmail());
    }

    @Override
    public StudentDemography read(String s) {
        return this.studentDemographyRepository.getOne(s);
    }

    @Override
    public StudentDemography update(StudentDemography studentDemography) {
        StudentDemography studentDemography1 = read(studentDemography.getStudentEmail());
        if (studentDemography1 == studentDemography){
            delete(studentDemography1.getStudentEmail());
            return create(studentDemography);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.studentDemographyRepository.deleteById(s);
    }

    @Override
    public Set<StudentDemography> getAll() {
        Set<StudentDemography> studentDemographies = new HashSet<>();
        studentDemographies.addAll(this.studentDemographyRepository.findAll());
        return studentDemographies;
    }
}
