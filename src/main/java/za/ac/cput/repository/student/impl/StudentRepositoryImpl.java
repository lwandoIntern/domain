package za.ac.cput.repository.student.impl;

import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.student.StudentRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {
    private static StudentRepository studentRepository = null;
    private Set<Student> studentsDB;

    private StudentRepositoryImpl(){
        this.studentsDB = new HashSet<>();
    }

    public static StudentRepository getStudentRepository() {
        if (studentRepository == null)studentRepository = new StudentRepositoryImpl();
        return studentRepository;
    }
    private Student findStudent(String id){
        return this.studentsDB.stream()
                .filter(student -> student.getStudentId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Student create(Student student) {
        this.studentsDB.add(student);
        return student;
    }

    @Override
    public Student read(String s) {
        Student student = findStudent(s);
        return student;
    }

    @Override
    public Student update(Student student) {
        Student toDelete = findStudent(student.getStudentId());
        if (toDelete != null){
            this.studentsDB.remove( toDelete);
            return create(student);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Student student = findStudent(s);
        if (student != null)
            this.studentsDB.remove(student);
    }

    @Override
    public Set<Student> getAll() {
        return this.studentsDB;
    }
}
