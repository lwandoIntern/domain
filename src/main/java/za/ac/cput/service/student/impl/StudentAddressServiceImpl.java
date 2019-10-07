package za.ac.cput.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.service.student.StudentAddressService;


import java.util.HashSet;
import java.util.Set;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {
    private static StudentAddressService studentAddressService = null;
    @Autowired
    private StudentAddressRepository studentAddressRepository;

    private StudentAddressServiceImpl(){}

    public static StudentAddressService getStudentAddressService() {
        if (studentAddressService == null)studentAddressService = new StudentAddressServiceImpl();
        return studentAddressService;
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress) {
        this.studentAddressRepository.save(studentAddress);
        return read(studentAddress.getStudentEmail());
    }

    @Override
    public StudentAddress read(String s) {
        return this.studentAddressRepository.getOne(s);
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress) {
        StudentAddress studentAddress1 = read(studentAddress.getStudentEmail());
        if (studentAddress1 == studentAddress){
            delete(studentAddress1.getStudentEmail());
            return create(studentAddress);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.studentAddressRepository.deleteById(s);
    }

    @Override
    public Set<StudentAddress> getAll() {
        Set<StudentAddress> studentAddresses = new HashSet<>();
        studentAddresses.addAll(this.studentAddressRepository.findAll());
        return studentAddresses;
    }
}
