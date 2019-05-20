package za.ac.cput.domain.services.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.repository.member.impl.MemberRepositoryImpl;
import za.ac.cput.domain.services.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepositoryImpl repository;

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
