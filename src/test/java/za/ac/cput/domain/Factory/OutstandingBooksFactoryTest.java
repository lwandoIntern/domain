package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.loan.OutstandingBooksFactory;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.OutstandingBooks;
import za.ac.cput.domain.domain.members.Member;
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