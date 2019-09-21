package za.ac.cput.service.student.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentDemography;
import za.ac.cput.repository.student.StudentDemographyRepository;
import za.ac.cput.repository.student.impl.StudentDemographyRepositoryImpl;
import za.ac.cput.service.student.StudentDemographyService;

import java.util.Set;

@Service
public class StudentDemographyServiceImpl implements StudentDemographyService {
    private static StudentDemographyService studentDemographyService = null;
    private StudentDemographyRepository studentDemographyRepository;

    private StudentDemographyServiceImpl(){
        this.studentDemographyRepository = StudentDemographyRepositoryImpl.getStudentDemographyRepository();
    }

    public static StudentDemographyService getStudentDemographyService() {
        if (studentDemographyService == null)studentDemographyService = new StudentDemographyServiceImpl();
        return studentDemographyService;
    }

    @Override
    public StudentDemography create(StudentDemography studentDemography) {
        return this.studentDemographyRepository.create(studentDemography);
    }

    @Override
    public StudentDemography read(String s) {
        return this.studentDemographyRepository.read(s);
    }

    @Override
    public StudentDemography update(StudentDemography studentDemography) {
        return this.studentDemographyRepository.update(studentDemography);
    }

    @Override
    public void delete(String s) {
        this.studentDemographyRepository.delete(s);
    }

    @Override
    public Set<StudentDemography> getAll() {
        return this.studentDemographyRepository.getAll();
    }
}
