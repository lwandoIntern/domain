package members;

public class StudentMember extends Member{
    private int borrowingAmountAllowed;

    public StudentMember(Builder builder) {
        super(builder);
    }

    public int getBorrowingAmountAllowed() {
        return borrowingAmountAllowed;
    }

    public static class Builder extends Member.Builder{
        private int borrowingAmountAllowed;

        public Builder borrowingAmountAllowed(int val){
            this.borrowingAmountAllowed = val;
            return this;
        }
        public StudentMember build(){
            return new StudentMember(this);
        }
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "borrowingAmountAllowed=" + borrowingAmountAllowed +
                '}';
    }
}
