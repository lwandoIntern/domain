package za.ac.cput.domain.Factory;

import za.ac.cput.domain.Factory.loan.ReturnFactory;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.Return;
import za.ac.cput.domain.domain.members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReturnFactoryTest {

    private Return aReturn;
    private Book book;
    private Member member;
    @Before
    public void setUp() throws Exception {
        aReturn = ReturnFactory.createReturn(book,member);
    }

    @Test
    public void createReturn() {
        Assert.assertEquals(aReturn.getBook(),aReturn.getBook());
    }
}