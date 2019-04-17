package Factory;

import book.Book;
import book.BookList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookListFactoryTest {

    private BookList bookList;
    private ArrayList<Book> books;
    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        bookList = BookListFactory.createBookList(books);
    }

    @Test
    public void createBookList() {
        Assert.assertEquals(bookList.getBooks(),bookList.getBooks());
    }
}