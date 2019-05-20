package za.ac.cput.domain.services.member.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Factory.member.RegularMemberFactory;
import za.ac.cput.domain.Factory.member.StudentMemberFactory;
import za.ac.cput.domain.domain.member.Member;

import static org.junit.Assert.*;

public class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl service;
    private Member member;
    @Before
    public void setUp() throws Exception {
        member = StudentMemberFactory.createStudentMember(2);
    }

    @Test(expected = NullPointerException.class)
    public void create() {
        assertEquals(service.create(member),service.create(member));
    }

    @Test(expected = NullPointerException.class)
    public void update() {
        assertNull(service.update(member));
    }

    @Test(expected = NullPointerException.class)
    public void delete() {
        service.delete(member.getMemberId());
    }

    @Test(expected = NullPointerException.class)
    public void read() {
        assertNotNull(service.read(member));
    }
}