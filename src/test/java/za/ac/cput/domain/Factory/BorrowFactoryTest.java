package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.loan.BorrowFactory;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.Borrow;
import za.ac.cput.domain.domain.members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BorrowFactoryTest {

    private Borrow borrow;
    private Book book;
    private Member member;
    @Before
    public void setUp() throws Exception {
        borrow = BorrowFactory.createLoan("1",book,member);
    }

    @Test
    public void createLoan() {
        Assert.assertEquals(borrow.getBook(),borrow.getMember());
    }
}