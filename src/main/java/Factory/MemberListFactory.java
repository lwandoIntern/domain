package Factory;

import members.Member;
import members.MemberList;

import java.util.ArrayList;

public class MemberListFactory {
    public static MemberList createMemberList(ArrayList<Member> members){
        return new MemberList.Builder()
                .members(members)
                .build();
    }
}
