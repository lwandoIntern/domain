package za.ac.cput.domain.Factory.books;

import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.book.BookList;

import java.util.ArrayList;

public class BookListFactory {
    public static BookList createBookList(ArrayList<Book> books){
        return new BookList.Builder()
                .books(books)
                .build();
    }
}