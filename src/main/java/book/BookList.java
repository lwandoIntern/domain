package book;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books;

    private BookList(){}
    public BookList(Builder builder){
        this.books = builder.books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public static class Builder{
        private ArrayList<Book> books;

        public Builder books(ArrayList<Book> values){
            this.books = values;
            return this;
        }
        public Builder copy(BookList bookList){
            this.books = bookList.books;
            return this;
        }
        public BookList build(){
            return new BookList(this);
        }
    }

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                '}';
    }
}
