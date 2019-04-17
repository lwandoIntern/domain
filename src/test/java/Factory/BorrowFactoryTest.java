package Factory;

import book.Book;
import borrowingProccess.Borrow;
import members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BorrowFactoryTest {

    private Borrow borrow;
    private Book book;
    private Member member;
    @Before
    public void setUp() throws Exception {
        borrow = BorrowFactory.createLoan(book,member);
    }

    @Test
    public void createLoan() {
        Assert.assertEquals(borrow.getBook(),borrow.getMember());
    }
}