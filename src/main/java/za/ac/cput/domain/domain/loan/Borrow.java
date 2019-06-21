package za.ac.cput.domain.domain.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.member.Member;

import java.util.Objects;


public class Borrow {
    private String loanId;
    private String duration;

    private  Borrow(){}
    private Borrow(Builder builder){
        this.loanId = builder.loanId;
        this.duration = builder.duration;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getDuration() {
        return duration;
    }

    public static class Builder{
        private String loanId;
        private String duration;

        public Builder loanId(String s){
            this.loanId = s;
            return this;
        }
        public Builder duration(String val){
            this.duration = val;
            return this;
        }
        public Borrow build(){
            return new Borrow(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return loanId.equals(borrow.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId);
    }
}
