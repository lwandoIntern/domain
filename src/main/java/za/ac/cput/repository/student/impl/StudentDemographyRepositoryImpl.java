package za.ac.cput.repository.student.impl;

import za.ac.cput.domain.student.Student;
import za.ac.cput.domain.student.StudentDemography;
import za.ac.cput.repository.student.StudentDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentDemographyRepositoryImpl implements StudentDemographyRepository {
    private static StudentDemographyRepository studentDemographyRepository = null;
    private Set<StudentDemography> studentDemographiesDB;

    private StudentDemographyRepositoryImpl(){
        this.studentDemographiesDB = new HashSet<>();
    }

    public static StudentDemographyRepository getStudentDemographyRepository() {
        if (studentDemographyRepository == null)studentDemographyRepository = new StudentDemographyRepositoryImpl();
        return studentDemographyRepository;
    }
    private StudentDemography findStudentDemography(String id){
        return this.studentDemographiesDB.stream()
                .filter(studentDemography -> studentDemography.getStudentId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public StudentDemography create(StudentDemography studentDemography) {
        this.studentDemographiesDB.add(studentDemography);
        return studentDemography;
    }

    @Override
    public StudentDemography read(String s) {
        StudentDemography studentDemography = findStudentDemography(s);
        return studentDemography;
    }

    @Override
    public StudentDemography update(StudentDemography studentDemography) {
        StudentDemography toDelete = findStudentDemography(studentDemography.getStudentId());
        if (toDelete != null){
            this.studentDemographiesDB.remove(toDelete);
            return create(studentDemography);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StudentDemography studentDemography = findStudentDemography(s);
        if (studentDemography != null)this.studentDemographiesDB.remove(studentDemography);
    }

    @Override
    public Set<StudentDemography> getAll() {
        return this.studentDemographiesDB;
    }
}
