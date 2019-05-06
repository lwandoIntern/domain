package za.ac.cput.domain.domain.borrowingProccess;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.members.Member;

import javax.persistence.Entity;


public class Return {

    private Book book;
    private Member member;

    private Return(){}
    public Return(Builder builder){
        this.book = builder.book;
        this.member = builder.member;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public static class Builder{
        private Book book;
        private Member member;

        public Builder book(Book book){
            this.book = book;
            return this;
        }
        public Builder member(Member member){
            this.member = member;
            return this;
        }
        public Return build(){
            return new Return(this);
        }
    }
}
