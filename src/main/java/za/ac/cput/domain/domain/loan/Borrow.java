package za.ac.cput.domain.domain.loan;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.member.Member;

import java.util.Objects;


public class Borrow {
    private String loanId;
    private Book book;
    private Member member;

    private  Borrow(){}
    private Borrow(Builder builder){
        this.loanId = builder.loanId;
        this.book = builder.book;
        this.member = builder.member;
    }

    public String getLoanId() {
        return loanId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public static class Builder{
        private String loanId;
        private Book book;
        private Member member;

        public Builder loanId(String s){
            this.loanId = s;
            return this;
        }
        public Builder book(Book val){
            this.book = val;
            return this;
        }
        public Builder member(Member val){
            this.member = val;
            return this;
        }
        public Builder copy(Borrow borrow){
            this.book = borrow.book;
            this.member = borrow.member;
            return this;
        }
        public Borrow build(){
            return new Borrow(this);
        }
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "loanId='" + loanId + '\'' +
                ", za.ac.cput.domain.domain.author.book=" + book +
                ", member=" + member +
                '}';
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
