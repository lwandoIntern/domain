package za.ac.cput.domain.Factory;

import members.StudentMember;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentMemberFactoryTest {

    private StudentMember studentMember;
    @Before
    public void setUp() throws Exception {
        studentMember = StudentMemberFactory.createStudentMember(2);
    }

    @Test
    public void createStudentMember() {
        Assert.assertEquals(studentMember.getBorrowingAmountAllowed(),studentMember.getBorrowingAmountAllowed());
    }
}