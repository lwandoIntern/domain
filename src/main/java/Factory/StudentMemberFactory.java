package Factory;

import members.StudentMember;

public class StudentMemberFactory {
    public static StudentMember createStudentMember(int borrow){
        return new StudentMember.Builder()
                .borrowingAmountAllowed(borrow)
                .build();
    }
}
