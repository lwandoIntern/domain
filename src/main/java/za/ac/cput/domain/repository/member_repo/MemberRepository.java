package za.ac.cput.domain.repository.member_repo;

import za.ac.cput.domain.domain.members.Member;
import za.ac.cput.domain.repository.Repository;

public interface MemberRepository extends Repository<Member,String> {
    void destroyAll();
}
