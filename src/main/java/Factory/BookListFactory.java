package Factory;

import book.Book;
import book.BookList;

import java.util.ArrayList;

public class BookListFactory {
    public static BookList createBookList(ArrayList<Book> books){
        return new BookList.Builder()
                .books(books)
                .build();
    }
}
