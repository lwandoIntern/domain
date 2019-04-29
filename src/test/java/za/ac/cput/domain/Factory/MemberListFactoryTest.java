package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.member.MemberListFactory;
import za.ac.cput.domain.domain.members.Member;
import za.ac.cput.domain.domain.members.MemberList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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