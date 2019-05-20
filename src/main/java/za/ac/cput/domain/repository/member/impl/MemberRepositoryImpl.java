package za.ac.cput.domain.repository.member.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.repository.member.MemberRepository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private static MemberRepositoryImpl repository = null;
    private Collection<Member> collection;

    private MemberRepositoryImpl(){
        this.collection = new ArrayList<>();
    }

    public static MemberRepositoryImpl getRepository() {
        if (repository == null)repository = new MemberRepositoryImpl();
        return repository;
    }

    @Override
    public void destroyAll() {
         repository.collection.removeAll(collection);
    }

    @Override
    public Member create(Member member) {
         repository.collection.add(member);
         return member;
    }

    @Override
    public Member read(Member member) {
        if (repository.collection.contains(member)) {

        }
        return member;
    }

    @Override
    public Member update(Member member) {
        repository.collection.add(member);
        return member;
    }

    @Override
    public void delete(String s) {
        repository.collection.remove(s);
    }
}
