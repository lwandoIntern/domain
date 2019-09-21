package za.ac.cput.repository.student.impl;

import za.ac.cput.domain.student.StudentSubject;
import za.ac.cput.repository.student.StudentSubjectRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentSubjectRepositoryImpl implements StudentSubjectRepository {
    private static StudentSubjectRepository studentSubjectRepository = null;
    private Set<StudentSubject> studentSubjectsDB;

    private StudentSubjectRepositoryImpl(){
        this.studentSubjectsDB = new HashSet<>();
    }

    public static StudentSubjectRepository getStudentSubjectRepository() {
        if (studentSubjectRepository == null)studentSubjectRepository = new StudentSubjectRepositoryImpl();
        return studentSubjectRepository;
    }
    private StudentSubject findStudentSubject(String id){
        return this.studentSubjectsDB.stream()
                .filter(studentSubject -> studentSubject.getStudentId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
    @Override
    public StudentSubject create(StudentSubject studentSubject) {
        this.studentSubjectsDB.add(studentSubject);
        return studentSubject;
    }

    @Override
    public StudentSubject read(String s) {
        StudentSubject studentSubject = findStudentSubject(s);
        return studentSubject;
    }

    @Override
    public StudentSubject update(StudentSubject studentSubject) {
        StudentSubject toDelete = findStudentSubject(studentSubject.getStudentId());
        if (toDelete != null){
            this.studentSubjectsDB.remove(toDelete);
            return create(studentSubject);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StudentSubject studentSubject = findStudentSubject(s);
        if (studentSubject != null)this.studentSubjectsDB.remove(studentSubject);
    }

    @Override
    public Set<StudentSubject> getAll() {
        return this.studentSubjectsDB;
    }
}
