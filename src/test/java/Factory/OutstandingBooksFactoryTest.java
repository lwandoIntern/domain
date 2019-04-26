package Factory;

import book.Book;
import borrowingProccess.OutstandingBooks;
import members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class OutstandingBooksFactoryTest {

    private OutstandingBooks outstandingBooks;
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    @Before
    public void setUp() throws Exception {
        outstandingBooks = OutstandingBooksFactory.createOwed(books,members);
    }

    @Test
    public void createOwed() {
        Assert.assertEquals(outstandingBooks.getBooks(),outstandingBooks.getBooks());
    }
}