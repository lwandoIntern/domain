package Factory;

import model.Member;

public class MemberFactory {
    public static Member createMember(String memNum,String name, String surname, String address, boolean owe){
        return new Member.Builder()
                .memberNumber(memNum)
                .name(name)
                .surname(surname)
                .address(address)
                .owing(owe)
                .build();
    }
}
