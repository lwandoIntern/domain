package Factory;

import book.Book;
import borrowingProccess.Return;
import members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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