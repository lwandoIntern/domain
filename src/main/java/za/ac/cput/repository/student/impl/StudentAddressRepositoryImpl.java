package za.ac.cput.repository.student.impl;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentAddressRepositoryImpl implements StudentAddressRepository {
    private static StudentAddressRepository studentAddressRepository = null;
    private Set<StudentAddress> studentAddressesDB;

    private StudentAddressRepositoryImpl(){
        this.studentAddressesDB = new HashSet<>();
    }

    public static StudentAddressRepository getStudentAddressRepository() {
        if (studentAddressRepository == null)studentAddressRepository = new StudentAddressRepositoryImpl();
        return studentAddressRepository;
    }
    private StudentAddress findStudentAddress(String id){
        return this.studentAddressesDB.stream()
                .filter(studentAddress -> studentAddress.getStudentId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress) {
        this.studentAddressesDB.add(studentAddress);
        return studentAddress;
    }

    @Override
    public StudentAddress read(String s) {
        StudentAddress studentAddress = findStudentAddress(s);
        return studentAddress;
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress) {
        StudentAddress toDelete = findStudentAddress(studentAddress.getStudentId());
        if (toDelete != null){
            this.studentAddressesDB.remove(toDelete);
            return create(studentAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        StudentAddress studentAddress = findStudentAddress(s);
        if (studentAddress != null)this.studentAddressesDB.remove(studentAddress);
    }

    @Override
    public Set<StudentAddress> getAll() {
        return this.studentAddressesDB;
    }
}
