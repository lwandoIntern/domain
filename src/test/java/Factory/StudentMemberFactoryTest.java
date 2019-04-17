package Factory;

import members.Member;
import members.StudentMember;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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