package za.ac.cput.domain.Factory.member;

import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.domain.member.MemberList;

import java.util.ArrayList;

public class MemberListFactory {
    public static MemberList createMemberList(ArrayList<Member> members){
        return new MemberList.Builder()
                .members(members)
                .build();
    }
}
