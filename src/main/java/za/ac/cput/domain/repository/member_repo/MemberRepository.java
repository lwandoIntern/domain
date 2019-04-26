package za.ac.cput.domain.repository.member_repo;

import members.Member;
import za.ac.cput.domain.repository.Repository;

import java.util.Collection;

public interface MemberRepository extends Repository<Member,String> {
    void destroyAll();
}
