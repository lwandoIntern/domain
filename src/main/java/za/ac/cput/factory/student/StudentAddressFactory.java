package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress createStudentAddress(String studentId,String addressId){
        return new StudentAddress(studentId,addressId);
    }
}
