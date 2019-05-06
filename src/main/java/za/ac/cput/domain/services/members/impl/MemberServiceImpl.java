package za.ac.cput.domain.services.members.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.members.Member;
import za.ac.cput.domain.repository.member_repo.impl.MemberRepositoryImpl;
import za.ac.cput.domain.services.members.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    private static MemberServiceImpl service = null;
    private MemberRepositoryImpl repository;

    private MemberServiceImpl(){
        this.repository = MemberRepositoryImpl.getRepository();
    }
    public static MemberServiceImpl getService(){
        if (service == null)service = new MemberServiceImpl();
        return service;
    }
    @Override
    public Member create(Member member) {
        return this.repository.create(member);
    }

    @Override
    public Member update(Member member) {
        return this.repository.update(member);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Member read(Member member) {
        return this.repository.read(member);
    }
}
