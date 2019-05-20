package za.ac.cput.domain.repository.member;

import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.repository.Repository;

public interface MemberRepository extends Repository<Member,String> {
    void destroyAll();
}
