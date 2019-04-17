package borrowingProccess;

import book.Book;
import members.Member;

public class Borrow {
    private Book book;
    private Member member;

    private  Borrow(){}
    private Borrow(Builder builder){
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
}
