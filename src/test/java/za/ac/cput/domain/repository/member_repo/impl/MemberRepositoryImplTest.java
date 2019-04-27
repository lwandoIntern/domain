package za.ac.cput.domain.repository.member_repo.impl;

import members.Member;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Factory.RegularMemberFactory;
import za.ac.cput.domain.repository.member_repo.MemberRepository;

import static org.junit.Assert.*;

public class MemberRepositoryImplTest {

    private MemberRepository repository;
    private Member member;
    @Before
    public void setUp() throws Exception {
        repository = MemberRepositoryImpl.getRepository();
        member = RegularMemberFactory.createRegularMember("John","Sminorf0","0840147521","0217415566",
                7441,"MIL","CPT","WC");
    }

    @Test
    public void destroyAll() {
        repository.destroyAll();
    }

    @Test
    public void create() {
        assertEquals(repository.create(member),repository.create(member));
    }

    @Test
    public void read() {
        assertEquals(repository.read(member),repository.read(member));
    }

    @Test
    public void update() {
        assertEquals(repository.update(member),repository.update(member));
    }

    @Test
    public void delete() {
        repository.delete(member.getMemberId());
    }
}