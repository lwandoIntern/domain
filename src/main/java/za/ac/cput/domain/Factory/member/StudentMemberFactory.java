package za.ac.cput.domain.Factory.member;

import za.ac.cput.domain.domain.members.StudentMember;

public class StudentMemberFactory {
    public static StudentMember createStudentMember(int borrow){
        return new StudentMember.Builder()
                .borrowingAmountAllowed(borrow)
                .build();
    }
}