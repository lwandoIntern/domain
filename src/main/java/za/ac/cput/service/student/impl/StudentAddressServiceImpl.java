package za.ac.cput.service.student.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.repository.student.impl.StudentAddressRepositoryImpl;
import za.ac.cput.service.student.StudentAddressService;

import java.util.Set;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {
    private static StudentAddressService studentAddressService = null;
    private StudentAddressRepository studentAddressRepository;

    private StudentAddressServiceImpl(){
        this.studentAddressRepository = StudentAddressRepositoryImpl.getStudentAddressRepository();
    }

    public static StudentAddressService getStudentAddressService() {
        if (studentAddressService == null)studentAddressService = new StudentAddressServiceImpl();
        return studentAddressService;
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress) {
        return this.studentAddressRepository.create(studentAddress);
    }

    @Override
    public StudentAddress read(String s) {
        return this.studentAddressRepository.read(s);
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress) {
        return this.studentAddressRepository.update(studentAddress);
    }

    @Override
    public void delete(String s) {
        this.studentAddressRepository.delete(s);
    }

    @Override
    public Set<StudentAddress> getAll() {
        return this.studentAddressRepository.getAll();
    }
}
