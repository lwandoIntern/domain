package za.ac.cput.domain.domain.borrowingProccess;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.members.Member;

import java.util.ArrayList;

public class OutstandingBooks {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    private OutstandingBooks(){}
    public OutstandingBooks(Builder builder){
        this.books = builder.books;
        this.members = builder.members;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public static class Builder{
        private ArrayList<Book> books;
        private ArrayList<Member> members;

        public Builder books(ArrayList<Book> vals){
            this.books = vals;
            return this;
        }
        public Builder members(ArrayList<Member> vals){
            this.members = vals;
            return this;
        }
        public Builder copy(OutstandingBooks outstandingBooks){
            this.members = outstandingBooks.members;
            this.books = outstandingBooks.books;
            return this;
        }
        public OutstandingBooks build(){
            return new OutstandingBooks(this);
        }
    }

    @Override
    public String toString() {
        return "OutstandingBooks{" +
                "books=" + books +
                ", za.ac.cput.domain.domain.members=" + members +
                '}';
    }
}
