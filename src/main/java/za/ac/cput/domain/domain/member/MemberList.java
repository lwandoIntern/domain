package za.ac.cput.domain.domain.member;

import java.util.ArrayList;

public class MemberList {
    private ArrayList<Member> members;

    private MemberList(){}
    public MemberList(Builder builder){
        this.members = builder.members;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public static class Builder{
        private ArrayList<Member> members;

        public Builder members(ArrayList<Member> values){
            this.members = values;
            return this;
        }
        public Builder copy(MemberList memberList){
            this.members = memberList.members;
            return this;
        }
        public MemberList build(){
            return new MemberList(this);
        }
    }
}
