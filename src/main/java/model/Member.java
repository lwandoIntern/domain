package model;

public class Member {
    private String name,surname,address;
    private boolean owing;
    private String memberNumber;

    private Member(){}
    public Member(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.owing = builder.owing;
        this.memberNumber = builder.memberNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOwing() {
        return owing;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public static class Builder{
        private String name,surname,address;
        private boolean owing;
        private String memberNumber;

        public Builder memberNumber(String value){
            this.memberNumber = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder surname(String value){
            this.surname = value;
            return this;
        }
        public Builder address(String value){
            this.address = value;
            return this;
        }
        public Builder owing(boolean value){
            this.owing = value;
            return this;
        }
        public Builder copy(Member member){
            this.owing = member.owing;
            this.name = member.name;
            this.memberNumber = member.memberNumber;
            this.surname = member.surname;
            this.address = member.address;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", owing=" + owing +
                ", memberNumber=" + memberNumber +
                '}';
    }
}
