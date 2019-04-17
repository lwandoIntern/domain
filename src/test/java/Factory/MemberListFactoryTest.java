package Factory;

import members.Member;
import members.MemberList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberListFactoryTest {

    private MemberList memberList;
    private ArrayList<Member> members;
    @Before
    public void setUp() throws Exception {
        memberList = MemberListFactory.createMemberList(members);
    }

    @Test
    public void createMemberList() {
        Assert.assertEquals(memberList.getMembers(),memberList.getMembers());
    }
}